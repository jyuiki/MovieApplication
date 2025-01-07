plugins {
    id("module.android")
}
android {
    namespace = "ted.gun0912.movie.device"
}

dependencies {
    implementation(projects.design)
    implementation(projects.component)

    implementation(libs.androidx.core)
    implementation(libs.material)
    implementation("androidx.ads:ads-identifier:1.0.0-alpha04")
}
