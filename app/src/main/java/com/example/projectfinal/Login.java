package com.example.projectfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView loginButton1 = findViewById(R.id.loginButton1);

        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // إنشاء Intent لبدء الـ Activity التالي (SignUp.class)
                Intent intent = new Intent(Login.this, HomeScreen.class);
                startActivity(intent); // بدء الـ Activity الجديد
            }
        });


        TextView loginLink = findViewById(R.id.loginLink);

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // إنشاء Intent لبدء الـ Activity التالي (SignUp.class)
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent); // بدء الـ Activity الجديد
            }
        });


    }
}