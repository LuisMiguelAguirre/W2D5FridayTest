package com.example.admin.w2d5fridaytest;


public class Singleton {
    private static final Singleton Instance = new Singleton();

    public synchronized static Singleton getInstance() {
        return Instance;
    }

    private Singleton() {
    }
}
