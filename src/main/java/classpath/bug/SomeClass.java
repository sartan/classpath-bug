package classpath.bug;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;

public class SomeClass {
    public void someMethod() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL[] urls = ((URLClassLoader) (classLoader)).getURLs();
        System.out.println(urls.length);
        System.out.println(urls[0]);
        URL systemResource = classLoader.getResource("grumpy-cat.jpg");
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
