package ru.starovoytov.controllers.id;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.starovoytov.controllers.Range;

/**
 * Сервис получения диапазона от мастера
 *
 * @author starovoytov
 * @since 2020.04.26
 */
public class RangeServiceFromMaster implements RangeServiceInterface {
	private final String server;

	private RestTemplate rest;
	private HttpHeaders headers;

	public RangeServiceFromMaster(String server) {
		this.server = server;
		this.rest = new RestTemplate();
		this.headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
	}

	@Override
	public Range getNewRang() {
		HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
		ResponseEntity<Range> responseEntity = rest.exchange(server, HttpMethod.GET, requestEntity, Range.class);
		return responseEntity.getBody();
	}
}
