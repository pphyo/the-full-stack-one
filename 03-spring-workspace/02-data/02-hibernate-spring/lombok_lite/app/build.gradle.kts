import org.gradle.api.attributes.Usage

plugins {
    application
}

dependencies {
    implementation(project(":annotations"))
}

val weaverRuntime: Configuration by configurations.creating {
    isCanBeResolved = true
    isCanBeConsumed = false
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage::class.java, Usage.JAVA_RUNTIME))
    }
}

dependencies {
    weaverRuntime(project(":weaver"))
}

application {
    mainClass.set("com.codoverse.app.Main")
}

val javaClassesDir = sourceSets.main.get().java.destinationDirectory

val weaveConstructors by tasks.registering(JavaExec::class) {
    group = "build"
    description = "Injects @CustomArgsConstructor constructors into compiled classes via ASM."

    dependsOn(tasks.compileJava)
    classpath = weaverRuntime
    mainClass.set("com.codoverse.asm.weaver.ConstructorWeaverMain")
    args(javaClassesDir.get().asFile.absolutePath)

    // This task mutates .class files in place — same directory as both
    // input and output — which Gradle's automatic dependency inference
    // can't represent (it sees itself as its own producer -> cycle).
    // Ordering is already explicit via dependsOn/finalizedBy, so opt
    // this task out of state tracking rather than fight the inference.
    doNotTrackState("Mutates compileJava's output directory in place; explicit dependsOn/finalizedBy handles ordering")
}

tasks.compileJava {
    finalizedBy(weaveConstructors)
}
tasks.named("classes") {
    dependsOn(weaveConstructors)
}
tasks.named<JavaExec>("run") {
    dependsOn(weaveConstructors)
}
tasks.test {
    dependsOn(weaveConstructors)
}