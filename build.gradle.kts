plugins {
    kotlin("multiplatform") version "1.7.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    
    val nativeTarget = when {
        hostOs == "Mac OS X" -> when (System.getProperty("os.arch")) {
            "aarch64" -> macosArm64("native")
            else -> macosX64("native")
        }
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    sourceSets {
        val nativeMain by getting
        val nativeTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
