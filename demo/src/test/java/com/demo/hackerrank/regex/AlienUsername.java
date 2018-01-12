/**
AlienUsername.java
*/
package com.demo.hackerrank.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/************************************
 * Created Date: Jan 10, 2018
 * Created By: ndthien
 * Desc: 
 * **********************************
 * Modified Date: 
 * Modified By: 
 * Desc: 
 ************************************/
public class AlienUsername {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> listMain = new ArrayList<String>();
        try (Scanner sc = new Scanner(System.in)) {
            String numStrMain = sc.nextLine();
            int numMain = Integer.parseInt(numStrMain);
            for (int i = 0; i < numMain; i++) {
                String s = sc.nextLine();
                listMain.add(s);
            }
            String patternStr = "^[_.]\\d+[a-zA-Z]*_?";
            for (String main : listMain) {
                if (main.matches(patternStr)) {
                    System.out.println("VALID");
                } else {
                    System.out.println("INVALID");
                }
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
