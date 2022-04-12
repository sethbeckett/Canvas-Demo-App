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
import com.example.canvasuistarter.api.models.UpcomingEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class EventsFragment extends Fragment {
    public EventsFragment() {
        super(R.layout.events_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.events_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ArrayList<UpcomingEvent> upcomingEvents = new ArrayList<>();
        USUCanvasAPI api = USUCanvasAPI.getInstance(view.getContext());

        api.getUpcomingEvents(new USUCanvasAPI.OnRequestCompleteListener<UpcomingEvent>() {
            @Override
            public void onComplete(UpcomingEvent[] result, String errorMessage) {
                upcomingEvents.addAll(Arrays.asList(result));
                recyclerView.setAdapter(new EventsAdapter(upcomingEvents));
            }
        });

    }
}
