package ru.starovoytov;

/**
 * Генератор ID
 *
 * @author starovoytov
 * @since 2020.04.26
 */
public class IdGenerator {
	private long currentId = 0;

	/**
	 * Получить новый id
	 *
	 * @return новый id
	 */
	public long getNewId() {
		return currentId++;
	}
}
