package com.example.shop.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shop.Courses_contact_Page;
import com.example.shop.R;
import com.example.shop.model.course;

import java.util.List;

public class courseAdapter extends RecyclerView.Adapter<courseAdapter.CourseViewHolder>{

    final Context context;
    final List<course> courses;

    public courseAdapter(Context context, List<course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems  = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);

        return new courseAdapter.CourseViewHolder(courseItems);
    }


    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.courseBg.setCardBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        @SuppressLint("DiscouragedApi") int imageId = context.getResources().getIdentifier(courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImage.setImageResource(imageId);

        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseOpit.setText(courses.get(position).getDate());
        holder.courseFIO.setText((courses.get(position).getLevel()));

        holder.itemView.setOnClickListener(v -> {
        Intent intent = new Intent(context, Courses_contact_Page.class);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                (Activity) context,
                new Pair<View, String>(holder.courseImage, "courseImage")
        );
        intent.putExtra("courseBg", Color.parseColor(courses.get(position).getColor()));
        intent.putExtra("courseImage", imageId);
        intent.putExtra("courseTitle", courses.get(position).getTitle());
        intent.putExtra("courseOpit", courses.get(position).getDate());
        intent.putExtra("courseFIO", courses.get(position).getLevel());
        intent.putExtra("courseText", courses.get(position).getText());
        intent.putExtra("courseId", courses.get(position).getId());
        context.startActivity(intent, options.toBundle());
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder{

        final CardView courseBg;
        final ImageView courseImage;
        final TextView courseTitle;
        final TextView courseFIO;
        final TextView courseOpit;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.courseBg);
            courseImage = itemView.findViewById(R.id.courseImage);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseFIO = itemView.findViewById(R.id.courseFIO);
            courseOpit = itemView.findViewById(R.id.courseOpit);

        }
    }

}
