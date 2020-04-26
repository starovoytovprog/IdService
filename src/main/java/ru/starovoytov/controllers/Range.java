package ru.starovoytov.controllers;

/**
 * Диапазон для ID
 *
 * @author starovoytov
 * @since 2020.04.26
 */
public class Range {
	/**
	 * Начальное значение
	 */
	private long start;
	/**
	 * Максимальное значение
	 */
	private long max;

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}
}
