/*
 * Leetcode 15: 3Sum
 * https://leetcode.com/problems/3sum/
 * Martin.Xia
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                if (num[i] + num[start] + num[end] < 0) {
                    start++;
                }
                else if (num[i] + num[start] + num[end] > 0) {
                    end--;
                }
                else{
                    ArrayList<Integer> oneResult = new ArrayList<>();
                    oneResult.add(num[i]);
                    oneResult.add(num[start]);
                    oneResult.add(num[end]);
                    set.add(oneResult);
                    start++;
                    end--;
                }
            }
        }
        result.addAll(set);
        return result;
    }
}