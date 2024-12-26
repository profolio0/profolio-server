plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "profolio"
include("profolio-application")
include("profolio-infrastructure")

// domain
include("profolio-domain")
include("profolio-domain:profolio-domain-rds")
findProject(":profolio-domain:profolio-domain-rds")?.name = "profolio-domain-rds"
