package com.mybaits;

/**
 * Created by wqkenqing on 2017/3/23.
 */
public class Prototype implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setName("ken");
        Prototype prototype1 = (Prototype) prototype.clone();
        prototype1.setName("joe");
        System.out.println(prototype);
        System.out.println(prototype1);
    }
}
