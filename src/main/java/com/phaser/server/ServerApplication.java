package com.phaser.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ServerApplication {
	static void main(String[] args) {
        var arr = new ArrayList<String>();
        arr.add("Hello World");

        var val = arr.getFirst();

        System.out.println(val.toLowerCase());
		SpringApplication.run(ServerApplication.class, args);
	}
}
