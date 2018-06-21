package com.example.vbhw5926.manageroom;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AllBookings extends AppCompatActivity {
    ListView listView;
    String UserId;
    String room;
    ArrayList<String> Bookings;
    ArrayAdapter<String> bookingAdapter;
    private DatabaseReference mDatabase;
    String id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_bookings);
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        UserId=intent.getStringExtra("UserId");
        mDatabase= FirebaseDatabase.getInstance().getReference();
        listView=findViewById(R.id.alllistview);
        Log.d("check12",id);
        if(id!=null && id.equals("current")) {
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                    Log.d("check11","true");
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AllBookings.this);
                    builder1.setMessage("Do you want to delete?");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Log.d("check6", Bookings.get(0));
                                    Log.d("check7", Bookings.get(1));
                                    String slotclicked = Bookings.get(i);
                                    Log.d("check5", slotclicked);
                                    if (room.equals("room1")) {
                                        mDatabase.child("details").child(slotclicked).child("name").removeValue();
                                        mDatabase.child("details").child(slotclicked).child("UserId").removeValue();
                                        mDatabase.child("details").child(slotclicked).child("phoneNo").removeValue();
                                        mDatabase.child("details").child(slotclicked).child("email").removeValue();
                                        mDatabase.child("details").child(slotclicked).child("Avail").setValue("yes");
                                    } else if (room.equals("room2")) {
                                        mDatabase.child("details2").child(slotclicked).child("name").removeValue();
                                        mDatabase.child("details2").child(slotclicked).child("UserId").removeValue();
                                        mDatabase.child("details2").child(slotclicked).child("phoneNo").removeValue();
                                        mDatabase.child("details2").child(slotclicked).child("email").removeValue();
                                        mDatabase.child("details2").child(slotclicked).child("Avail").setValue("yes");
                                    }
                                    Bookings.remove(i);
                                    bookingAdapter.notifyDataSetChanged();
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


                    return true;
                }
            });
        }
        else if(id!=null && id.equals("change"))
        {
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String slotClicked=Bookings.get(i);
                    Intent intent4=new Intent(AllBookings.this,Change.class);
                    intent4.putExtra("slot",slotClicked);
                    intent4.putExtra("room",room);
                    startActivity(intent4);
                    return true;
                }
            });
        }
        Bookings=new ArrayList<>();
        bookingAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Bookings);
        listView.setAdapter(bookingAdapter);
        Log.d("check1",UserId);
        room=intent.getStringExtra("room");
        Log.d("check2",room);
        if(room.equals("room1"))
        {
            fetchAllDetails();
        }
        else if(room.equals("room2"))
        {
            fetchAllDetails2();
        }

    }

    private void fetchAllDetails2() {
        mDatabase.child("details2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Log.d("check7",snapshot.getKey());
                    if(snapshot.child("UserId")!=null && snapshot.child("UserId").getValue(String.class).equals(UserId))
                    {
                        Log.d("check10","true");
                        Bookings.add(snapshot.getKey());
                        bookingAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void fetchAllDetails() {
        mDatabase.child("details").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Log.d("check8",snapshot.getKey());
                    if(snapshot.child("UserId")!=null && snapshot.child("UserId").getValue(String.class)!=null && snapshot.child("UserId").getValue(String.class).equals(UserId))
                    {
                        Log.d("check9","true");
                        Bookings.add(snapshot.getKey());
                        bookingAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();

    }
}
