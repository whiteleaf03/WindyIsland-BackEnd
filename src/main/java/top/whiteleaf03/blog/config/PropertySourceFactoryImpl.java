package top.whiteleaf03.blog.config;

import lombok.NoArgsConstructor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

@NoArgsConstructor
public class PropertySourceFactoryImpl implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        return new YamlPropertySourceLoader().load(name, resource.getResource()).get(0);
    }

}
