package com.dpbs.collegeapp.CardData.Toppers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dpbs.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ToppersActivity extends AppCompatActivity {

    private ImageView mscImage,maSanImage,mscChemImage,bedImage,baImage
            ,bscImage,bcaImage,bcomImage;
    private TextView mscTopperName,maSanTopperName,mscChemTopperName,bedTopperName,baTopperName
            ,bscTopperName,bcaTopperName,bcomTopperName;

    private TextView mscPercent,maSanPercent,mscChemPercent,bedPercent,baPercent
            ,bscPercent,bcaPercent,bcomPercent;
    private DatabaseReference ref;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppers);

        mscImage = findViewById(R.id.mscImage);
        maSanImage = findViewById(R.id.maImage);
        mscChemImage = findViewById(R.id.msc_chem_Image);
        bedImage = findViewById(R.id.bed_Image);
        baImage = findViewById(R.id.ba_Image);
        bscImage = findViewById(R.id.bsc_Image);
        bcaImage = findViewById(R.id.bca_Image);
        bcomImage = findViewById(R.id.bcom_Image);


        mscTopperName = findViewById(R.id.msc_topper_name);
       maSanTopperName = findViewById(R.id.ma_topper_name);
        mscChemTopperName = findViewById(R.id.msc_chem__topper_name);
        bedTopperName = findViewById(R.id.bed_topper_name);
        baTopperName = findViewById(R.id.ba_topper_name);
//        bscTopperName = findViewById(R.id.bsc_topper_name);
        bcaTopperName = findViewById(R.id.bca_topper_name);
//        bcomTopperName = findViewById(R.id.bcom_topper_name);


        mscPercent = findViewById(R.id.msc_percentage);
        maSanPercent = findViewById(R.id.ma_percentage);
        mscChemPercent= findViewById(R.id.msc_chem_percentage);
        bedPercent= findViewById(R.id.bed_percentage);
        baPercent= findViewById(R.id.ba_percentage);
//        bscPercent= findViewById(R.id.bsc_percentage);
        bcaPercent= findViewById(R.id.bca_percentage);
//        bcomPercent= findViewById(R.id.bcom_percentage);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
         ref = database.getReference().child("Toppers");

        MscPhysics();
        MscChemistry();
        MaSanskrit();
        bed();
        ba();
        bsc();
        bca();
        bcom();

    }

    private void bcom() {
        ref.child("BCom").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into( bcomImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void bca() {
        ref.child("BCA").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into( bcaImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
           }

    private void bsc() {
        ref.child("BSc").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into( bscImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
           }

    private void ba() {
        ref.child("BA").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into( baImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void bed() {
        ref.child("BEd").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into( bedImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref.child("BEd").child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                bedTopperName.setSelected(true);
                bedTopperName.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child("BEd").child("Percentage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value1;
                value1 = snapshot.getValue(String.class);
                bedPercent.setSelected(true);
                bedPercent.setText(value1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void MscChemistry() {
        ref.child("MSc Chemistry").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into( mscChemImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref.child("MSc Chemistry").child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                mscChemTopperName.setSelected(true);
                mscChemTopperName.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child("MSc Chemistry").child("Percentage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                mscChemPercent.setSelected(true);
                mscChemPercent.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void MaSanskrit() {
        ref.child("MA Sanskrit").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(maSanImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref.child("MA Sanskrit").child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                maSanTopperName.setSelected(true);
                maSanTopperName.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child("MA Sanskrit").child("Percentage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                maSanPercent.setSelected(true);
                maSanPercent.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void MscPhysics() {
        ref.child("MSc Physics").child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(mscImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref.child("MSc Physics").child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                mscTopperName.setSelected(true);
                mscTopperName.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child("MSc Physics").child("Percentage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                mscPercent.setSelected(true);
                mscPercent.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}