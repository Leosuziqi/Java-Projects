import java.util.*;
public class maxLength {
    public static void main(String[] args) {

        ArrayList<String> arr = new ArrayList<String>();
        arr.add("");

        ArrayList<Integer> length = new ArrayList<Integer>();
        for (int i=0;i<arr.size();i++){
            length.add(0);
            length.set(i,arr.get(i).length());
        }

        System.out.println(length);
        System.out.println(Collections.max(length));

    }
}
