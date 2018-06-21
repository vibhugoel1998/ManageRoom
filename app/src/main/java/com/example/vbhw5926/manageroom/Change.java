package com.example.vbhw5926.manageroom;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Change extends AppCompatActivity {
    String slot;
    EditText editTextname;
    EditText editTextemail;
    EditText editTextphoneno;
    EditText editTextUserid;
    private DatabaseReference mDatabase;
    String room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        editTextemail=findViewById(R.id.newemail);
        editTextname=findViewById(R.id.newname);
        editTextphoneno=findViewById(R.id.newPhone);
        editTextUserid=findViewById(R.id.newUserId);
        Intent intent=getIntent();
        slot=intent.getStringExtra("slot");
        mDatabase= FirebaseDatabase.getInstance().getReference();
        room=intent.getStringExtra("room");
    }
    public void ChangeUser(View view)
    {
        final String name=editTextname.getText().toString();
        final String email=editTextemail.getText().toString();
        final String phoneno=editTextphoneno.getText().toString();
        final String UserId=editTextUserid.getText().toString();
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Change.this);
        builder1.setMessage("Are you sure?");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(room.equals("room1"))
                        {
                            mDatabase.child("details").child(slot).child("name").setValue(name);
                            mDatabase.child("details").child(slot).child("email").setValue(email);
                            mDatabase.child("details").child(slot).child("UserId").setValue(UserId);
                            mDatabase.child("details").child(slot).child("phoneNo").setValue(phoneno);
                        }
                        else if(room.equals("room2"))
                        {
                            mDatabase.child("details2").child(slot).child("name").setValue(name);
                            mDatabase.child("details2").child(slot).child("email").setValue(email);
                            mDatabase.child("details2").child(slot).child("UserId").setValue(UserId);
                            mDatabase.child("details2").child(slot).child("phoneNo").setValue(phoneno);
                        }
                        finish();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
