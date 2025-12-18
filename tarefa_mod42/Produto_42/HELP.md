# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.0/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.0/maven-plugin/build-image.html)
* [Config Server](https://docs.spring.io/spring-cloud-config/reference/server.html)
* [Config Client](https://docs.spring.io/spring-cloud-config/reference/client.html)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/4.0.0/reference/data/nosql.html#data.nosql.mongodb)
* [Cloud Bootstrap](https://docs.spring.io/spring-cloud-commons/reference/spring-cloud-commons/application-context-services.html)
* [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/reference/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.0/reference/using/devtools.html)
* [Validation](https://docs.spring.io/spring-boot/4.0.0/reference/io/validation.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Additional Links
These additional references should also help you:

* [Declarative REST calls with Spring Cloud OpenFeign sample](https://github.com/spring-cloud-samples/feign-eureka)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

