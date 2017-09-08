package com.example.admin.w2d5fridaytest;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class Singleton {
    private static final Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
