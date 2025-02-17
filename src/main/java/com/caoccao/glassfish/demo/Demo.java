package com.caoccao.glassfish.demo;

import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.ws.rs.core.UriBuilder;
import java.io.FileInputStream;
import java.net.URI;
import java.security.KeyStore;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    private static SSLContext createSSLContext() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream("keystore/demo.jks"), "gfdemo".toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, "gfdemo".toCharArray());
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
        return sslContext;
    }

    public static void main(String[] args) throws Exception {
        URI baseUri = UriBuilder.fromUri("https://localhost/").port(8001).build();
        DemoConfig config = new DemoConfig();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        SSLContext sslContext = createSSLContext();
        HttpServer httpServer = JdkHttpServerFactory.createHttpServer(baseUri, config, sslContext, false);
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
