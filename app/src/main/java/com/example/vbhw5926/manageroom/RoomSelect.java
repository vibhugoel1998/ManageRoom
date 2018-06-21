package com.example.vbhw5926.manageroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RoomSelect extends AppCompatActivity {
    String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_select);
        Intent intent1=getIntent();
        UserId=intent1.getStringExtra("UserId");
    }
    public void room1(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("UserId",UserId);
        intent.putExtra("room","room1");
        startActivity(intent);

    }
    public void room2(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("UserId",UserId);
        intent.putExtra("room","room2");
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        finish();

    }
}
