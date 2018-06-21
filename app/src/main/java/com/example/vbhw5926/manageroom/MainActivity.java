package com.example.vbhw5926.manageroom;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    LinearLayout rootLayout;
    public Details buttonArray[][];
    int count;
    String check1;
    String userid3;
    String room;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent2=getIntent();
        userid3=intent2.getStringExtra("UserId");
        room=intent2.getStringExtra("room");
        mDatabase=FirebaseDatabase.getInstance().getReference();
        count=12;
        rootLayout=findViewById(R.id.rootlayout);
        rootLayout.removeAllViews();
        buttonArray=new Details[3][4];
        for(int i=0;i<3;i++)
        {
            LinearLayout layout=new LinearLayout(this);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1);
            layout.setLayoutParams(params);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            for(int j=0;j<4;j++)
            {
                Details button=new Details(this);
                LinearLayout.LayoutParams buttonParams=new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1);
                button.setLayoutParams(buttonParams);
                int count1=count+1;
                button.setSlot(count+"-"+count1);
                button.setText(count+"-"+count1);
                button.setI(i);
                button.setJ(j);
                layout.addView(button);
                buttonArray[i][j]=button;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Details button = (Details) v;
                        final String slot = button.getSlot();
                        if (room.equals("room1")) {
                            mDatabase.child("details").child(slot).child("Avail").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    check1 = dataSnapshot.getValue(String.class);
                                    if (check1.equals("yes") == true) {
                                        Intent intent = new Intent(MainActivity.this, SignUp.class);
                                        intent.putExtra("slot", slot);
                                        intent.putExtra("UserId", userid3);
                                        intent.putExtra("room",room);
                                        startActivity(intent);
                                    } else if (check1 != null && check1.equals("no") == true) {
                                        Intent intent1 = new Intent(MainActivity.this, BookedActivity.class);
                                        intent1.putExtra("slot", slot);
                                        intent1.putExtra("room",room);
                                        startActivity(intent1);
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                        else if(room.equals("room2"))
                        {
                            mDatabase.child("details2").child(slot).child("Avail").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    check1 = dataSnapshot.getValue(String.class);
                                    if (check1.equals("yes") == true) {
                                        Intent intent = new Intent(MainActivity.this, SignUp.class);
                                        intent.putExtra("slot", slot);
                                        intent.putExtra("UserId", userid3);
                                        intent.putExtra("room",room);
                                        startActivity(intent);
                                    } else if (check1 != null && check1.equals("no") == true) {
                                        Intent intent1 = new Intent(MainActivity.this, BookedActivity.class);
                                        intent1.putExtra("slot", slot);
                                        intent1.putExtra("room",room);
                                        startActivity(intent1);
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                    }
                });

                count++;
            }
            rootLayout.addView(layout);
        }
        if(room.equals("room1"))
        {
            setArray();
        }
        else if(room.equals("room2"))
        {
            setArray2();
        }

    }

    private void setArray2() {
        int count2=12;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<4;j++)
            {
                final Details newObj=buttonArray[i][j];
                int count3=count2+1;

                mDatabase.child("details2").child(count2+"-"+count3).child("Avail").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        check1=dataSnapshot.getValue(String.class);
                        if(check1.equals("yes")==true)
                        {
                            newObj.setBackgroundResource(R.drawable.yes);
                        }
                        else if(check1!=null && check1.equals("no")==true)
                        {
                            newObj.setBackgroundResource(R.drawable.no);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();

                    }
                });
                count2++;
            }
        }
    }

    private void setArray() {
        int count2=12;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<4;j++)
            {
                final Details newObj=buttonArray[i][j];
                int count3=count2+1;

                mDatabase.child("details").child(count2+"-"+count3).child("Avail").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        check1=dataSnapshot.getValue(String.class);
                        if(check1.equals("yes")==true)
                        {
                            newObj.setBackgroundResource(R.drawable.yes);
                        }
                        else if(check1!=null && check1.equals("no")==true)
                        {
                            newObj.setBackgroundResource(R.drawable.no);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();

                    }
                });
                count2++;
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.current)
        {
            Intent intent=new Intent(MainActivity.this,AllRoomSelect.class);
            Log.d("check",userid3);
            intent.putExtra("UserId",userid3);
            intent.putExtra("room",room);
            intent.putExtra("id","current");
            startActivity(intent);
        }
        else if(id==R.id.change)
        {
            Intent intent=new Intent(MainActivity.this,AllRoomSelect.class);
            Log.d("check",userid3);
            intent.putExtra("UserId",userid3);
            intent.putExtra("room",room);
            intent.putExtra("id","change");
            startActivity(intent);
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        finish();

    }
}
