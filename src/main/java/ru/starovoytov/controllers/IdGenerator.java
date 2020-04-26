package ru.starovoytov.controllers;

import ru.starovoytov.controllers.id.RangeServiceFromMaster;

/**
 * Генератор ID
 *
 * @author starovoytov
 * @since 2020.04.26
 */
public class IdGenerator {
	private long currentId = 1;
	private long maxId = 0;

	private RangeServiceInterface rangeService = new RangeServiceFromMaster();

	/**
	 * Получить новый id
	 *
	 * @return новый id
	 */
	public long getNewId() {
		if (currentId > maxId) {
			getNewRange();
		}

		return currentId++;
	}

	/**
	 * Получить новый диапазон
	 */
	private void getNewRange() {
		Range range = rangeService.getNewRang();
		currentId = range.getStart();
		maxId = range.getMax();
	}
}
