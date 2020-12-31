import java.util.*;
public class RandomSet {
    class RandomizedSet {
        ArrayList<Array> arrlist = new ArrayList<Array>();
        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(arrlist.contains(val)){
                return false;
            } else {
                arrlist.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(arrlist.contains(val)){
                arrlist.remove(arrlist.indexOf(val));
                return true;
            } else {
                return false;
            }

        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random randomvalue=new Random();
            int rdm=randomvalue.nextInt(arrlist.size());
            return arrlist.get(rdm);

        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
