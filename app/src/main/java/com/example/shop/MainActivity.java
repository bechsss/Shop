package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.example.shop.adapter.CategoryAdapter;
import com.example.shop.adapter.courseAdapter;
import com.example.shop.model.category;
import com.example.shop.model.course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, itemRecycler;

    CategoryAdapter categoryAdapter;
    courseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<category> categoryList = new ArrayList<>();
        categoryList.add(new category(1, "Фото"));
        categoryList.add(new category(2, "Психология"));
        categoryList.add(new category(3, "Рекрутинг"));
        categoryList.add(new category(4, "Прочее"));

        SetCategoryRecycler(categoryList);

        List<course> courseList = new ArrayList<>();
        courseList.add(new course(1, "frame_8", "Купить контакты", "5 лет", "Смирнов Алексей", "#424345", "Имею большой опыт работы с фоторедакторами. Моё приоритетное направление портретная и предметная съёмка. Постоянно участвую в различных выставках, являюсь членом клуба «Российское фото». В работе использую собственное профессиональное оборудование. Лучшие мои работы можно посмотреть в портфолио."));
        courseList.add(new course(2, "frame_8", "Купить контакты", "3 года", "Иванова Анастасия","#424345", "Большой опыт создания качественных и высокоэстетичных фотографий и изображений для использования в рекламе, маркетинге, журналистике и иных сферах. Являюсь профессиональным пользователем программ Adobe Lightroom и Adobe Photoshop, Capture One."));


        SetCourseRecycler(courseList);


    }

    private void SetCourseRecycler(List<course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        itemRecycler = findViewById(R.id.itemRecycler);
        itemRecycler.setLayoutManager(layoutManager);

        courseAdapter = new courseAdapter(this, courseList);
        itemRecycler.setAdapter(courseAdapter);
    }

    private void SetCategoryRecycler(List<category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }
}
