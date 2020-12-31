import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        String order=getstring(n, k);
        ArrayList<String> sub = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            sub.add(Integer.toString(i));
        }
        String result="";
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(String.valueOf(order.charAt(i)));
            result=result+sub.get(num-1);
            sub.remove(num-1);
        }
        return result;
    }


    public static String getstring(int n, int k) {
        if(n==1){
            return "1";
        }else {
            int i;
            for (i = 1; i<n; i++) {
                if((i - 1) * factorial(n - 1) < k && i * factorial(n - 1)>=k){
                    break;
                }
            }
            return Integer.toString(i) + getstring(n - 1, k - (i-1) * factorial(n - 1));
        }
    }

    public static int factorial(int n){
        if(n>0){
            return n*factorial(n-1);
        } else return 1;
    }
}