package com.dpbs.collegeapp.CardData.Syllabus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dpbs.collegeapp.CardData.Exam.ExamActivity;
import com.dpbs.collegeapp.R;
import com.dpbs.collegeapp.utility.AppConstants;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.File;

public class SyllabusActivity extends AppCompatActivity {


    ListView syllabusList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        syllabusList = findViewById(R.id.syllabusList);

        String[] Courses = {"Arts Stream(B.A,M.A)","B.C.A","B.Com.","B.Ed.","Science Stream(B.Sc.,M.Sc.)"};

        @SuppressLint("ResourceType") ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.syllabus_list_item,R.id.text,Courses){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView myText = (TextView) view.findViewById(android.R.id.text1);
                return view;

            }
        };

        syllabusList.setAdapter(arrayAdapter);
        syllabusList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = arrayAdapter.getItem(i);
                Intent intent = new Intent(SyllabusActivity.this,SyllabusViewactivity.class);
                intent.putExtra(AppConstants.SYLLABUS_PDF,item);
                startActivity(intent);
            }
        });

    }
}