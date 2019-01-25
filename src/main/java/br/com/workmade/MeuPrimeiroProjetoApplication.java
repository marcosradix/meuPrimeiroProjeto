package br.com.workmade;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.workmade.utils.PasswordUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		
	}

	@Bean
	public CommandLineRunner command() {
		
		return args ->{
			String senhaEncoded = PasswordUtils.gerarBCrypt("1234567890");
			System.out.println("Seu primeiro projeto : " + senhaEncoded);
			
			senhaEncoded = PasswordUtils.gerarBCrypt("1234567890");
			System.out.println("Senha encoded novamente: " + senhaEncoded);
			System.out.println("Senha válida: " + PasswordUtils.validarSenha("1234567890", senhaEncoded));
			
		};
		
		
		
		
	}
	
}

