repositories {
    mavenCentral()
    google()
}

plugins {
    `kotlin-dsl`
}

dependencies {
    // This constant is duplicated in root/build.gradle.kts. Make sure to also update there
    implementation("com.android.tools.build:gradle:7.0.4")
    // Without this dependency the compiler has problems with inline Composables
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
}