# baeso-msgraph

## What it is

This is an experimental library to access the [Graph-API](https://learn.microsoft.com/en-us/graph/overview?view=graph-rest-1.0) of Microsoft

## Usage

The library is currently not published to maven central so you need to build it your own and push it to an artifact repository. If you are not eager
setup nexus you might choose [quak](https://github.com/BestSolution-at/quak) a light weight maven repo by [BestSolution](https://www.bestsolution.at)

### Integration

To use the code in an application you need to following maven dependencies

```xml
  ...
  <dependencies>
    <dependency>
      <groupId>org.glassfish</groupId>
      <artifactId>jakarta.json</artifactId>
      <version>1.1.6</version>
    </dependency>
    <dependency>
      <groupId>at.bestsolution.baeso.msgraph</groupId>
      <artifactId>msgraph-api</artifactId>
      <version>999.9.0-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>at.bestsolution.baeso.msgraph</groupId>
      <artifactId>msgraph-impl</artifactId>
      <version>999.9.0-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>at.bestsolution.baeso.msgraph</groupId>
      <artifactId>msgraph-auth-msal4j</artifactId>
      <version>999.9.0-SNAPSHOT</version>
    </dependency>
  </dependencies>
  ...
```

### Code Sample

```java
public static class App {
    public static void main(String[] args) {
        
    }
}
```