package com.example.projectfinal;

import android.app.AlertDialog;
import android.content.Intent; // تأكد من وجود هذا السطر
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// استبدل هذا السطر باسم الباكج الصحيح لديك إذا ظهر خطأ هنا
import com.example.projectfinal.databinding.ActivityMainBinding;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ربط الواجهة
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // تهيئة Firebase
        mDatabase = FirebaseDatabase.getInstance().getReference("students");

        // برمجة زر الإضافة (تأكد أن المعرف في XML هو fabAdd)
        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("إضافة طالب جديد");

        // نفخ واجهة الحوار
        View view = getLayoutInflater().inflate(R.layout.dialog_add_student, null);
        final EditText etName = view.findViewById(R.id.etName);
        final EditText etGrade = view.findViewById(R.id.etGrade);

        builder.setView(view);
        builder.setPositiveButton("إضافة", (dialog, which) -> {
            String name = etName.getText().toString().trim();
            String gradeStr = etGrade.getText().toString().trim();

            if (!name.isEmpty() && !gradeStr.isEmpty()) {
                int grade = Integer.parseInt(gradeStr);
                sendToFirebase(name, grade);
            } else {
                Toast.makeText(MainActivity.this, "يرجى تعبئة الحقول", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("إلغاء", null);
        builder.show();
    }

    private void sendToFirebase(String name, int grade) {
        String id = mDatabase.push().getKey();

        // تأكد أن كلاس StudentModel يحتوي على (id, name, grade)
        StudentModel student = new StudentModel(id, name, grade);

        if (id != null) {
            mDatabase.child(id).setValue(student)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(MainActivity.this, "تم الحفظ بنجاح!", Toast.LENGTH_SHORT).show();

                        // السطر المسؤول عن فتح برنامجك بعد الحفظ
                        Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                        startActivity(intent);
                        finish(); // لإغلاق هذه الشاشة
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(MainActivity.this, "خطأ: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        }
    }
}