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
include("profolio-common")
include("profolio-domain:profolio-domain-redis")
findProject(":profolio-domain:profolio-domain-redis")?.name = "profolio-domain-redis"
