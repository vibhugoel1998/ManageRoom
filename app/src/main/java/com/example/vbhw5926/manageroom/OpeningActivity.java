package com.example.vbhw5926.manageroom;

import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OpeningActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        editText=findViewById(R.id.loginid);
    }
    public void NewUser(View view)
    {
        String UserId=editText.getText().toString();
        if(UserId.equals(null) || UserId.equals(" ") || UserId.equals(""))
        {
            Toast.makeText(this, "Enter UserId", Toast.LENGTH_SHORT).show();
        }
        else if(UserId!=null)
        {
            Intent intent=new Intent(this,RoomSelect.class);
            intent.putExtra("UserId",UserId);
            startActivity(intent);
        }

    }
    @Override
    public void onBackPressed() {
        finish();

    }

}

