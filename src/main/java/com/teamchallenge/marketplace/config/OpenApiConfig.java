package com.teamchallenge.marketplace.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Marketplace",
                version = "v0.1",
                contact =
                @Contact(
                        url = "https://www.linkedin.com/in/denys-filonenko-6a8632163/",
                        name = "Denys Filonenko",
                        email = "filonenko.denys94@gmail.com"
                )
        )
)
public class OpenApiConfig {
    static {
        SpringDocUtils.getConfig().removeRequestWrapperToIgnore(java.util.Map.class);
    }
}
