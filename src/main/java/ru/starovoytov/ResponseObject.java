package ru.starovoytov;

/**
 * Ответ сервиса
 *
 * @author starovoytov
 * @since 2020.04.26
 */
public class ResponseObject {
	/**
	 * Сгенерированный ID
	 */
	long id;

	/**
	 * Конструктор объекта
	 *
	 * @param id сгенерированный id
	 */
	public ResponseObject(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
