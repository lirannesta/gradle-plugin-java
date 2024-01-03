# Gradle plugin with maven publishing
## Description
This Gradle project is designed to demonstrate the implementation of a Gradle plugin written in Java and the process of publishing it to an internal Maven repository.

## Requirements
Gradle installed on your system (version X.X.X or higher)
Access to an internal Maven repository (e.g., Nexus, Artifactory)
Getting Started
Clone this repository to your local machine:

```sh
git clone https://github.com/lirannesta/gradle-plugin-java.git
```
Navigate to the project directory:

```sh
cd gradle-plugin-java
```
Implementation of the Gradle plugin is in the src/main/java directory.

Update the necessary publishing configurations in the build.gradle file to point to your internal Maven repository.

change the repository names inside gradle.properties file of the project.
define the following parameters in your gradle.properties file
- artifactory_url=<YOUR_ARTIFACTORY_URL>
- artifactory_username=<YOUR_ARTIFACTORY_USERNAME>
- artifactory_password=<YOUR_ARTIFACTORY_PASSWORD>

Under:
Windows: C:\Users\YourUsername\.gradle\gradle.properties
Linux/Unix: /home/YourUsername/.gradle/gradle.properties
macOS: /Users/YourUsername/.gradle/gradle.properties


## Usage
To build the project, run:
```sh
./gradlew build
```
To publish the plugin to your internal Maven repository, execute:

```sh
./gradlew publish
```

## published artifacts:
The published artifact consist of a marker for the plugin , as well as the packaged plugin artifact
[YOUR_REPOSITORY_NAME]

    com
        build
            com.example.build.gradle.plugin <--------------------------The marker
                1.0.0
                    com.example.build.gradle.plugin.1.0.0.pom
                    com.example.build.gradle.plugin.1.0.0.pom.sha512
                    maven-metadata.xml
                    maven-metadata.xml.sha512
            example-plugin <------------------------------------------- The plugin code
                1.0.0
                    example-plugin-1.0.0.jar
                    example-plugin-1.0.0.jar.sha512
                    example-plugin-1.0.0.module
                    example-plugin-1.0.0.module.sha512
                    example-plugin-1.0.0.pom
                    example-plugin-1.0.0.pom.sha512
                    maven-metadata.xml
                    maven-metadata.xml.sha512


## Additional Information
[Gradle plugin documentation](https://docs.gradle.org/current/userguide/custom_plugins.html#sec:custom_plugins_standalone_project)

[Gradle marker artifact](https://docs.gradle.org/current/userguide/plugins.html#sec:plugin_markers)


Customize the plugin's behavior by modifying the plugin's Java code in the src/main/java directory.
Ensure that your internal Maven repository credentials are properly configured in the build.gradle file to successfully publish the plugin.

## Consuming the plugin

settings.gradle:

    pluginManagement {
        repositories {
            maven {
                url = uri(repoLocation)
            }
        }
    }

build.gradle:

    plugins {
        id 'org.example.greeting' version '1.0.0'
    }

Followups:
Consuming the plugin repository.
Tests for the plugin in this repository.
