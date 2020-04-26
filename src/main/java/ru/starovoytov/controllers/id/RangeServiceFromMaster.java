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
		range.setMax(2);
		range.setStart(0);
		return range;
	}
}
