pluginManagement {
    repositories {
        mavenCentral()
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }
}
rootProject.name="HelloMPP"
include(":android", ":common")
