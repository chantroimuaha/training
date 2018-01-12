/**
Day0.java
*/
package com.demo.hackerrank.statistic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/************************************
 * Created Date: Jan 5, 2018
 * Created By: ndthien
 * Desc: 
 * **********************************
 * Modified Date: 
 * Modified By: 
 * Desc: 
 ************************************/
public class Day0 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            //Length
            String lenStr = sc.nextLine();
            //Array
            String arrStr = sc.nextLine();
            
            int length = Integer.parseInt(lenStr);
            List<Integer> list = new ArrayList<Integer>();
            for (String e : arrStr.split(" ")) {
                list.add(Integer.parseInt(e));
            }
            if (length != list.size()) throw new IllegalArgumentException("Length isn't equal with size of array");
            //Define result
            float mean = 0.0f;
            float median = 0.0f;
            Map<Integer, Integer> mode = new TreeMap<Integer, Integer>();
            List<Result> listResult = new ArrayList<Result>();
            //Calculate mean
            int sum = 0;
            for (int i : list) {
                sum += i;
            }
            mean = sum / (float) length;
            //Calculate median
            Collections.sort(list);
            if (length % 2 == 0) {
                median = (list.get(length / 2) + list.get(length / 2 - 1)) / 2.0f;
            } else {
                median = list.get(length / 2 - 1);
            }
            //Calculate mode
            for (int i : list) {
                if (!mode.containsKey(i)) {
                    mode.put(i, 1);
                } else {
                    mode.put(i, mode.get(i) + 1);
                }
            }
            //Print result:
            System.out.println(mean);
            System.out.println(median);
            for (int key : mode.keySet()) {
                listResult.add(new Result(key, mode.get(key)));
            }
            Collections.sort(listResult);
            System.out.println(listResult.get(0).getKey());
        } catch(Exception ex) {
            System.err.println(ex);
        }
    }
}
class Result implements Comparable<Result>{
    private int key;
    private int value;
    
    public Result(int key, int value) {
        super();
        this.key = key;
        this.value = value;
    }
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Result o) {
        int valueDiff = Integer.valueOf(o.getValue()).compareTo(Integer.valueOf(value));
        if (valueDiff != 0) {
            return valueDiff;
        } else {
            return Integer.valueOf(key).compareTo(o.key);
        }
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    
}