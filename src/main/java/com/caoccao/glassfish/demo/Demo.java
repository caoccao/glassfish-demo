package com.caoccao.glassfish.demo;

import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8001).build();
        DemoConfig config = new DemoConfig();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        HttpServer httpServer = JdkHttpServerFactory.createHttpServer(baseUri, config, false);
        httpServer.setExecutor(executorService);
        httpServer.start();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Press enter to stop the server.");
            scanner.nextLine();
        }
        System.out.println("Shutting down...");
        httpServer.stop(0);
        executorService.shutdown();
    }
}
