package com.client.ws.rasmooplus;

import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.UserType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class WsRasmooPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsRasmooPlusApplication.class, args);
	}


}
