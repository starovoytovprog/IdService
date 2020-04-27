package ru.starovoytov.controllers.id;

import ru.starovoytov.controllers.Range;

/**
 * Интерфейс сервиса получения диапазона
 *
 * @author starovoytov
 * @since 2020.04.26
 */
public interface RangeServiceInterface {
	/**
	 * Получить диапазон id
	 *
	 * @return диапазон id
	 */
	Range getNewRang();
}
