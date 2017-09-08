package com.example.admin.w2d5fridaytest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validateEmail("luis.aguirre.com");
        addOddToList();
        updateViewWithHandler();
    }

    private void updateViewWithHandler() {
        final TextView MyID = (TextView) findViewById(R.id.MyID);
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                MyID.setText(message.getData().getString("data"));
                return false;
            }
        });


        MyHandler testThreadHandlerMessage = new MyHandler(handler);
        testThreadHandlerMessage.start();
    }
    //This validations is only for .com emails, for more precise validations is better to use Regex
    public void validateEmail(String email) {

        if (email.contains("@") && email.contains(".com")) {

            if (!email.startsWith("@") && !email.startsWith(".")) {
                if (email.endsWith(".com")) {
                    Log.d("TAG", "onCreate: TRUE" );
                }
            }

        }else {
            Log.d("TAG", "onCreate: FALSE");
        }
    }

    public void addOddToList() {

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {

            if (i % 2 != 0) {
                list.add(i);
                Log.d("TAG", "addOddToList: " + i);
            }
        }

    }

}
