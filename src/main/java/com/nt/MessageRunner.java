package com.nt;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageRunner implements CommandLineRunner {

	private static Logger log = (Logger) LoggerFactory.getLogger(MessageRunner.class); 
	@Override
	public void run(String... args) throws Exception {
		
		int a=10;
		try{
			log.info("STARTED");
			System.out.println("Welcome to SpringBoot Application" +a);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		log.info("End");
	}

}
