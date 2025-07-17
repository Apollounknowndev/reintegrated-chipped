plugins {
    kotlin("jvm") version "2.1.0"
    id("earth.terrarium.cloche") version "0.11.6"
}

repositories {
    cloche {
        mavenNeoforgedMeta()
        mavenNeoforged()
        mavenForge()
        mavenFabric()
        mavenParchment()
        librariesMinecraft()
        main()
    }
    mavenCentral()
    maven("https://api.modrinth.com/maven")
    maven("https://maven.teamresourceful.com/repository/maven-public/")
}

group = "dev.worldgen.reintegrated.chipped"
version = "1.0.1"

cloche {
    mappings {
        official()
    }

    metadata {
        modId = "reintegrated_chipped"
        name = "Reintegrated Chipped"
        description = "Integrated the Chipped mod into the vanilla world."
        license = "MIT"
        icon = "pack.png"

        author("Apollo")
    }

    val shared120 = common("shared:1.20") {
        dependencies {
            compileOnly("earth.terrarium.chipped:chipped-common-1.20.1:3.0.7")
            compileOnly("earth.terrarium.athena:athena-common-1.20.1:3.1.1")
            compileOnly("com.teamresourceful.resourcefullib:resourcefullib-common-1.20.1:2.1.29")
        }
    }
    val shared121 = common("shared:1.21") {
        dependencies {
            compileOnly("earth.terrarium.chipped:chipped-common-1.21.1:4.0.2")
            compileOnly("earth.terrarium.athena:athena-common-1.21:4.0.1")
            compileOnly("com.teamresourceful.resourcefullib:resourcefullib-common-1.21:3.0.12")
        }
    }

    fabric("fabric:1.20.1") {
        dependsOn(shared120)
        loaderVersion = "0.16.13"
        minecraftVersion = "1.20.1"

        dependencies {
            fabricApi("0.92.6")
            modRuntimeOnly("maven.modrinth:lithostitched:1.4.11-fabric-1.20")
            modRuntimeOnly("earth.terrarium.chipped:chipped-fabric-1.20.1:3.0.7")
            modRuntimeOnly("earth.terrarium.athena:athena-fabric-1.20.1:3.1.1")
            modRuntimeOnly("com.teamresourceful.resourcefullib:resourcefullib-fabric-1.20.1:2.1.29")
        }

        includedClient()
        runs {
            client()
            server()
        }

        metadata {
            dependencies {
                dependency {
                    modId = "lithostitched"
                    required = true
                    version("1.4.11")
                }
            }
            entrypoint("client", "dev.worldgen.reintegrated.ReChippedFabricClient")
        }
    }

    fabric("fabric:1.21.1") {
        dependsOn(shared121)
        loaderVersion = "0.16.13"
        minecraftVersion = "1.21.1"

        dependencies {
            fabricApi("0.116.1")
            modRuntimeOnly("maven.modrinth:lithostitched:1.4.11-fabric-1.21")
            modRuntimeOnly("earth.terrarium.chipped:chipped-fabric-1.21.1:4.0.2")
            modRuntimeOnly("earth.terrarium.athena:athena-fabric-1.21:4.0.1")
            modRuntimeOnly("com.teamresourceful.resourcefullib:resourcefullib-fabric-1.21:3.0.12")
        }

        includedClient()
        runs {
            client()
            server()
        }

        metadata {
            dependencies {
                dependency {
                    modId = "lithostitched"
                    required = true
                    version("1.4.11")
                }
                dependency {
                    modId = "chipped"
                    required = true
                }
            }
            entrypoint("client", "dev.worldgen.reintegrated.ReChippedFabricClient")
        }
    }

    forge("forge:1.20.1") {
        dependsOn(shared120)
        loaderVersion = "47.4.0"
        minecraftVersion = "1.20.1"

        dependencies {
            modRuntimeOnly("maven.modrinth:lithostitched:1.4.11-forge-1.20")
            modRuntimeOnly("earth.terrarium.chipped:chipped-forge-1.20.1:3.0.7")
            modRuntimeOnly("earth.terrarium.athena:athena-forge-1.20.1:3.1.1")
            modRuntimeOnly("com.teamresourceful.resourcefullib:resourcefullib-forge-1.20.1:2.1.29")
        }

        runs {
            client()
            server()
        }

        metadata {
            dependencies {
                dependency {
                    modId = "lithostitched"
                    required = true
                    version("1.4.11")
                }
            }
        }
    }

    neoforge("neoforge:1.21.1") {
        dependsOn(shared121)
        loaderVersion = "21.1.192"
        minecraftVersion = "1.21.1"

        dependencies {
            modRuntimeOnly("maven.modrinth:lithostitched:1.4.11-neoforge-1.21")

            modRuntimeOnly("earth.terrarium.chipped:chipped-neoforge-1.21.1:4.0.2")
            modRuntimeOnly("earth.terrarium.athena:athena-neoforge-1.21:4.0.1")
            modRuntimeOnly("com.teamresourceful.resourcefullib:resourcefullib-neoforge-1.21:3.0.12")
        }

        runs {
            client()
            server()
        }

        metadata {
            dependencies {
                dependency {
                    modId = "lithostitched"
                    required = true
                    version("1.4.11")
                }
            }
        }
    }
}