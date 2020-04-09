package com.fabiojr.projetoTecnico.config;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

import com.fabiojr.projetoTecnico.services.DBService;
import com.fabiojr.projetoTecnico.services.EmailService;
import com.fabiojr.projetoTecnico.services.MockEmailService;



@SuppressWarnings("unused")
@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}