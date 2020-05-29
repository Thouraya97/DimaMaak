package com.example.mobiup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;

import static android.provider.UserDictionary.Words.APP_ID;

public class ChatBot extends AppCompatActivity {
    String APP_ID ="222cd2c8ea131a70ce77d19abea551759";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);
        getIntent();
        Kommunicate.init(this, APP_ID);

        List<String> agentList = new ArrayList();
        agentList.add("ddali5060@gmail.com"); //add your agentID

        List<String> botList = new ArrayList();
        botList.add("test-jgzug"); //enter your integrated bot Ids

        Kommunicate.launchSingleChat(this, "Support", Kommunicate.getVisitor(), false, true, agentList, botList, new KmCallback(){
            @Override
            public void onSuccess(Object message) {
                Log.d( "ChatLaunch", "Success : " + message);
            }
            @Override
            public void onFailure(Object error) {
                Log.d("ChatLaunch", "Failure : " + error);
            }
        });





    }
}
