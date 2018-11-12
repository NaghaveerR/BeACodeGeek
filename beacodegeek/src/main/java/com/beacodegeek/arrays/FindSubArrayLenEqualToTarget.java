package com.beacodegeek.arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindSubArrayLenEqualToTarget {
	
	int minLen = Integer.MAX_VALUE;

	@Test
	public void findSubArrayLenToTarget() {

		FindSubArrayLenEqualToTarget findSubArrayLenToTarget = new FindSubArrayLenEqualToTarget();

		int[] input = { 1, 3, 4, 2 };
		findSubArrayLenToTarget.findSubArrayLen(input, 4);

		Assert.assertEquals(findSubArrayLenToTarget.minLen, 1);
		
		FindSubArrayLenEqualToTarget findSubArrayLenToTarget2 = new FindSubArrayLenEqualToTarget();
		int[] input2 = { 1, 2, 4, 5, 2, 3, 2 };
		findSubArrayLenToTarget2.findSubArrayLen(input2, 9);

		Assert.assertEquals(findSubArrayLenToTarget2.minLen, 2);
	}

	public void findSubArrayLen(int[] input, int target) {

		int arrLen = input.length;

		for (int i = 0; i < arrLen; i++) {
			findMinPossibleSubArray(input, i, i, arrLen, input[i], target);
		}
	}

	private void findMinPossibleSubArray(int[] input, int startingPoint, int endPoint, int arrLen, int currSum,
			int target) {

		if (currSum == target) {
			minLen= Math.min(endPoint - startingPoint + 1, minLen);
		}
		
		if(endPoint >= arrLen) {
			return;
		}

		for (int j = endPoint + 1; j < arrLen; j++) {
			currSum += input[j];
			findMinPossibleSubArray(input, startingPoint, j, arrLen, currSum, target);
		}
	}
}
