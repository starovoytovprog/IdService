package ru.starovoytov;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.starovoytov.controllers.id.ResponseObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тест сервиса {@link Application}
 *
 * @author starovoytov
 * @since 2020.04.26
 */
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTest {
	@Autowired
	private MockMvc mvc;

	private static final int THREAD_COUNT = 100;
	private static final int GET_REQUEST_COUNT = 1_000;

	@Test
	@Disabled
	public void testGetController() throws Exception {
		List<GetIdSender> senders = new ArrayList<>();
		final Set<Long> idCollection = Collections.synchronizedSet(new HashSet<>());

		for (int i = 0; i < THREAD_COUNT; i++) {
			senders.add(new GetIdSender(idCollection));
		}

		for (GetIdSender sender : senders) {
			sender.start();
		}

		for (GetIdSender sender : senders) {
			sender.join();
		}

		assertEquals(THREAD_COUNT * GET_REQUEST_COUNT, idCollection.size());
	}

	/**
	 * Получить id от сервиса
	 *
	 * @return id от сервиса
	 * @throws Exception ошибка обращения к сервису
	 */
	private long getId() throws Exception {
		String result = mvc.perform(get("/getId"))
			.andExpect(status().isOk())
			.andReturn()
			.getResponse()
			.getContentAsString();

		ObjectMapper mapper = new ObjectMapper();
		ResponseObject response = mapper.readValue(result, ResponseObject.class);
		return response.getId();
	}

	/**
	 * Поток для обращения к сервису
	 */
	private class GetIdSender extends Thread {
		private final Set<Long> idCollection;

		public GetIdSender(Set<Long> idCollection) {
			this.idCollection = idCollection;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < GET_REQUEST_COUNT; i++) {
					idCollection.add(ApplicationTest.this.getId());
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
