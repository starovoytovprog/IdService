package ru.starovoytov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигуратор приложения
 *
 * @author starovoytov
 * @since 2020.04.26
 */
@Configuration
public class AppConfig {
	private IdGenerator idGenerator = new IdGenerator();

	@Bean(name = "IdGenerator")
	public IdGenerator getIdGenerator() {
		return idGenerator;
	}
}
