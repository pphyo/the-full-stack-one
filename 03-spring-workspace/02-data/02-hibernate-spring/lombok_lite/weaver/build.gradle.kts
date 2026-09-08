plugins {
	application
}

dependencies {
	implementation(project(":annotations"))

	implementation("org.ow2.asm:asm:9.10.1")
	implementation("org.ow2.asm:asm-util:9.10.1")
}

application {
	mainClass.set("com.codoverse.asm.weaver.ConstructorWeaverMain")
}