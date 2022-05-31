package dev.testapp.UniversityInterface;

import dev.testapp.UniversityInterface.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@SpringBootApplication
public class UniversityInterfaceApplication {

	@Autowired
	private CommandService commandService;

	public static void main(String[] args) {
		SpringApplication.run(UniversityInterfaceApplication.class, args);
	}

	@PostConstruct
	public void start() {
		final Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			commandService.execute(input);
		}
	}
}
