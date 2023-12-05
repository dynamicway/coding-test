package me.study.leetcode;

import me.study.CodingTest;

class RichestCustomerWealth implements CodingTest {

    static int maximumWealth(int[][] accounts) {
        int maximumWealth = 0;
        for (int[] account : accounts) {
            int sumOfAccount = 0;
            for (int wealth : account) {
                sumOfAccount += wealth;
            }
            if (sumOfAccount > maximumWealth)
                maximumWealth = sumOfAccount;
        }
        return maximumWealth;
    }

    @Override
    public String getTimeComplexity() {
        return "O(m * n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }

    @Override
    public String getPage() {
        return "https://leetcode.com/problems/richest-customer-wealth";
    }
}
