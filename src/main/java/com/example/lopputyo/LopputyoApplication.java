package com.example.lopputyo;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.lopputyo.domain.Player;
import com.example.lopputyo.domain.PlayerRepository;
import com.example.lopputyo.domain.User;
import com.example.lopputyo.domain.UserRepository;

@SpringBootApplication
public class LopputyoApplication {

	//private static final Logger log = LoggerFactory.getLogger(LopputyoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LopputyoApplication.class, args);
	}@Bean
	public CommandLineRunner bookDemo(UserRepository urepository, PlayerRepository prepository) { 
		return (args) -> {
			
			
			
			//tallennettu valmiiksi yksi admin ja yksi user
			User user1 = new User ("Pekka", "Paavola", "pekka.paavola@gmail.com", "admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			
			User user2 = new User ("Meitsi", "Meikäläinen", "meitsi@gmail.com", "user", "$2a$10$p7xtIVvG79Ld3Omw4DA56eIB/2adtGnVmaNqRMXcbvJHcuOXuObGy", "USER");
			urepository.save(user2);
			
//Tallennettu pelaajat valmiiksi
			Player player1 = new Player("Jesperi", "Kuula", "74", "85", "189", "12", "10", "2", "1");
			prepository.save(player1);
			
			Player player2 = new Player("Aki", "Ekhaletruo", "7", "75", "176", "12", "19", "0", "1");
			prepository.save(player2);
		
		};}
		
				
				
				
				
				

				
				
			
			

}



