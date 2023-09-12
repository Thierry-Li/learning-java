package com.java.fazjaune.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
		MarioGame marioGame = new MarioGame();
		GameRunner gameRunner = new GameRunner(marioGame);

		gameRunner.run();
	}

}
