package com.caoccao.glassfish.demo;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class DemoConfig extends ResourceConfig {
    public DemoConfig() {
        packages("com.caoccao.glassfish.demo.resources");
    }
}
