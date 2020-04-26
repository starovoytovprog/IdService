package ru.starovoytov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для получения id
 *
 * @author starovoytov
 * @since 2020.04.26
 */
@RestController("/getId")
@RequestMapping("getId")
public class GetIdController {

	@Autowired
	@Qualifier("IdGenerator")
	private IdGenerator idGenerator;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject helloGradle() {
		return new ResponseObject(idGenerator.getNewId());
	}
}
