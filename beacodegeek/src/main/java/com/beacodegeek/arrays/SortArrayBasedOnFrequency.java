package com.beacodegeek.arrays;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayBasedOnFrequency {

	@Test
	public void sortArrayBasedOnFrequencyTest() {
		SortArrayBasedOnFrequency sortArrayBasedOnFrequency = new SortArrayBasedOnFrequency();

		int[] input = { 1, 3, 1, 3, 5 };
		Object[] expected = { 5, 1, 3 };
		Object[] actual = sortArrayBasedOnFrequency.sort(input);
		Assert.assertArrayEquals(expected, actual);

		int[] input2 = { 1, 3, 2, 2, 4, 4, 4, 5, 6, 7, 8, 8, 9, 9, 10 };
		Object[] expected2 = { 1, 3, 5, 6, 7, 10, 2, 8, 9, 4 };
		Object[] actual2 = sortArrayBasedOnFrequency.sort(input2);
		Assert.assertArrayEquals(expected2, actual2);

	}

	public Object[] sort(int[] input) {

		Map<Integer, Integer> frequencies = new LinkedHashMap<>();

		for (int i = 0; i < input.length; i++) {
			frequencies.merge(input[i], 1, Integer::sum);
		}

		Map<Integer, List<Integer>> tempMap = frequencies.keySet().stream()
				.collect(Collectors.groupingBy(key -> frequencies.get(key)));

		List<Integer> outList = new ArrayList<>();
		tempMap.forEach((key, value) -> {
			outList.addAll(value);
		});

		return outList.toArray();
	}
}
