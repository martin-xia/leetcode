/*
 * Leetcode 16: 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 * Martin.Xia
 */

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int closest = num[0] + num[1] + num[2];
        int diff = Math.abs(closest - target);
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                int newDiff = Math.abs(sum - target);
                if (newDiff == 0) {
                    return target;
                }
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target)
                    start++;
                else
                    end--;
            }
        }
        return closest;
    }
}