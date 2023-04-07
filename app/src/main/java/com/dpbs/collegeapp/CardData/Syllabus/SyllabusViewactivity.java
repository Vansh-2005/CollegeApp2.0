package com.dpbs.collegeapp.CardData.Syllabus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.dpbs.collegeapp.R;
import com.dpbs.collegeapp.utility.AppConstants;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SyllabusViewactivity extends AppCompatActivity {

    private PDFView SyllabusPdf;
    private ProgressBar progress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_viewactivity);

        SyllabusPdf = findViewById(R.id.syllabusPdf);
       // progress = findViewById(R.id.pd5);
        String getItem = getIntent().getStringExtra(AppConstants.SYLLABUS_PDF);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref3 = database.getReference().child("Syllabus");


        if (getItem.equals("B.C.A"))
        {

                ref3.child("BCA").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String pdfurl=snapshot.getValue(String.class);
                        new RetrivePDFfromUrl().execute(pdfurl);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

//            String pdfurl="https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Syllabus%2FBCA%2FBCA1.pdf?alt=media&token=d5852f28-9a69-45b3-8957-d0fc9378ba8d";
//            new RetrivePDFfromUrl().execute(pdfurl);
//            //SyllabusPdf.fromUri(Uri.parse("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Syllabus%2FBCA%2FBCA1.pdf?alt=media&token=d5852f28-9a69-45b3-8957-d0fc9378ba8d")).load();
        }
        if (getItem.equals("B.Com."))
        {
            ref3.child("BCom").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String pdfurl=snapshot.getValue(String.class);
                    new RetrivePDFfromUrl().execute(pdfurl);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
        if (getItem.equals("B.Ed."))
        {
            ref3.child("BEd").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String pdfurl=snapshot.getValue(String.class);
                    new RetrivePDFfromUrl().execute(pdfurl);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        if (getItem.equals("Science Stream(B.Sc.,M.Sc.)"))
        {
            ref3.child("Science Stream").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String pdfurl=snapshot.getValue(String.class);
                    new RetrivePDFfromUrl().execute(pdfurl);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        if (getItem.equals("Arts Stream(B.A,M.A)"))
        {
            ref3.child("Arts Stream").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String pdfurl=snapshot.getValue(String.class);
                    new RetrivePDFfromUrl().execute(pdfurl);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

    }
    class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {

            // we are using inputstream
            // for getting out PDF.
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                // creating our connection.
                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    // response is success.
                    // we are getting input stream from url
                    // and storing it in our variable.
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                // this is the method
                // to handle errors.
                e.printStackTrace();
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            // after the execution of our async
            // task we are loading our pdf in our pdf view.
            SyllabusPdf.fromStream(inputStream) .password(null)
                                .defaultPage(0)
                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .spacing(5).load();
        }


    }

}