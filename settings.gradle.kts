pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Milkify"
include(":app")
include(":core:utils")
include(":core:networking")
include(":core:designsystem")
include(":core:data")
include(":core:model")
include(":feature")
include(":feature:authentication")
