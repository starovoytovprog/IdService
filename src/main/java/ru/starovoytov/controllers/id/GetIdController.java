package ru.starovoytov.controllers.id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.starovoytov.controllers.IdGenerator;

/**
 * Контроллер для получения id
 *
 * @author starovoytov
 * @since 2020.04.26
 */
@RestController("/getId")
@RequestMapping("getId")
public class GetIdController {
	private final ThreadLocal<IdGenerator> idGenerator = new ThreadLocal<>();

	@Autowired
	private Environment env;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject helloGradle() {
		String rangeAddress = env.getProperty("range.server.address");
		IdGenerator generator = idGenerator.get();
		if (generator == null) {
			generator = new IdGenerator(rangeAddress);
			idGenerator.set(generator);
		}
		return new ResponseObject(generator.getNewId());
	}
}
