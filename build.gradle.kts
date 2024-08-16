/*
 *  Copyright (c) [YEAR] [ORGANIZATION]
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       [ORGANIZATION] - initial API and implementation
 *
 */

plugins {
    `java-library`
}

val annotationProcessorVersion: String by project
val metaModelVersion: String by project

buildscript {
    dependencies {
        val edcGradlePluginsVersion: String by project
        classpath("org.eclipse.edc.edc-build:org.eclipse.edc.edc-build.gradle.plugin:${edcGradlePluginsVersion}")
    }
}

allprojects {
    apply(plugin = "${group}.edc-build")

    // configure which version of the annotation processor to use. defaults to the same version as the plugin
    configure<org.eclipse.edc.plugins.autodoc.AutodocExtension> {
        processorVersion.set(annotationProcessorVersion)
        outputDirectory.set(project.layout.buildDirectory.asFile)
    }

    configure<org.eclipse.edc.plugins.edcbuild.extensions.BuildExtension> {
        versions {
            // override default dependency versions here
            metaModel.set(metaModelVersion)
        }
        pom {
            scmUrl.set("https://github.com/OWNER/REPO.git")
            scmConnection.set("scm:git:git@github.com:OWNER/REPO.git")
            developerName.set("yourcompany")
            developerEmail.set("admin@yourcompany.com")
            projectName.set("your cool project based on EDC")
            projectUrl.set("www.coolproject.com")
            description.set("your description")
            licenseUrl.set("https://opensource.org/licenses/MIT")
        }
    }

}