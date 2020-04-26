package ru.starovoytov.controllers.id;

import ru.starovoytov.controllers.Range;
import ru.starovoytov.controllers.RangeServiceInterface;

/**
 * Сервис получения диапазона от мастера
 *
 * @author starovoytov
 * @since 2020.04.26
 */
public class RangeServiceFromMaster implements RangeServiceInterface {

	@Override
	public Range getNewRang() {
		Range range = new Range();
		long threadParam = (Thread.currentThread().getId() + 1) * 1_000;
		range.setMax(3 * threadParam);
		range.setStart(1 * threadParam);
		return range;
	}
}
