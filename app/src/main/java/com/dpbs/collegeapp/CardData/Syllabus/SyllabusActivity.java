package com.dpbs.collegeapp.CardData.Syllabus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import com.dpbs.collegeapp.CardData.Exam.ExamActivity;
import com.dpbs.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class SyllabusActivity extends AppCompatActivity {
    private Spinner syllabusSpinner1;
    private String selectedcourse;
    private TextView courseerror;
    private ImageView syllabusView;
    private Button button;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        syllabusSpinner1 = (Spinner) findViewById(R.id.syllabusSpinner);
//        timeTableSpinner2 = (Spinner) findViewById(R.id.timeTableSpinner2);
        syllabusView = (ImageView) findViewById(R.id.syllabusView);
        button = findViewById(R.id.syllabusBtn);
        courseerror = (TextView) findViewById(R.id.textspinner2);
//        yearerror = (TextView)findViewById(R.id.textspinner2);
        progressBar = findViewById(R.id.pd);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref3 = database.getReference().child("Syllabus");

        String courses[] = {"Select Course", "B.C.A", "B.Com.", "B.Ed.", "Science Stream(B.Sc,M.Sc.)", "Arts Stream(B.A,M.A)"};
//        String year[] = {"Select year"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, courses);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, year);
        syllabusSpinner1.setAdapter(adapter1);

        syllabusSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i1, long l) {
                progressBar.setVisibility(View.GONE);
                selectedcourse = syllabusSpinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(SyllabusActivity.this, "Please Select your course", Toast.LENGTH_LONG).show();

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedcourse.equals("Select Course")) {
                    Toast.makeText(SyllabusActivity.this, "Please select your course", Toast.LENGTH_LONG).show();
                    courseerror.setError("Course is required");
                    courseerror.requestFocus();
                } else if (selectedcourse.equals("B.C.A")) {
                    progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                    courseerror.setError(null);
                    ref3.child("BCA").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);
                            Picasso.get().load(value).into(syllabusView);
                            progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                            Toast.makeText(SyllabusActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (selectedcourse.equals("B.Com.")) {
                    progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                    courseerror.setError(null);
                    ref3.child("BCOM").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);
                            Picasso.get().load(value).into(syllabusView);
                            progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                            Toast.makeText(SyllabusActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (selectedcourse.equals("B.Ed.")) {
                    progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                    courseerror.setError(null);
                    ref3.child("BEd").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);
                            Picasso.get().load(value).into(syllabusView);
                            progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                            Toast.makeText(SyllabusActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (selectedcourse.equals("Science Stream(B.Sc,M.Sc.)")) {
                    progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                    courseerror.setError(null);
                    ref3.child("Science Stream").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);
                            Picasso.get().load(value).into(syllabusView);
                            progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                            Toast.makeText(SyllabusActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (selectedcourse.equals("Arts Stream(B.A,M.A)")) {
                    progressBar.setVisibility(View.VISIBLE);
//                   yearerror.setError(null);
                    courseerror.setError(null);
                    ref3.child("Arts Stream").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);
                            Picasso.get().load(value).into(syllabusView);
                            progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                            Toast.makeText(SyllabusActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}