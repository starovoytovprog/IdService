package ru.starovoytov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.starovoytov.controllers.IdGenerator;

/**
 * Конфигуратор приложения
 *
 * @author starovoytov
 * @since 2020.04.26
 */
@Configuration
@Profile("default")
public class AppConfig {
	@Bean(name = "IdGenerator")
	public ThreadLocal<IdGenerator> getIdGenerator() {
		return new ThreadLocal<>();
	}

	@Bean(name = "RangeServer")
	public String getRangeServer() {
		return "http://localhost:8080/getRange";
	}
}
