package com.dpbs.collegeapp.CardData.Syllabus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.dpbs.collegeapp.R;
import com.dpbs.collegeapp.utility.AppConstants;
import com.github.barteksc.pdfviewer.PDFView;

public class SyllabusViewactivity extends AppCompatActivity {

    private PDFView SyllabusPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_viewactivity);

        SyllabusPdf = findViewById(R.id.syllabusPdf);
        String getItem = getIntent().getStringExtra(AppConstants.SYLLABUS_PDF);

        if (getItem.equals("B.C.A")){
            SyllabusPdf.fromAsset("BCA1.pdf").load();
        }
        if (getItem.equals("B.Com.")){
            SyllabusPdf.fromAsset("BCA1.pdf").load();
        }
        if (getItem.equals("B.Ed.")){
            SyllabusPdf.fromAsset("BCA1.pdf").load();
        }
        if (getItem.equals("Science Stream(B.Sc.,M.Sc.)")){
            SyllabusPdf.fromAsset("BCA1.pdf").load();
        }
        if (getItem.equals("Arts Stream(B.A,M.A)")){
            SyllabusPdf.fromAsset("BCA1.pdf").load();
        }

    }
}