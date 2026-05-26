package com.codoverse.mix;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@ImportResource({"classpath:config.xml", "classpath:other-config.xml"})
public class Config {

}
