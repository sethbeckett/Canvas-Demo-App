package com.example.canvasuistarter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canvasuistarter.api.models.UpcomingEvent;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter {

    private ArrayList<UpcomingEvent> upcomingEvents;
    public EventsAdapter(ArrayList<UpcomingEvent> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UpcomingEvent upcomingEvent = upcomingEvents.get(position);
        TextView eventName = holder.itemView.findViewById(R.id.event_text);
        eventName.setText(upcomingEvent.title);
    }

    @Override
    public int getItemCount() {
        return upcomingEvents.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
