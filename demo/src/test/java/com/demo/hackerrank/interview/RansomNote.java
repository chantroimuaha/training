/**
RansomNote.java
*/
package com.demo.hackerrank.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/************************************
 * Created Date: Jan 5, 2018
 * Created By: ndthien
 * Desc: 
 * **********************************
 * Modified Date: 
 * Modified By: 
 * Desc: 
 ************************************/
public class RansomNote {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            //Get input
            String lenStr = sc.nextLine();
            String magazine = sc.nextLine();
            String ransom = sc.nextLine();
            //Process
            String result = "Yes";
            Map<String, List<Integer>> magazineMap = new HashMap<String, List<Integer>>();
            String[] arrMagazine = magazine.split(" ");
            for (int i = 0; i < arrMagazine.length; i++) {
                String s = arrMagazine[i];
                if (!magazineMap.containsKey(s)) {
                    List<Integer> listIndex = new ArrayList<Integer>();
                    listIndex.add(i);
                    magazineMap.put(s, listIndex);
                } else {
                    List<Integer> listIndex = magazineMap.get(s);
                    listIndex.add(i);
                    magazineMap.put(s, listIndex);
                }
            }
            String[] arrRansom = ransom.split(" ");
            for (int i = 0; i < arrRansom.length; i++) {
                String current = arrRansom[i];
                String next = (i == arrRansom.length - 1) ? current : arrRansom[i + 1];
                List<Integer> currentList = magazineMap.get(current);
                List<Integer> nextList = magazineMap.get(next);
                if (!isIncrease(currentList, nextList)) {
                    result = "No";
                }
            }
            //Print result
            System.out.println(result);
        } catch(Exception ex) {
            System.err.println(ex);
        }
    }

    public static boolean isIncrease(List<Integer> first, List<Integer> second) {
        boolean result = false;
        for (Integer f : first) {
            for (Integer s : second) {
                if (f <= s) {
                    result = true;
                }
            }
        }
        return result;
    }
}
