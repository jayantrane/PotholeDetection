package com.sj.android_to_firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    EditText latitude;
    EditText longitude;
    Button Add;
    Button show_bt;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance().getReference("location");
        latitude=(EditText)findViewById(R.id.latitude);
        longitude=(EditText)findViewById(R.id.longitude);
        Add=(Button)findViewById(R.id.button);
        show_bt=(Button)findViewById(R.id.show);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLocation();
            }
        });
        show_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_Map();
            }
        });

    }
    private void addLocation(){
        String lati=latitude.getText().toString().trim();
        String longi=longitude.getText().toString().trim();
        String id=database.push().getKey();
        Location location=new Location(id,longi,lati);
        database.child(id).setValue(location);
        Toast.makeText(this,"Location Added",Toast.LENGTH_LONG).show();
    }
    private void show_Map()
    {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
