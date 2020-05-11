import com.android.build.gradle.internal.tasks.factory.dependsOn
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

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

val ideaActive = System.getProperty("idea.active") == "true"

kotlin {
    val buildForDevice = project.findProperty("device") as? Boolean ?: false
    fun iosTarget(configure: KotlinNativeTarget.() -> Unit) = if(buildForDevice) {
        iosArm64("ios", configure)
    } else {
        iosX64("ios", configure)
    }

    android("android")
    jvm()
    iosTarget {
        binaries {
            framework {
                freeCompilerArgs += "-Xobjc-generics"
            }
        }
    }

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
        val iosMain by getting {
        }
    }
}
