/**
DetectEmailAddress.java
*/
package com.demo.hackerrank.regex;

import java.util.ArrayList;
import java.util.List;
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
public class DetectEmailAddress {
    public static Pattern emailPattern = Pattern.compile("(\\w+@\\w+\\.\\w+(.\\w+)?(.\\\\w+)?(.\\\\w+)?(.\\\\w+)?");
    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> listInput = new ArrayList<String>();
        Set<String> emailSet = new TreeSet<String>();
        try (Scanner sc = new Scanner(System.in)) {
            String numInputStr = sc.nextLine();
            int numInput = Integer.parseInt(numInputStr);
            for (int i = 0; i < numInput; i++) {
                String s = sc.nextLine();
                listInput.add(s);
            }
            for (String main : listInput) {
                Matcher matcher = emailPattern.matcher(main);
                while (matcher.find()) {
                    emailSet.add(matcher.group(1));
                }
            }
            System.out.println(String.join(";", emailSet));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
