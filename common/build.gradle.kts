plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

androidCommon()
android {
    sourceSets.forEach {
        it.manifest.srcFile("src/androidMain/AndroidManifest.xml")
    }
}

kotlin {
    /* Targets configuration omitted.
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */
    android("android")
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.Kotlin.common)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(Dependencies.Kotlin.jvm)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.Kotlin.jvm)
            }
        }
    }
}
