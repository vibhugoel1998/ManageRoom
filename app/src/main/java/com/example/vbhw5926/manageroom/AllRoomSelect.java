package com.example.vbhw5926.manageroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AllRoomSelect extends AppCompatActivity {
    String room;
    String id;
    String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_room_select);
        Intent intent=getIntent();
        room=intent.getStringExtra("room");
        UserId=intent.getStringExtra("UserId");
        id=intent.getStringExtra("id");

    }
    public void Room1(View view)
    {
        Intent intent1=new Intent(AllRoomSelect.this,AllBookings.class);
        intent1.putExtra("room",room);
        intent1.putExtra("UserId",UserId);
        intent1.putExtra("id",id);
        startActivity(intent1);
    }
    public void Room2(View view)
    {
        Intent intent1=new Intent(AllRoomSelect.this,AllBookings.class);
        intent1.putExtra("room",room);
        intent1.putExtra("UserId",UserId);
        intent1.putExtra("id",id);
        startActivity(intent1);
    }
    @Override
    public void onBackPressed() {
        finish();

    }
}
