plugins {
    id("java")
}

group = "com.rest"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
val ownerVersion = "1.0.9"
val assertjVersion = "3.22.0"

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
    implementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("io.rest-assured:rest-assured:6.0.0")
    implementation("org.projectlombok:lombok:1.18.42")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.20.1")
    implementation("org.aeonbits.owner:owner:$ownerVersion")
    implementation("org.assertj:assertj-core:${assertjVersion}")
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("org.apache.logging.log4j:log4j-api:2.23.1")
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.23.1")

}

tasks.test {
    useJUnitPlatform()
}