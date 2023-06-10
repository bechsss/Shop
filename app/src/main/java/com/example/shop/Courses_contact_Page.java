package com.example.shop;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.shop.model.Order;

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
        courseFIO.setText(getIntent().getStringExtra("courseFIO"));
        courseOpit.setText(getIntent().getStringExtra("courseOpit"));
        courseText.setText(getIntent().getStringExtra("courseText"));

    }

    public void addToCart(View view) {
        int item_id = getIntent().getIntExtra("courseId", 0);
        Order.items_id.add(item_id);
        Toast.makeText(this, "Добавлено", Toast.LENGTH_LONG).show();

    }
}

