/*
 * Leetcode 8: String to Integer (atoi) 
 * https://leetcode.com/problems/string-to-integer-atoi/
 * Martin.Xia
 */
public class Solution {
    public int myAtoi(String str) {
        String trim=str.trim();
        if (trim==null||trim.length()==0){
            return 0;
        }
        double sum=0;
        int isPositive=1;
        
        for(int i=0;i<trim.length();i++){
            if(i==0&&(trim.charAt(i)=='+'||trim.charAt(i)=='-')){
                if(trim.charAt(i)=='-'){
                    isPositive=-1;
                }
                continue;
            }
            if(trim.charAt(i)>'9'||trim.charAt(i)<'0') break;
            sum=sum*10+trim.charAt(i)-'0';
        }
        sum=sum*isPositive;
        if (sum>2147483647) return 2147483647;
        if (sum<-2147483648) return -2147483648;
        return (int)sum;
    }
}





