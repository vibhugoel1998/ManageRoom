package com.example.vbhw5926.manageroom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    private DatabaseReference mDatabase;
    String slot;
    EditText name;
    EditText email;
    EditText phoneNo;
    String userid;
    String room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phoneNo=findViewById(R.id.phone);
        mDatabase= FirebaseDatabase.getInstance().getReference();
        Intent intent=getIntent();
        slot=intent.getStringExtra("slot");
        userid=intent.getStringExtra("UserId");
        room=intent.getStringExtra("room");

    }
    public void SignIn(View view)
    {
        String name1=name.getText().toString();
        String email1=email.getText().toString();
        String UserId1=userid;
        String phoneNo1=phoneNo.getText().toString();
        if(room.equals("room1"))
        {
            if(name1!=null && email1!=null && UserId1!=null && phoneNo1!=null)
            {
                mDatabase.child("details").child(slot).child("name").setValue(name1);
                mDatabase.child("details").child(slot).child("email").setValue(email1);
                mDatabase.child("details").child(slot).child("UserId").setValue(UserId1);
                mDatabase.child("details").child(slot).child("phoneNo").setValue(phoneNo1);
                mDatabase.child("details").child(slot).child("Avail").setValue("no");
                finish();
            }
            else
            {
                Toast.makeText(this, "Kindly fill all details", Toast.LENGTH_SHORT).show();
            }
        }
        else if(room.equals("room2"))
        {
            if(name1!=null && email1!=null && UserId1!=null && phoneNo1!=null)
            {
                mDatabase.child("details2").child(slot).child("name").setValue(name1);
                mDatabase.child("details2").child(slot).child("email").setValue(email1);
                mDatabase.child("details2").child(slot).child("UserId").setValue(UserId1);
                mDatabase.child("details2").child(slot).child("phoneNo").setValue(phoneNo1);
                mDatabase.child("details2").child(slot).child("Avail").setValue("no");
                finish();
            }
            else
            {
                Toast.makeText(this, "Kindly fill all details", Toast.LENGTH_SHORT).show();
            }
        }

    }
    @Override
    public void onBackPressed() {
        finish();

    }
}
