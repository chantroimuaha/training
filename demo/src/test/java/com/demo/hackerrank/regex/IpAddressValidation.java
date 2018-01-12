/**
IpAddressValidation.java
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
public class IpAddressValidation {

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
            String IP4Pattern = "^([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5]).([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5]).([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5]).([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$";
            String IP6Pattern = "^[a-f0-9]{1,4}(:)[a-f0-9]{1,4}\\1[a-f0-9]{1,4}\\1[a-f0-9]{1,4}\\1[a-f0-9]{1,4}\\1[a-f0-9]{1,4}\\1[a-f0-9]{1,4}\\1[a-f0-9]{1,4}$";
            for (String main : listMain) {
                if (main.trim().matches(IP4Pattern)) {
                    System.out.println("IPv4");
                } else if(main.trim().matches(IP6Pattern)) {
                    System.out.println("IPv6");
                } else {
                    System.out.println("Neither");
                }
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
