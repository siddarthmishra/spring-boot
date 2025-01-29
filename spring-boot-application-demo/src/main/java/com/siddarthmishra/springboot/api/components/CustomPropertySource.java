package com.siddarthmishra.springboot.api.components;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
	@PropertySource("classpath:/custom/file-1.properties"),
	@PropertySource("file:external/property-folder/external-file-1.properties"),
	@PropertySource("classpath:/custom/person/*.properties")
})
public class CustomPropertySource {

}
