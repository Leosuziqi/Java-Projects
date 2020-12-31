import java.lang.*;
import java.util.*;
class hamming{
    public static void main(String args[]) {
        int x=1;
        int y=4;
        char[] xb=Integer.toBinaryString(x).toCharArray();
        char[] yb=Integer.toBinaryString(y).toCharArray();
        int length=Math.max(xb.length,yb.length);
        char[] xfull=new char[length];
        char[] yfull=new char[length];
        if(xb.length<=yb.length){
            for(int i=0;i<yb.length-xb.length;i++){
                xfull[i]='0';
            }
        } else {
            for(int i=0;i<xb.length-yb.length;i++){
                yfull[i]='0';
            }
        }
        for(int i=0;i<xb.length;i++){
            xfull[length-1-i]=xb[xb.length-1-i];
        }
        for(int i=0;i<yb.length;i++){
            yfull[length-1-i]=yb[yb.length-1-i];
        }
        int num=0;
        for(int i=0;i<length;i++){
            if(xfull[i]!=yfull[i]){
                num++;
            }
        }
        System.out.println(num);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            int sum2=0-nums[i];
            for(int j=i+1;j<nums.length-1;j++){
                int sum1=sum2-nums[j];
                for(int k=j+1;k<nums.length;k++){
                    if(nums[k]==sum1){
                        List<Integer> choice=new ArrayList<Integer>();
                        choice.add(nums[i]);
                        choice.add(nums[j]);
                        choice.add(nums[k]);
                        Collections.sort(choice);
                        if(!result.contains(choice))
                            result.add(choice);
                        break;
                    }
                }
            }
        }
        return result;
    }
}