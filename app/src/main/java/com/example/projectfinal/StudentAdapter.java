package com.example.projectfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<StudentModel> studentList;

    // Constructor لاستقبال قائمة الطلاب
    public StudentAdapter(List<StudentModel> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ربط ملف التصميم student_item.xml بالـ Adapter
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // جلب بيانات الطالب بناءً على موقعه في القائمة
        StudentModel student = studentList.get(position);

        // عرض البيانات في الـ TextViews (تأكد أن الدوال موجودة في StudentModel)
        holder.txtId.setText("ID: " + student.getId());
        holder.txtName.setText("Name: " + student.getName());
        holder.txtGrade.setText("Grade: " + student.getGrade());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    // كلاس الـ ViewHolder لتعريف العناصر داخل كل سطر
    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtName, txtGrade;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            // ربط المتغيرات بالـ IDs الموجودة في ملف student_item.xml
            txtId = itemView.findViewById(R.id.txtId);
            txtName = itemView.findViewById(R.id.txtName);
            txtGrade = itemView.findViewById(R.id.txtGrade);
        }
    }
}