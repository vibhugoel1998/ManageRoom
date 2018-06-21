package com.example.vbhw5926.manageroom;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookedActivity extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView phoneNo;
    String room;
    private DatabaseReference mDatabase;
    LinearLayout linearLayout;
    EditText namesend;
    EditText requestsend;
    Button send;
    String email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        name=findViewById(R.id.textname);
        email=findViewById(R.id.textemail);
        phoneNo=findViewById(R.id.textphone);
        namesend=findViewById(R.id.sendname);
        requestsend=findViewById(R.id.sendbody);
        send=findViewById(R.id.sendbutton);
        email2="";
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=namesend.getText().toString();
                String body=requestsend.getText().toString();
                Intent intent3=new Intent(Intent.ACTION_SENDTO);
                intent3.setData(Uri.parse("mailto:"+email2));
                intent3.putExtra(Intent.EXTRA_SUBJECT,"Please allow me access to the room");
                intent3.putExtra(Intent.EXTRA_TEXT,"Name :  "+name1+"    Request:  "+body);
                startActivity(Intent.createChooser(intent3, "Send Email"));
            }
        });
        linearLayout=findViewById(R.id.sendlayout);
        if(linearLayout.getVisibility()==View.VISIBLE)
        {
            linearLayout.setVisibility(View.INVISIBLE);
        }
        Intent intent=getIntent();
        String slot=intent.getStringExtra("slot");
        room=intent.getStringExtra("room");
        mDatabase= FirebaseDatabase.getInstance().getReference();
        if(room.equals("room1"))
        {
            mDatabase.child("details").child(slot).child("name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String name1=dataSnapshot.getValue(String.class);
                    name.setText("NAME"+name1);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            mDatabase.child("details").child(slot).child("email").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String email1=dataSnapshot.getValue(String.class);
                    email2=email1;
                    email.setText("EMAIL"+email1);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            mDatabase.child("details").child(slot).child("phoneNo").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String PhoneNo=dataSnapshot.getValue(String.class);
                    phoneNo.setText("PHONE NO"+PhoneNo);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if(room.equals("room2"))
        {
            mDatabase.child("details2").child(slot).child("name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String name1=dataSnapshot.getValue(String.class);
                    name.setText("NAME"+name1);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            mDatabase.child("details2").child(slot).child("email").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String email1=dataSnapshot.getValue(String.class);
                    email.setText("EMAIL"+email1);
                    email2=email1;
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            mDatabase.child("details2").child(slot).child("phoneNo").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String PhoneNo=dataSnapshot.getValue(String.class);
                    phoneNo.setText("PHONE NO"+PhoneNo);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }


    }
    @Override
    public void onBackPressed() {
        finish();

    }

    public void Contact(View view)
    {
        linearLayout.setVisibility(View.VISIBLE);
    }
}
