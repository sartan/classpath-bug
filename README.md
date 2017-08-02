# classpath-bug

The [spring boot maven plugin docs](https://docs.spring.io/spring-boot/docs/current/maven-plugin/usage.html) says:

> "When addResources is enabled, any src/main/resources folder will be added to the 
> application classpath when you run the application"

But this [SSCCE](http://sscce.org/) shows that is not happening.
