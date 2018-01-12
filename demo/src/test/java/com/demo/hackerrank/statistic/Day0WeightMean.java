/**
Day0WeightMean.java
*/
package com.demo.hackerrank.statistic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
public class Day0WeightMean {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            //Length
            String lenStr = sc.nextLine();
            //Array
            String arrXStr = sc.nextLine();
            String arrWStr = sc.nextLine();
            
            int length = Integer.parseInt(lenStr);
            List<Integer> listX = new ArrayList<Integer>();
            List<Integer> listW = new ArrayList<Integer>();
            for (String e : arrXStr.split(" ")) {
                listX.add(Integer.parseInt(e));
            }
            int sumW = 0;
            for (String e : arrWStr.split(" ")) {
                listW.add(Integer.parseInt(e));
                sumW += Integer.parseInt(e);
            }
            if (length != listX.size() || length != listW.size()) throw new IllegalArgumentException("Length isn't equal with size of array");
            //Define result
            int sumXW = 0;
            for (int i = 0; i < length; i++) {
                sumXW += listX.get(i) * listW.get(i);
            }
            BigDecimal weightedMean = new BigDecimal(sumXW * 1.0f / sumW);
            weightedMean = weightedMean.setScale(1, RoundingMode.HALF_UP);
            System.out.println(weightedMean);
        } catch(Exception ex) {
            System.err.println(ex);
        }
    }

}
