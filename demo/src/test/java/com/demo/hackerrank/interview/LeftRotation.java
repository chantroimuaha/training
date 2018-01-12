/**
LeftRotation.java
*/
package com.demo.hackerrank.interview;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class LeftRotation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int length = 0;
            int numRotation = 0;
            //Length
            String arrLen = sc.nextLine();
            //Array
            String arrStr = sc.nextLine();
            
            List<Integer> listX = new LinkedList<Integer>();
            length = Integer.parseInt(arrLen.split(" ")[0]);
            numRotation = Integer.parseInt(arrLen.split(" ")[1]);
            for (String e : arrStr.split(" ")) {
                listX.add(Integer.parseInt(e));
            }
            if (length != listX.size()) throw new IllegalArgumentException("Length isn't equal with size of array");
            for (int i = 0; i < numRotation; i++) {
                listX.add(listX.remove(0));
            }
            for (int e : listX) {
                System.out.print(e + " ");
            }
        } catch(Exception ex) {
            System.err.println(ex);
        }
    }

}
