package com.dpbs.collegeapp.CardData.TimeTable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dpbs.collegeapp.FullImageView;
import com.dpbs.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class TimeTableActivity extends AppCompatActivity {

    private Spinner timeTableSpinner1;
    private String selectedcourse;
    private TextView courseerror;
    private ImageView imageView;
    private Button button;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        timeTableSpinner1 = (Spinner) findViewById(R.id.timeTableSpinner);
//        timeTableSpinner2 = (Spinner) findViewById(R.id.timeTableSpinner2);
        imageView = findViewById(R.id.timetableview);
        button = findViewById(R.id.ttBtn);
        courseerror = (TextView)findViewById(R.id.textspinner1);
//        yearerror = (TextView)findViewById(R.id.textspinner2);
        progressBar = findViewById(R.id.pd);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference().child("TimeTable");

        String courses[] = {"Select Course", "B.C.A", "B.Com.","B.Ed.","Science Stream(B.Sc,M.Sc.)", "Arts Stream(B.A,M.A)"};
//        String year[] = {"Select year"};
//        String bcaClass[] = {"Select year","B.C.A sem-1", "B.C.A sem-2", "B.C.A sem-3", "B.C.A sem-4", "B.C.A sem-5", "B.C.A sem-6"};
//        String bcomClass[] = {"Select year","B.Com. sem-1", "B.Com. sem-2", "B.Com. sem-3", "B.Com. sem-4", "B.Com. sem-5", "B.Com. sem-6"};
//        String bscClass[] = {"Select year","B.Sc. sem-1", "B.Sc. sem-2", "B.Sc. sem-3", "B.Sc. sem-4", "B.Sc. sem-5", "B.Sc. sem-6"};
//        String baClass[] = {"Select year","B.A sem-1", "B.A sem-2", "B.A sem-3", "B.A sem-4", "B.A sem-5", "B.A sem-6"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, courses);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, year);
        timeTableSpinner1.setAdapter(adapter1);
//        timeTableSpinner2.setAdapter(adapter2);

//
//        ArrayAdapter<String> bcaadapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, bcaClass);
//        ArrayAdapter<String> bcomadapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, bcomClass);
//        ArrayAdapter<String> bscadapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, bscClass);
//        ArrayAdapter<String> baadapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, baClass);

        timeTableSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i1, long l) {
                progressBar.setVisibility(View.GONE);
                selectedcourse = timeTableSpinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(TimeTableActivity.this, "Please Select your course", Toast.LENGTH_LONG).show();

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(selectedcourse.equals("Select Course"))
               {
                   Toast.makeText(TimeTableActivity.this, "Please select your course", Toast.LENGTH_LONG).show();
                   courseerror.setError("Course is required");
                   courseerror.requestFocus();
               }
               else if (selectedcourse.equals("B.C.A"))
               {
                   progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                   courseerror.setError(null);
                   ref.child("BCA").addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           String value = snapshot.getValue(String.class);
                           Picasso.get().load(value).into(imageView);
                           progressBar.setVisibility(View.GONE);
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                           Toast.makeText(TimeTableActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                       }
                   });
               }
               else if (selectedcourse.equals("B.Com."))
               {
                   progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                   courseerror.setError(null);
                   ref.child("BCOM").addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           String value = snapshot.getValue(String.class);
                           Picasso.get().load(value).into(imageView);
                           progressBar.setVisibility(View.GONE);
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                           Toast.makeText(TimeTableActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                       }
                   });
               }
               else if (selectedcourse.equals("B.Ed."))
               {
                   progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                   courseerror.setError(null);
                   ref.child("BEd").addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           String value = snapshot.getValue(String.class);
                           Picasso.get().load(value).into(imageView);
                           progressBar.setVisibility(View.GONE);
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                           Toast.makeText(TimeTableActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                       }
                   });
               }
               else if (selectedcourse.equals("Science Stream(B.Sc,M.Sc.)"))
               {
                   progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                   courseerror.setError(null);
                   ref.child("Science Stream").addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           String value = snapshot.getValue(String.class);
                           Picasso.get().load(value).into(imageView);
                           progressBar.setVisibility(View.GONE);
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                           Toast.makeText(TimeTableActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                       }
                   });
               }
               else if (selectedcourse.equals("Arts Stream(B.A,M.A)"))
               {
                   progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                   courseerror.setError(null);
                   ref.child("Arts Stream").addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           String value = snapshot.getValue(String.class);
                           Picasso.get().load(value).into(imageView);
                           progressBar.setVisibility(View.GONE);
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                           Toast.makeText(TimeTableActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                       }
                   });
               }
            }
        });
    }
}