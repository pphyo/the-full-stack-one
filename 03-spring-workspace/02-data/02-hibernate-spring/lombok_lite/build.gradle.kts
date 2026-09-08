allprojects {
	group = "com.codoverse.asm"
	version = "1.0.0"
	
	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "java")
	
	configure<JavaPluginExtension> {
	    toolchain {
	        languageVersion.set(JavaLanguageVersion.of(25))
	    }
    }
    
    tasks.withType<JavaCompile>().configureEach {
    	options.release.set(25)
    	options.encoding = "UTF-8"
    }

}
