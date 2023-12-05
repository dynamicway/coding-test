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
    public int getTimeComplexity() {
        return 1;
    }

    @Override
    public int getSpaceComplexity() {
        return 1;
    }

    @Override
    public String getPage() {
        return "https://leetcode.com/problems/running-sum-of-1d-array";
    }

}
