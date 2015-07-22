/*
 * Leetcode 57: Insert Interval
 * https://leetcode.com/problems/insert-interval/
 * Martin.Xia
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result=new ArrayList<Interval>();
        
        if (newInterval==null){
            return intervals;
        }
        
        if (intervals==null||intervals.size()==0){
            result.add(newInterval);
            return result;
        }
        
        for (Interval temp: intervals){
            if (temp.end<newInterval.start){
                result.add(temp);
            }
            else if (temp.start>newInterval.end){
                result.add(newInterval);
                newInterval=temp;
            }
            else{
                newInterval.start=Math.min(newInterval.start, temp.start);
                newInterval.end=Math.max(newInterval.end, temp.end);
            }
        }
        
        result.add(newInterval);
        return result;

    }
}





