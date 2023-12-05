package me.study.leetcode;

class RunningSumOf1DArray {

    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        if (length != 0)
            result[0] = nums[0];

        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

}
