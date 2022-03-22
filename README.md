# iris
iris is a java Vert.x service which calls french energy actors web services like SGE from Enedis (Distribution Network Operator) or Sinapse from Soregies (Provider)
## Setup runtime with SDKMAN! on UNIX-like platforms
To quickly install the runtime used by iris, it's strongly recommended to use SDKMAN!
It's a tool for managing parallel versions of multiple SDK on most Unix based systems.
Follow these commands to install SDKMAN!
```
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
```
If SDKMAN! is correctly installed, then the last command will show the installed version of it.
### Java Runtime
iris is working on JVM ecosystem. So, you have to install a JDK to build & develop in Java.
The current Java major version used is Java 17. The JDK implementation used is OpenJDK.
The following command will install Java in `~/.sdkman/candidates/java`
```
sdk install java 17.y.z-open
```
### Gradle Build Tool
The most popular Build Tool for JVM Ecosystem is Gradle. It provides a strong set of features and a high-level of integration in many systems.
The current Gradle major version used is 7.3. https://docs.gradle.org/current/userguide/compatibility.html
```
sdk install gradle 7.3
```
