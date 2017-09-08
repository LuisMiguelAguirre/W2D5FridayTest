package com.example.admin.w2d5fridaytest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validateEmail("luis@.aguirre@gmail.com");
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
    //This is only a basic validation, for more precises validations is better to use Regex
    public void validateEmail(String email) {

        if (email.contains("@") && email.contains(".")) {

            if (!email.startsWith("@") && !email.startsWith(".")) {

                if (email.charAt(email.length()-4) == '.') {
                    Log.d("TAG", "onCreate: TRUE" );
                }
            }else{
                Log.d("TAG", "onCreate: FALSE");
            }
        }else {
            Log.d("TAG", "onCreate: FALSE");
        }
    }

    public void addOddToList() {

        final TextView MyID = (TextView) findViewById(R.id.MyID);

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {

            Random r = new Random();
            int value = r.nextInt(10);
            if (value % 2 != 0) {
                list.add(value);
                Log.d("TAG", "addOddToList: " + value   );
            }
        }

        String row="";
        for (int i:list) {
            row += String.valueOf(i) + Html.fromHtml("<br/>");
        }

        MyID.setText(row);

    }

}
