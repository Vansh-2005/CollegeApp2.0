package com.dpbs.collegeapp.CardData.Events;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dpbs.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class EventsActivity extends AppCompatActivity {
    private ImageView eventImage1,eventImage2;
    private TextView eventText1,eventText2;
    private DatabaseReference ref2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getSupportActionBar().setTitle("Upcoming Events");

        eventImage1 = findViewById(R.id.event_image_view1);
        eventImage2 = findViewById(R.id.event_image_view2);

        eventText1 = findViewById(R.id.event_text1);
        eventText2 = findViewById(R.id.event_text2);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref2 = database.getReference().child("Upcoming Events");

        ImageLoad1();
        ImageLoad2();

        TextLoad1();
        TextLoad2();
    }

    private void TextLoad2() {
        ref2.child("2").child("Text").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                eventText2.setText(value);
                eventText2.setSelected(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ImageLoad2() {
        ref2.child("2").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(eventImage2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void TextLoad1() {
        ref2.child("1").child("Text").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                eventText1.setText(value);
                eventText1.setSelected(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ImageLoad1() {
        ref2.child("1").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(eventImage1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}