plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "profolio"
include("application")
include("infrastructure")

// domain
include("domain")
include("domain:domain-rds")
findProject(":domain:domain-rds")?.name = "domain-rds"
