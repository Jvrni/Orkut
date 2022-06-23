import org.gradle.api.artifacts.dsl.DependencyHandler


object AppDependencies {
    //std lib
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    private const val composeUi = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    private const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    private const val composeNav = "androidx.navigation:navigation-compose:${Versions.composeNav}"
    private const val composeNavAnim = "com.google.accompanist:accompanist-navigation-animation:${Versions.composeNavAnim}"
    private const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"
    private const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val ComposeConstraint = "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"
    private const val pager = "com.google.accompanist:accompanist-pager:${Versions.pager}"
    private const val pagerIndicator = "com.google.accompanist:accompanist-pager-indicators:${Versions.pager}"
    private const val systemUi = "com.google.accompanist:accompanist-systemuicontroller:${Versions.systemUi}"


    //Moshi
    private const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    private const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    private const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"

    //koin
    private const val koinCore = "io.insert-koin:koin-core:${Versions.koinCore}"

    //hilt
    private const val composeNavHilt = "androidx.hilt:hilt-navigation-compose:${Versions.composeNavHilt}"
    private const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    private const val hiltDaggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private const val composeUiJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    private const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    val appLibraries = mutableListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(composeMaterial)
        add(composeUi)
        add(composeActivity)
        add(composeNav)
        add(composeNavAnim)
        add(lifeCycle)
        add(hilt)
        add(composeNavHilt)
        add(lottie)
        add(ComposeConstraint)
        add(pager)
        add(pagerIndicator)
        add(systemUi)
    }

    val serviceLibraries = mutableListOf<String>().apply {
        add(kotlinStdLib)
        add(hilt)
        add(coreKtx)
        add(moshi)
        add(moshiKotlin)
    }

    val kaptLibraries = mutableListOf<String>().apply {
        add(hiltDaggerCompiler)
    }

    val androidTestLibraries = mutableListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(composeUiJunit)
    }

    val testLibraries = mutableListOf<String>().apply {
        add(junit)
    }

    val debugTestLibraries = mutableListOf<String>().apply {
        add(composeUiTooling)
    }
}

//util functions for adding the different type dependencies from build.gradle.kts.kts.kts file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}