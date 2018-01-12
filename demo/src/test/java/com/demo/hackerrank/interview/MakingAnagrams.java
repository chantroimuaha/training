/**
MakingAnagrams.java
*/
package com.demo.hackerrank.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/************************************
 * Created Date: Jan 5, 2018
 * Created By: ndthien
 * Desc: 
 * **********************************
 * Modified Date: 
 * Modified By: 
 * Desc: 
 ************************************/
public class MakingAnagrams {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            //Get input
            String first = sc.nextLine();
            String second = sc.nextLine();
            //Process
            Map<String, Integer> firstMap = new HashMap<String, Integer>();
            Map<String, Integer> secondMap = new HashMap<String, Integer>();
            for (int i = 0; i < first.length(); i++) {
                String key = first.charAt(i) + "";
                if (!firstMap.containsKey(key)) {
                    firstMap.put(key, 1);
                } else {
                    firstMap.put(key, firstMap.get(key) + 1);
                }
            }
            for (int i = 0; i < second.length(); i++) {
                String key = second.charAt(i) + "";
                if (!secondMap.containsKey(key)) {
                    secondMap.put(key, 1);
                } else {
                    secondMap.put(key, secondMap.get(key) + 1);
                }
            }
            int count = 0;
            for (String key : firstMap.keySet()) {
                for (String key2 : secondMap.keySet()) {
                    if( key.equals(key2)) {
                        if (firstMap.get(key) > secondMap.get(key2)) {
                            count += secondMap.get(key2);
                        } else {
                            count += firstMap.get(key);
                        }
                    }
                }
            }
            //Print result
            System.out.println(first.length() + second.length() - count * 2);
        } catch(Exception ex) {
            System.err.println(ex);
        }
    }

}
