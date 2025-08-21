package com.example.projectfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubjectList extends AppCompatActivity {

    ListView subjectListView;
    String[] subjects = {"Mathematics", "Arabic", "English", "Technology", "Chemistry", "Physics"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subject_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // زر الرجوع
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectList.this, HomeScreen.class);
            startActivity(intent);
        });

        // إعداد ListView
        subjectListView = findViewById(R.id.subjectListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_subject,
                R.id.subjectButton,
                subjects
        );

        subjectListView.setAdapter(adapter);

        subjectListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSubject = subjects[position];
            Class<?> targetActivity = null;

            switch (selectedSubject) {
                case "Mathematics":
                    targetActivity = Mathematics.class;
                    break;
                case "Arabic":
                    targetActivity = Arabic.class;
                    break;
                case "English":
                    targetActivity = English.class;
                    break;
                case "Technology":
                    targetActivity = Technology.class;
                    break;
                case "Chemistry":
                    targetActivity = Chemistry.class;
                    break;
                case "Physics":
                    targetActivity = Physics.class;
                    break;
                default:
                    Toast.makeText(this, "No activity found", Toast.LENGTH_SHORT).show();
                    return;
            }

            Intent intent = new Intent(SubjectList.this, targetActivity);
            startActivity(intent);
        });
    }
}
