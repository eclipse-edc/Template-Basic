# Template Basic

This repository serves as a template for new EDC repositories. 

It can also be used by adopters that
want to build their dataspace component based on the EDC.

## How to use this repository

### 1. Create repository

Select "Use this template > Create a new repository". See the [GitHub guide](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template) for details.

### 2. Configure secrets

The default workflows need the following secrets:

| Secret                   | Workflow(s)                                                                                                                                                                          | Comment                         |
|:-------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:--------------------------------|
| `DISCORD_WEBHOOK_GITHUB` | [discord-webhook.yml](.github/workflows/discord-webhook.yml)                                                                                                                         | webhook URL of Discord channel  |
| `GITHUB_TOKEN`           | [first-interaction.yml](.github/workflows/first-interaction.yml), [scan-pull-request.yml](.github/workflows/scan-pull-request.yml), [stale-bot.yml](.github/workflows/stale-bot.yml) | _usually already set_           |
| `ORGANIZATION_PROJECT`   | [add-to-project.yml](.github/workflows/add-to-project.yml)                                                                                                                           | _already set for EDC org_       |

### 3. Update files

Update (at least) the following files:
- [ ] [README](README.md)
- [ ] line 28 in [NOTICE](NOTICE.md)
- [ ] lines 2, 5-7, and 10-11 in [gradle.properties](gradle.properties)
- [ ] lines 2, 11, and 15 in [settings.gradle.kts](settings.gradle.kts)
- [ ] lines 2 and 11 in [build.gradle.kts](build.gradle.kts)
- [ ] [gradle/libs.versions.toml](gradle/libs.versions.toml)
- [ ] lines 28 and 30 in [version-catalog/build.gradle.kts](version-catalog/build.gradle.kts)
- [ ] [CODEOWNERS](.github/CODEOWNERS)

### 4. Add content

Fill or delete:
- [ ] [core](): Contains all absolutely essential building that is necessary to run the component.
- [ ] [extensions](): This contains code that extends the component's core functionality with technology-specific code.
- [ ] [launchers](): Launchers are essentially EDC packages that are runnable, e.g., gradle buildfile, Dockerfile
- [ ] [spi](): This is the primary extension point for the code. It contains all necessary interfaces that need to be implemented
  as well as essential model classes and enums. Basically, the `spi` modules defines the extent to what users can customize and extend the code.
- [ ] [system-tests](): The system tests verify the end-to-end deployment of a component. They can be run locally (using Docker, Kubernetes) or in a pipeline.


## Documentation

Developer documentation can be found under [docs/developer](docs/developer/), where the main concepts
and decisions are captured as [decision records](docs/developer/decision-records/).

## Contributing

See [how to contribute](CONTRIBUTING.md) for details.