DESCRIPTION = "OnRISC Hardware API Library"
SECTION = "libs"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

DEPENDS = "eudev libsoc"
SRC_URI = "git://github.com/visionsystemsgmbh/libonrisc.git;protocol=https"

PV = "1.0+git${SRCPV}"
SRCREV = "1.5.4"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""
