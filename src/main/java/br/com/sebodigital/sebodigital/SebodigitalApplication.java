package br.com.sebodigital.sebodigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; // Adicione este import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; // Adicione este import

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.sebodigital.sebodigital.repository")
@EntityScan(basePackages = "br.com.sebodigital.sebodigital.model")
public class SebodigitalApplication {
	public static void main(String[] args) {
		SpringApplication.run(SebodigitalApplication.class, args);
	}
}