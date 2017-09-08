package com.example.admin.w2d5fridaytest;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class MyHandler extends Thread {

    android.os.Handler handler;

    public MyHandler(android.os.Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();

        Bundle bundle = new Bundle();
        bundle.putString("data", "New message");

        Message message = new Message();
        message.setData(bundle);
        handler.sendMessage(message);
    }
}
