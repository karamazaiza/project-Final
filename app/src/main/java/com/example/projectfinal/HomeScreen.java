package com.example.projectfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.Student).setOnClickListener(v -> startActivity(new Intent(this, student.class)));
        findViewById(R.id.teacher).setOnClickListener(v -> startActivity(new Intent(this, Teacher.class)));
        findViewById(R.id.grades).setOnClickListener(v -> startActivity(new Intent(this, Grades.class)));
        findViewById(R.id.exam).setOnClickListener(v -> startActivity(new Intent(this, Exams.class)));
        findViewById(R.id.sub).setOnClickListener(v -> startActivity(new Intent(this, SubjectList.class)));
        findViewById(R.id.notice).setOnClickListener(v -> startActivity(new Intent(this, notice.class)));
        findViewById(R.id.homework).setOnClickListener(v -> startActivity(new Intent(this, HomeWork.class)));

        // زر Schedule
        findViewById(R.id.Schedule).setOnClickListener(v -> {
            // إخفاء جميع الأزرار
            findViewById(R.id.Student).setVisibility(android.view.View.GONE);
            findViewById(R.id.teacher).setVisibility(android.view.View.GONE);
            findViewById(R.id.grades).setVisibility(android.view.View.GONE);
            findViewById(R.id.exam).setVisibility(android.view.View.GONE);
            findViewById(R.id.sub).setVisibility(android.view.View.GONE);
            findViewById(R.id.notice).setVisibility(android.view.View.GONE);
            findViewById(R.id.homework).setVisibility(android.view.View.GONE);
            findViewById(R.id.Schedule).setVisibility(android.view.View.GONE);

            // إظهار FrameLayout للفراجمنت
            findViewById(R.id.fragment_container).setVisibility(android.view.View.VISIBLE);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ClassScheduleFragment())
                    .addToBackStack(null)
                    .commit();
        });
    }
}
