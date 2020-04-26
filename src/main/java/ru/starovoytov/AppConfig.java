package ru.starovoytov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.starovoytov.controllers.IdGenerator;
import ru.starovoytov.controllers.id.RangeServiceFromMaster;
import ru.starovoytov.controllers.id.RangeServiceInterface;

/**
 * Конфигуратор приложения
 *
 * @author starovoytov
 * @since 2020.04.26
 */
@Configuration
public class AppConfig {
	private RangeServiceInterface rangeServiceInterface = new RangeServiceFromMaster();

	@Bean(name = "IdGenerator")
	public ThreadLocal<IdGenerator> getIdGenerator() {
		return new ThreadLocal<>();
	}
}
