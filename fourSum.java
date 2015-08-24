/*
 * Leetcode 18: 4Sum
 * https://leetcode.com/problems/4sum/
 * Martin.Xia
 */

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        
        if(num.length < 4) {
            return result;
        }
        
        Arrays.sort(num);
     
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                int k = j + 1;
                int l = num.length - 1;
     
                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];
     
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);
                        hashSet.add(temp);
                        
                        k++;
                        l--;
                    }
                }
            }
        }
        result.addAll(hashSet);
        return result;
    }
}