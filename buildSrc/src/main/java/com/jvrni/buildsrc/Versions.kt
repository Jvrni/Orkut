import org.gradle.api.artifacts.dsl.DependencyHandler


//version constants for the Kotlin DSL dependencies
object Versions {
    //app level
    const val gradle = "7.1.0"
    const val kotlin = "1.6.10"

    //libs
    const val coreKtx = "1.7.0"
    const val compose = "1.1.0"
    const val composeConstraint = "1.0.0"
    const val lifecycle = "2.3.1"
    const val composeActivity = "1.3.1"
    const val composeNav = "2.4.1"
    const val composeNavAnim = "0.24.5-alpha"
    const val composeNavHilt = "1.0.0"
    const val viewModelHilt = "1.0.0-alpha03"
    const val lottie = "5.0.3"
    const val koinCore = "3.2.0"
    const val hilt = "2.41"
    const val pager = "0.24.5-alpha"
    const val systemUi = "0.23.1"
    const val moshiVersion = "1.13.0"

    //test
    const val junit = "4.13.2"
    const val extJunit = "1.1.3"
    const val espresso = "3.4.0"
}
