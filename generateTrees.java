/*
 * Leetcode 95: Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * Martin.Xia
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
    
    private ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> result=new ArrayList<TreeNode>();
        if(start>end){
            result.add(null);
        }else{
            for(int i=start;i<=end;i++){
                ArrayList<TreeNode> generateLeft = generate(start,i-1);
                ArrayList<TreeNode> generateRight = generate(i+1,end);
                for(int j=0;j<generateLeft.size();j++)
                    for(int k=0;k<generateRight.size();k++){
                        TreeNode node=new TreeNode(i);
                        node.left=generateLeft.get(j);
                        node.right=generateRight.get(k);
                        result.add(node);
                    }
            }
        }
        return result;
    }
}





