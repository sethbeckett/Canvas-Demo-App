package com.example.canvasuistarter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.canvasuistarter.api.USUCanvasAPI;
import com.example.canvasuistarter.api.models.Course;
import com.example.canvasuistarter.api.models.UpcomingEvent;
import com.example.canvasuistarter.api.models.User;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, CoursesFragment.class, null)
                    .commit();
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        MaterialToolbar toolbar = findViewById(R.id.top_app_bar);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.open();
        });

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);

            if (menuItem.getItemId() == R.id.courses_item) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container, CoursesFragment.class, null)
                        .commit();
//                System.out.println("Home thingy activated");
                drawerLayout.close();
            }

            if (menuItem.getItemId() == R.id.events_item) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container, EventsFragment.class, null)
                        .commit();
//                System.out.println("Events item selected");
                drawerLayout.close();
            }

            if (menuItem.getItemId() == R.id.profile_item) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container, ProfileFragment.class, null)
                        .commit();
                drawerLayout.close();
//                System.out.println("Profile item selected");
            }

            return true;
        });

        USUCanvasAPI api = USUCanvasAPI.getInstance(this);
        api.getUser(new USUCanvasAPI.OnRequestCompleteListener<User>() {
            @Override
            public void onComplete(User[] result, String errorMessage) {
                System.out.println();
                TextView userName = findViewById(R.id.header_user_name);

                if (result.length > 0) {
                    userName.setText(result[0].name);
                }
            }
        });


        api.getCourses(new USUCanvasAPI.OnRequestCompleteListener<Course>() {
            @Override
            public void onComplete(Course[] result, String errorMessage) {
                System.out.println();
            }
        });

        api.getUpcomingEvents(new USUCanvasAPI.OnRequestCompleteListener<UpcomingEvent>() {
            @Override
            public void onComplete(UpcomingEvent[] result, String errorMessage) {
                System.out.println();
            }
        });
    }
}