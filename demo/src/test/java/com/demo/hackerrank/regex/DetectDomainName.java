/**
DetectDomainName.java
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
public class DetectDomainName {
    public static Pattern pattern = Pattern.compile("(http|https)?://(www.|ww2.)?([a-zA-Z0-9-]+(\\.[A-Za-z0-9-]+)+)");

    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<String> setTag = new TreeSet<String>();
        try (Scanner sc = new Scanner(System.in)) {
            int line = Integer.parseInt(sc.nextLine().trim());
            for (int i = 0; i < line; i++) {
                String s = sc.nextLine();
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    setTag.add(matcher.group(3));
                }
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
