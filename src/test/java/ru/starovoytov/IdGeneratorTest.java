package ru.starovoytov;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тест генератора id {@link IdGenerator}
 *
 * @author starovoytov
 * @since 2020.04.26
 */
class IdGeneratorTest {
	@Test
	public void testGenerateNewId() {
		IdGenerator generator = new IdGenerator();
		Set<Long> idCollection = new HashSet<>();

		for (int i = 0; i < 1_000; i++) {
			idCollection.add(generator.getNewId());
		}

		assertEquals(1_000, idCollection.size());
	}
}
