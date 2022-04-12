package com.example.canvasuistarter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canvasuistarter.api.models.Course;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {

    //get list of courses to use in constructor, might need to be arraylist
    private ArrayList<Course> courses;
    public CoursesAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creates scaffolding/framing for the cards to be created
//        LinearLayout courseLayout = new LinearLayout(parent.getContext());
//        courseLayout.setOrientation(LinearLayout.VERTICAL);
//        courseLayout.setPadding(16,16,16,16);
//
//        //Material card here?
//        TextView courseName = new TextView(parent.getContext());
//        courseName.setTag("courseName");
//        TextView courseDescription = new TextView(parent.getContext());
//        courseDescription.setTag("courseDescription");
//        courseLayout.addView(courseName);
//        courseLayout.addView(courseDescription);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courses.get(position);
        //Material Card Here?
        TextView courseName = holder.itemView.findViewById(R.id.course_name_card);
        TextView courseDescription = holder.itemView.findViewById(R.id.course_description_card);

        courseName.setText(course.name);
        courseDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
