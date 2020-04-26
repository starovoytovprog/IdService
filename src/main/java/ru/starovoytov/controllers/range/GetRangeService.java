package ru.starovoytov.controllers.range;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.starovoytov.controllers.Range;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Сервис получения диапазона
 *
 * @author starovoytov
 * @since 2020.04.26
 */
@RestController("/getRange")
@RequestMapping("getRange")
public class GetRangeService {
	private static final long RANGE_SIZE = 1_000;
	private AtomicLong currentValue = new AtomicLong(Long.MIN_VALUE);

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Range helloGradle() {
		Range newRange = new Range();
		long localValue = currentValue.addAndGet(RANGE_SIZE + 1);
		newRange.setStart(localValue);
		newRange.setMax(localValue + RANGE_SIZE);
		return newRange;
	}
}
