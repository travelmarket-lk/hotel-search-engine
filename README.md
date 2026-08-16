# Hotel Search Engine

## Requirements

- JDK 21
- Maven 3.6.3 or newer (the included Maven Wrapper can download Maven 3.9.11)
- Tomcat 11.x for external WAR deployment

## Run from IntelliJ IDEA

1. Open the project directory and import it as a Maven project.
2. Set the project SDK and Maven runner JDK to 21.
3. Run `lk.travelmarket.search_engine.SearchEngineApplication`.

The application starts on port `9090` with context path `/hotel-search-service`.

You can also run it from the IntelliJ Maven tool window with `spring-boot:run`.

## Build and run the WAR

Build the executable and deployable WAR:

```bash
./mvnw clean package
```

The output is `target/hotel-search-service.war`. It can be run directly:

```bash
java -jar target/hotel-search-service.war
```

To deploy to an external Tomcat 11 installation, copy the WAR into Tomcat's
`webapps` directory:

```bash
cp target/hotel-search-service.war "$CATALINA_HOME/webapps/"
```

Start Tomcat and access the application at:

```text
http://localhost:8080/hotel-search-service/
```

Tomcat supplies the servlet runtime for the WAR. Configure the database
connection through `src/main/resources/application.properties` or external
Spring configuration before starting the application.
