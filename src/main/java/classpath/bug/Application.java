package classpath.bug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;

import static java.lang.ClassLoader.getSystemClassLoader;
import static java.lang.ClassLoader.getSystemResource;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        // This works:

        SomeClass sc = new SomeClass();
        sc.someMethod();

        // This fails:

        ClassLoader systemClassLoader = getSystemClassLoader();
        URL[] urls = ((URLClassLoader) (systemClassLoader)).getURLs();
        System.out.println(urls.length);
        System.out.println(urls[0]);
        URL systemResource = getSystemResource("grumpy-cat.jpg");
        // ...because the resource is not found, and is null
        System.out.println(systemResource);
        URI uri = null;

        try {
            uri = systemResource.toURI();
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
        System.out.println(uri);
    }
}
