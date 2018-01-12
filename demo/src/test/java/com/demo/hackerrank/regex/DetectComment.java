/**
DetectComment.java
*/
package com.demo.hackerrank.regex;

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
public class DetectComment {
    public static Pattern pattern = Pattern.compile("(/\\*(.|\\n)*\\*/|//.*)");
    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<String> setTag = new TreeSet<String>();
        try (Scanner sc = new Scanner(System.in)) {
            String s = "sd/*sa\nd*/lgka//js";
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                setTag.add(matcher.group(1));
            }
            if (!setTag.isEmpty()) {
                System.out.println(String.join(";", setTag));
            } else {
                System.out.println("EMPTY");
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
