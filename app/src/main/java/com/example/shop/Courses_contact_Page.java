package com.example.shop;

import static com.example.shop.R.id.coursePageFIO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Courses_contact_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_contact_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseFIO = findViewById(R.id.coursePageFIO);
        TextView courseOpit = findViewById(R.id.coursePageOpit);
        TextView courseText = findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage", 0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseFIO.setText(getIntent().getStringExtra(" courseFIO"));
        courseOpit.setText(getIntent().getStringExtra("courseOpit"));
        courseText.setText(getIntent().getStringExtra("courseText"));

    }
}