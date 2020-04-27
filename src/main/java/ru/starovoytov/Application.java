package ru.starovoytov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Стартовый класс сервиса
 *
 * @author starovoytov
 * @since 2020.04.25
 */
@SpringBootApplication
public class Application {
	/**
	 * Стартовый метод сервиса
	 *
	 * @param args параметры командной строки
	 */
	public static void main(String[] args) {
		final SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}
}
