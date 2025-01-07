plugins {
    id("module.android")
}

android {
    namespace = "ted.gun0912.movie.common"
}

dependencies {
    implementation(projects.component)
    implementation(libs.gson)
}
