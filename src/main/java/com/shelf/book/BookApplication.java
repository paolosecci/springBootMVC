package com.shelf.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import static spark.Spark.*;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args); //localhost:8080 (SPARK WEB APP)
		//get("/hello", (req, res) -> "Hello JaveSpark World"); //localhost:4567 (SPARK WEB APP)
	}

}
