/**
DetectHtmlLink.java
*/
package com.demo.hackerrank.regex;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/************************************
 * Created Date: Jan 9, 2018
 * Created By: ndthien
 * Desc: 
 * **********************************
 * Modified Date: 
 * Modified By: 
 * Desc: 
 ************************************/
public class DetectHtmlLink {

    public static String link = "<a href=\"http://www.hackerrank.com\"><h1><b>HackerRank</b></h1></a>";
    /**
     * @param args
     */
    public static void main(String[] args) {
        //String text = "John writes about this, and John writes about that," + " and John writes about everything. ";

       // String patternString1 = "(John)";
        //String pattern = "<a.*href\\s*=\\s*\"(.+)\">" + "(<(\\w*)>)*(.+)(</\\w*>)*" + "</a>")
        Pattern pattern = Pattern.compile("</([^/<>]*)>");
        Matcher matcher = pattern.matcher(link);
        Set<String> setTag = new TreeSet<String>();

        while (matcher.find()) {
            System.out.println("found: " + matcher.group(1));
            setTag.add(matcher.group(1));
        }
        System.out.println(String.join(";", setTag));
    }

}
