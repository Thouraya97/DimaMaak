package com.example.mobiup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_alarm);
        Button stop = (Button) findViewById(R.id.stop) ;
        TextView name = (TextView) findViewById(R.id.medname);
        final String [] myReminders={"Remember to wash your hands","Keep your one meter safe distance","Put your mask","a3mel désinféctant"};
        final int rand= (int) (Math.random()*4);
        name.setText(myReminders[rand]);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
