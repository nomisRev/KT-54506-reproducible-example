# KT-54506

To reproduce simply run `./gradlew build` twice. The first time the project will fail with a broken test, and the second time it will pass with a false-positive.

See output below:

```text
simonvergauwen@Simons-MacBook-Pro false-positive-build % ./gradlew build
Starting a Gradle Daemon, 1 incompatible and 2 stopped Daemons could not be reused, use --status for details

> Configure project :
Kotlin Multiplatform Projects are an Alpha feature. See: https://kotlinlang.org/docs/reference/evolution/components-stability.html. To hide this message, add 'kotlin.mpp.stability.nowarn=true' to the Gradle properties.

The property 'kotlin.mpp.enableGranularSourceSetsMetadata=true' has no effect in this and future Kotlin versions, as Hierarchical Structures support is now enabled by default. It is safe to remove the property.

The property 'kotlin.native.enableDependencyPropagation=false' has no effect in this and future Kotlin versions, as Kotlin/Native dependency commonization is now enabled by default. It is safe to remove the property.


> Task :nativeTest

MainTest.assertMessage FAILED
kotlin.AssertionError at /opt/buildAgent/work/5f69639f351c4725/kotlin/kotlin-native/runtime/src/main/kotlin/kotlin/Throwable.kt:25

1 test completed, 1 failed
There were failing tests

> Task :allTests FAILED

FAILURE: Build failed with an exception.

* What went wrong:
  Execution failed for task ':allTests'.
> There were failing tests. See the report at: file:///Users/simonvergauwen/Developer/false-positive-build/build/reports/tests/allTests/index.html

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.

* Get more help at https://help.gradle.org

Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

See https://docs.gradle.org/7.4.2/userguide/command_line_interface.html#sec:command_line_warnings

BUILD FAILED in 14s
11 actionable tasks: 11 executed
simonvergauwen@Simons-MacBook-Pro false-positive-build % ./gradlew build

> Configure project :
Kotlin Multiplatform Projects are an Alpha feature. See: https://kotlinlang.org/docs/reference/evolution/components-stability.html. To hide this message, add 'kotlin.mpp.stability.nowarn=true' to the Gradle properties.

The property 'kotlin.mpp.enableGranularSourceSetsMetadata=true' has no effect in this and future Kotlin versions, as Hierarchical Structures support is now enabled by default. It is safe to remove the property.

The property 'kotlin.native.enableDependencyPropagation=false' has no effect in this and future Kotlin versions, as Kotlin/Native dependency commonization is now enabled by default. It is safe to remove the property.


Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

See https://docs.gradle.org/7.4.2/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 448ms
11 actionable tasks: 1 executed, 10 up-to-date
simonvergauwen@Simons-MacBook-Pro false-positive-build % 
```text