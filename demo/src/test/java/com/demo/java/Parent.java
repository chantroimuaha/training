/**
Parent.java
*/
package com.demo.java;

/************************************
 * Created Date: Dec 21, 2017
 * Created By: ndthien
 * Desc: 
 * **********************************
 * Modified Date: 
 * Modified By: 
 * Desc: 
 ************************************/
public class Parent {

    public static void getP() {} 
    public static void main(String[] args) {
        Child child = new Child();
        Child.getP();
    }
}

class Child extends Parent {
    public static void getS() {}
}
