# This file was derived from the linux-yocto-custom.bb recipe in
# oe-core.
#
# linux-yocto-custom.bb:
#
#   A yocto-bsp-generated kernel recipe that uses the linux-yocto and
#   oe-core kernel classes to apply a subset of yocto kernel
#   management to git managed kernel repositories.
#
# Warning:
#
#   Building this kernel without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition:
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition:
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

python __anonymous () {
	depends = d.getVar("DEPENDS", True)
	depends = "%s u-boot-mkimage-native dtc-native" % depends
	d.setVar("DEPENDS", depends)
}

do_create_fitimage() {
	cp ${THISDIR}/linux-yocto-custom/kernel-fit.its ${DEPLOY_DIR_IMAGE}
	uboot-mkimage -f ${DEPLOY_DIR_IMAGE}/kernel-fit.its ${DEPLOY_DIR_IMAGE}/kernel-fit.itb
}

addtask create_fitimage before do_packagedata after do_deploy

KBRANCH = "linux-3.18.y"
KCONFIG_MODE = "--alldefconfig"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1;branch=${KBRANCH}"
SRC_URI += "file://defconfig"
SRC_URI += "file://baltos.scc \
           "

LINUX_VERSION ?= "3.18"
LINUX_VERSION_EXTENSION ?= ""

SRCREV="${AUTOREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_baltos = "baltos"
