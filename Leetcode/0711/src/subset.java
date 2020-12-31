import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static List<List<Integer>> result=new ArrayList<List<Integer>>();
    static List<Integer> one=new ArrayList<Integer>();
    public static void main(String args[]) {
        int[] nums={1,2,3};
        result.add(one);
        int length=nums.length;
        for(int i=1;i<=length;i++){
            findn(i,0,length,nums);
        }
        //System.out.println(1);
    }

    public static void findn(int n,int index,int length,int[] nums){
        if(index==0) {
            System.out.println(3);
            one=new ArrayList<Integer>();}
        if(n==0){
            System.out.println(1);
            result.add(one);

            System.out.println("re="+result);
            one.remove(one.size()-1);
        }else {
            for(int j=index;j<length;j++){
                System.out.println(2);
                one.add(nums[j]);
                System.out.println("nums[index]="+nums[j]);
                findn(n-1,j+1,length,nums);
            }
        }
    }
}