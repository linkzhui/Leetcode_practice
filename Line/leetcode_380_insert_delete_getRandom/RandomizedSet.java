package Google.Line.leetcode_380_insert_delete_getRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer,Integer> map;
    Random random;


    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.random = new Random();
        this.map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val))
        {
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        //step1 : get the last element from the arraylist
        //step2 : delete the last element
        //step3 : find the current index of removed element to "index"
        //step4 : update the list's index value to last element from the arraylist

        Integer index = map.get(val);

        if(index == null)
        {
            return false;
        }

        //If the key exist in hashmap, remove the current value from hashmap

        if(index!=list.size()-1)
        {
            //the remove element is not at end of the arraylist
            Integer last_value = list.get(list.size()-1);
            list.set(index,last_value);
            map.put(last_value,index);
        }

        map.remove(val);
        //remove arraylist last element
        list.remove(list.size() - 1);
        //update the last element to removed element's index
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int ran_num = random.nextInt(list.size());
        return list.get(ran_num);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */