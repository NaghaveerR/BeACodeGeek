package com.beacodegeek.arrays;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Find all pairs in an array of non-negative unique numbers whose sum is equal
 * to k For Example. {1,3,4,5,6} and k=9, then {3,6} and {4,5}
 *
 * Time Complexity is O(n)
 * Space Complexity is O(n)
 */
public class FindPairsWithGivenSumHashingTest {

	public Map<Integer, Integer> findAllPairsWhoseSumIsK(int[] inputArray, int k) {

		Set<Integer> tempSet = new HashSet<>();
		Map<Integer, Integer> pairs = new HashMap<>();

		for (int i = 0; i < inputArray.length; i++) {
			tempSet.add(inputArray[i]);
		}

		for (int i = 0; i < inputArray.length; i++) {
			if ((2 * inputArray[i] != k) && tempSet.contains(k - inputArray[i])) {
				if (!pairs.containsKey(k - inputArray[i])) {
					pairs.put(inputArray[i], k - inputArray[i]);
				}
			}
		}

		return pairs;
	}

	@Test
	public void test() {
		FindPairsWithGivenSumHashingTest findPairsWithGivenSumHashing = new FindPairsWithGivenSumHashingTest();

		// Test 1
		int[] inputArray1 = { 1, 3, 5, 7, 9, 11 };
		Map<Integer, Integer> output1 = findPairsWithGivenSumHashing.findAllPairsWhoseSumIsK(inputArray1, 10);
		assertEquals(output1.size(), 2);
		output1.forEach((key, value) -> assertEquals(10, key + value));

		// Test 2
		int[] inputArray2 = { 1, 2, 5, 6, 12, 15, 16 };
		Map<Integer, Integer> output2 = findPairsWithGivenSumHashing.findAllPairsWhoseSumIsK(inputArray2, 17);
		assertEquals(output2.size(), 3);
		output2.forEach((key, value) -> assertEquals(17, key + value));
	}

}