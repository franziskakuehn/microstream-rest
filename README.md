### Overview

This project was taken from [micronaut-micronaut on jcon](https://github.com/sdelamo/jcon2023-micronaut-aws-microstream) and extended with local s3 access over minio, guided by [micronaut-microstream-documentation](https://micronaut-projects.github.io/micronaut-microstream/snapshot/guide/).
Minio is setup in a local Kubernetes with helm installation, see minio_on_kubernetes.
Setup with Gradle and Micronaut-MicroStream version 4.
It includes the setup of Microstream RestUI and some interaction with MicroStream-storage over provided Rest implementation by MicroStream.

## Micronaut 3.9.3 Documentation

- [User Guide](https://docs.micronaut.io/3.9.3/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.9.3/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.9.3/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature microstream documentation

- [Micronaut MicroStream documentation](https://micronaut-projects.github.io/micronaut-microstream/latest/guide)

- [https://microstream.one/](https://microstream.one/)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

```bash
microstream.storage.main.storage-directory=build/devdata
microstream.storage.main.root-class=orange.business.jhub.FruitContainer
```

```bash
curl -i localhost:9091/fruits

curl -i localhost:9091/fruits/Pear

curl -i -d '{"name":"Pear"}' -H "Content-Type: application/json" -X POST http://localhost:9091/fruits

curl -i localhost:9091/fruits/count

curl -X DELETE -d '{"name":"Pear"}' localhost:9091/fruits
```

### start rest gui:

```bash
mvn dependency:get -Dartifact=one.microstream:microstream-storage-restclient-app:{maven-version}:jar -Dtransitive=false -Ddest=storage.restclient.app-{maven-version}.jar
```

download here:
-[download](https://repo1.maven.org/maven2/one/microstream/microstream-storage-restclient-app/08.01.01-MS-GA/microstream-storage-restclient-app-08.01.01-MS-GA.jar)

```bash
java -jar microstream-storage-restclient-app-08.01.01-MS-GA.jar --server.port=8888
```

http://localhost:8888/

http://localhost:9091/microstream

```
./gradlew run
```



