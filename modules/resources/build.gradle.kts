/*
 * Copyright 2019 Louis Cognault Ayeva Derman. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    `maven-publish`
}

android {
    setDefaults()
    buildTypes.getByName("release").consumerProguardFiles("proguard-rules.pro")
}

kotlin {
    android()
    configure(targets) { configureMavenPublication() }
    sourceSets {
        androidMain.dependencies {
            api(Kotlin.stdlib.jdk7)
            api(AndroidX.annotation)
            compileOnly(AndroidX.fragment)
            implementation(splitties("appctx"))
            implementation(splitties("mainthread"))
        }
    }
}

afterEvaluate {
    publishing {
        setupAllPublications(project)
    }
}
