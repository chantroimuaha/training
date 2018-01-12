/**
FindSubString.java
*/
package com.demo.hackerrank.regex;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/************************************
 * Created Date: Jan 10, 2018
 * Created By: ndthien
 * Desc: 
 * **********************************
 * Modified Date: 
 * Modified By: 
 * Desc: 
 ************************************/
public class FindSubString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> listMain = new ArrayList<String>();
        List<String> listSub = new ArrayList<String>();
        Map<String, Integer> countMap = new LinkedHashMap<String, Integer>();
        try (Scanner sc = new Scanner(System.in)) {
            String numStrMain = sc.nextLine();
            int numMain = Integer.parseInt(numStrMain);
            for (int i = 0; i < numMain; i++) {
                String s = sc.nextLine();
                listMain.add(s);
            }
            String numStrSub = sc.nextLine();
            int numSub = Integer.parseInt(numStrSub);
            for (int i = 0; i < numSub; i++) {
                String s = sc.nextLine();
                listSub.add(s);
                countMap.put(s, 0);
            }
            String patternStr = "(\\w*)";
            Pattern pattern = Pattern.compile(patternStr);
            for (String main : listMain) {
                Matcher matcher = pattern.matcher(main);
                while (matcher.find()) {
                    for (String sub : listSub) {
                        if(matcher.group(1).matches("\\w+" + sub + "\\w+")) {
                            countMap.put(sub, countMap.get(sub) + 1);
                        }
                    }
                }
                
            }
            for (String s : countMap.keySet()) {
                System.out.println(countMap.get(s));
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
