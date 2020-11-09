# Jersey Validation Exception Mapper reproducer


## Working: no CDI
```
mvn clean package
cd app
java -cp target/classes:target/dependency/* com.kumuluz.ee.EeApplication
curl --header "Content-Type: application/json" --request POST --data '' localhost:8080/my 
```

MyValidationExceptionMapper is invoked.

On windows use ; instead of : as -cp delimiter.

## Not working: with CDI enabled

In app/pom.xml uncomment:

```xml
<dependency>
    <groupId>com.kumuluz.ee</groupId>
    <artifactId>kumuluzee-cdi-weld</artifactId>
</dependency>
<dependency>
    <groupId>com.kumuluz.ee.logs</groupId>
    <artifactId>kumuluzee-logs-log4j2</artifactId>
    <version>1.4.2</version>
</dependency>
```

This brings in jetty 9 with cdi2 module, weld and jersey cdi1x dependency.

Confirm on startup:
```
2020-11-09 22:00:24,892 INFO  WELD-ENV-001200: Jetty 7.2+ detected, CDI injection will be available in Servlets and Filters. Injection into Listeners should work on Jetty 9.1.1 and newer. {}  
```

Run:
```
mvn clean package
cd app
java -cp target/classes:target/dependency/* com.kumuluz.ee.EeApplication
curl --header "Content-Type: application/json" --request POST --data '' localhost:8080/my 
```

Something does happen with the mapper:
```
2020-11-09 22:00:25,339 DEBUG  Class, class com.github.cen1.rest.MyValidationExceptionMapper, is being checked with Jersey CDI component provider. {}  
2020-11-09 22:00:25,341 CONFIG  Class, class com.github.cen1.rest.MyValidationExceptionMapper, has been bound by Jersey CDI component provider. {} 
```

The two mappers which I mentioned in github issue that are picked up by CustomAnnotationLiteral.INSTANCE are not bound with CDI interestingly enough:
```
2020-11-09 22:00:25,336 DEBUG  Class, class org.glassfish.jersey.jackson.internal.jackson.jaxrs.base.JsonParseExceptionMapper, is being checked with Jersey CDI component provider. {}  
2020-11-09 22:00:25,339 DEBUG  Class, class org.glassfish.jersey.jackson.internal.jackson.jaxrs.base.JsonMappingExceptionMapper, is being checked with Jersey CDI component provider. {}
```


Log level can be adjusted in `resources/log4j2.xml`.

## Working: Register via AbstractBinder

Uncomment `//classes.add(MyFeature.class);` in MyRestApplication.