package com.example.projectfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class ClassScheduleFragment extends Fragment {

    public ClassScheduleFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_class_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();

            // إعادة إظهار الأزرار عند الرجوع
            requireActivity().findViewById(R.id.Student).setVisibility(View.VISIBLE);
            requireActivity().findViewById(R.id.teacher).setVisibility(View.VISIBLE);
            requireActivity().findViewById(R.id.grades).setVisibility(View.VISIBLE);
            requireActivity().findViewById(R.id.exam).setVisibility(View.VISIBLE);
            requireActivity().findViewById(R.id.sub).setVisibility(View.VISIBLE);
            requireActivity().findViewById(R.id.notice).setVisibility(View.VISIBLE);
            requireActivity().findViewById(R.id.homework).setVisibility(View.VISIBLE);
            requireActivity().findViewById(R.id.Schedule).setVisibility(View.VISIBLE);

            requireActivity().findViewById(R.id.fragment_container).setVisibility(View.GONE);
        });
    }
}
