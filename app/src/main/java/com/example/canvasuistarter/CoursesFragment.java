package com.example.canvasuistarter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canvasuistarter.api.USUCanvasAPI;
import com.example.canvasuistarter.api.models.Course;

import java.util.ArrayList;
import java.util.Arrays;

public class CoursesFragment extends Fragment {
    public CoursesFragment() {
        super(R.layout.courses_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.courses_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ArrayList<Course> courses = new ArrayList<>();
        USUCanvasAPI api = USUCanvasAPI.getInstance(view.getContext());

        api.getCourses(new USUCanvasAPI.OnRequestCompleteListener<Course>() {
            @Override
            public void onComplete(Course[] result, String errorMessage) {
                courses.addAll(Arrays.asList(result));
//                System.out.println();
//                Log.d("getcourses", courses.toString());
                recyclerView.setAdapter(new CoursesAdapter(courses));
            }
        });

    }
}
