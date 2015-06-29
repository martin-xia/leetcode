/*
 * Leetcode 7: Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 * Martin.Xia
 */
 public class Solution {
    public int reverse(int x) {
        int isPositive = 1;
        double sum = 0;
        if (x<0){
          isPositive=-1;
          x=isPositive*x;
        } 
        while(x>0){
            int temp=(int)(x/10);
            sum=sum*10+(x-10*temp);
            x=temp;
            if(sum>2147483647) return 0;
            if(sum<-2147483648) return 0;
        }
        return isPositive*(int)sum;
    }
}





