plugins {
    id("java")
    `maven-publish`
}

group = "com.nickcoblentz.montoya.libraries"
version = "0.5.0"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.portswigger.burp.extensions:montoya-api:+")
}

tasks.test {
    useJUnitPlatform()
}

//Run -> Edit Configuration -> Gradle-Publish, Environment Variables: USERNAME and TOKEN

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ncoblentz/burpmontoyautilities")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GHUSERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GHTOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}