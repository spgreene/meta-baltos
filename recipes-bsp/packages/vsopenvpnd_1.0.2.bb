DESCRIPTION = "VScom viaVPN Daemon"
SECTION = "libs"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

RDEPENDS_vsopenvpnd = "openvpn libonrisc json-c xmlrpc-c curl"
SRC_URI = "ftp://ftp.visionsystems.de/pub/multiio/OnRISC/Baltos/viaVPN/yocto/morty/${BPN}-${PV}.tar.xz"

CLEANBROKEN = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

do_compile() {
	:
}

do_install () {
	mkdir -p ${D}/usr/bin/
	install -m 0755 ${WORKDIR}/vsopenvpnd-${PV}/vsopenvpnd ${D}/usr/bin/
}

SRC_URI[md5sum] = "b0cac2217880aa280a6cab2962ff05b5"
SRC_URI[sha256sum] = "0423890306ffa792f283e496799e2d979246fc4f4e995e15da422a1de3d44c0b"
