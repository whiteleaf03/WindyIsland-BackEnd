package top.whiteleaf03.blog.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author WhiteLeaf03
 */
@Configuration
@Data
@PropertySource(value = "classpath:config.yml", factory = PropertySourceFactoryImpl.class)
public class GlobalConfig {

    @Value("${article.path}")
    private String articlePath;

    @Value("${essay.path}")
    private String essayPath;
}
