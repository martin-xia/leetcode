/*
 * Leetcode 1: Two Sum
 * https://leetcode.com/problems/two-sum/
 * Martin.Xia
 */

/* 
 * If the input array numbers are sorted in ascending order, 
 * we could use the following method
 *
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = numbers.length-1;
        while(start<end){
            if(numbers[start]+numbers[end]<target){
                start++;
            }
            else if(numbers[start]+numbers[end]>target){
                end--;
            }
            else{
                result[0] = start+1;
                result[1] = end+1;
                break;
            }
        }
        return result;
    }
}
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] result = new int[2];
 
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(numbers[i])) {
            int index = map.get(numbers[i]);
            result[0] = index+1 ;
            result[1] = i+1;
            break;
        } else {
            map.put(target - numbers[i], i);
        }
    }
 
    return result;
    }
}







