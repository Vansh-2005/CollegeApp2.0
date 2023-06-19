package com.dpbs.collegeapp.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.dpbs.collegeapp.CardData.Events.EventsActivity;
import com.dpbs.collegeapp.CardData.Exam.ExamActivity;
import com.dpbs.collegeapp.CardData.Fees.FeesActivity;
import com.dpbs.collegeapp.CardData.Syllabus.SyllabusActivity;
import com.dpbs.collegeapp.CardData.TimeTable.TimeTableActivity;
import com.dpbs.collegeapp.CardData.Toppers.ToppersActivity;
import com.dpbs.collegeapp.CardData.Website.WebsiteActivity;
import com.dpbs.collegeapp.R;
import com.dpbs.collegeapp.drawer_details.ContactUsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private ImageSlider mainslider;
    private DatabaseReference databaseReference;
    private TextView marquee;
    private String url ="";
    private String text;

    CardView timeTable, exam, syllabus, events, toppers, fees, contact, website;
    //private ImageView mapLocation;
    //TextView bcadepart,bscdepart,bcomdepart,badepart;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        marquee = view.findViewById(R.id.marquee);
        timeTable = view.findViewById(R.id.timeTable);
        exam = view.findViewById(R.id.exam);
        syllabus = view.findViewById(R.id.syllabus);
        events = view.findViewById(R.id.events);
        toppers = view.findViewById(R.id.toppers);
        fees = view.findViewById(R.id.fees);
        contact = view.findViewById(R.id.contact);
        website = view.findViewById(R.id.website);

        timeTable.setOnClickListener(this);
        exam.setOnClickListener(this);
        syllabus.setOnClickListener(this);
        events.setOnClickListener(this);
        toppers.setOnClickListener(this);
        fees.setOnClickListener(this);
        contact.setOnClickListener(this);
        website.setOnClickListener(this);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbar_background));
        actionBar.setTitle("");

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Marquee");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    url = snapshot.child("Link").getValue(String.class);
                    text = snapshot.child("News").getValue(String.class);

                    ForegroundColorSpan foregroundSpan = new ForegroundColorSpan(Color.parseColor("#910000"));


                    SpannableString ss = new SpannableString(text);
                    ClickableSpan clickableSpan = new ClickableSpan() {
                        @Override
                        public void onClick(View textView) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(url));
                            startActivity(intent);
                        }
                        @Override
                        public void updateDrawState(TextPaint ds) {
                            super.updateDrawState(ds);
                            ds.setUnderlineText(true);
                        }
                    };
                    ss.setSpan(clickableSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    ss.setSpan(foregroundSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    marquee.setText(ss);
                    marquee.setMovementMethod(LinkMovementMethod.getInstance());
                    marquee.setSelected(true);
                    marquee.setHighlightColor(Color.TRANSPARENT);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
//        marquee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(url));
//                startActivity(intent);
//            }
//        });
//


        //Getting the image slder

        mainslider = (ImageSlider) view.findViewById(R.id.image_slider);
        final List<SlideModel> remoteimages = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child("Slider")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren())
                            remoteimages.add(new SlideModel(data.child("url").getValue().toString()
                                    , data.child("title").getValue().toString(), ScaleTypes.FIT));

                        mainslider.setImageList(remoteimages, ScaleTypes.FIT);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


        return view;
    }

    @Override
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()) {
            case R.id.timeTable:
                intent = new Intent(getContext(),TimeTableActivity.class);
                startActivity(intent);
                break;

            case R.id.exam:
                intent = new Intent(getContext(), ExamActivity.class);
                startActivity(intent);
                break;

            case R.id.events:
                intent = new Intent(getContext(), EventsActivity.class);
                startActivity(intent);
                break;

            case R.id.syllabus:
                intent = new Intent(getContext(), SyllabusActivity.class);
                startActivity(intent);
                break;

            case R.id.toppers:
                intent = new Intent(getContext(), ToppersActivity.class);
                startActivity(intent);
                break;


            case R.id.fees:
                intent = new Intent(getContext(), FeesActivity.class);
                startActivity(intent);
                break;

            case R.id.contact:
               intent = new Intent(getContext(),ContactUsActivity.class);
               startActivity(intent);
                break;

            case R.id.website:
                intent = new Intent(getContext(), WebsiteActivity.class);
                startActivity(intent);
//                intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://dpbspgcollege.edu.in/"));
//                startActivity(intent);
                break;
        }
    }
}

