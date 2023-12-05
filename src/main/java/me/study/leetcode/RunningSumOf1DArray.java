package me.study.leetcode;

import me.study.CodingTest;

class RunningSumOf1DArray implements CodingTest {

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }

    @Override
    public String getPage() {
        return "https://leetcode.com/problems/running-sum-of-1d-array";
    }

}
