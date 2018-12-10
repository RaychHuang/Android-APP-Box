package com.example.jingzehuang.propellerhealth.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.jingzehuang.propellerhealth.R;
import com.example.jingzehuang.propellerhealth.model.Event;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventAdapter  extends RecyclerView.Adapter{

  private final String UNAVAILABLE = "Unavailable";

  private final Context context;
  private final List<Event> events;

  public EventAdapter(Context context) {
    this.context = context;
    events = new ArrayList<>();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
    return new EventViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Event event = events.get(position);
    EventViewHolder vh = (EventViewHolder) holder;
    setView(vh.eventId, "" + event.getId());
    setView(vh.medicationName, event.getMedication());
    setView(vh.medicationType, event.getMedicationtype());
    setView(vh.timestamp, event.getDatetime());
  }

  @Override
  public int getItemCount() {
    return events.size();
  }

  public void addAll(List<Event> list) {
    events.clear();
    events.addAll(list);
    Collections.sort(events, (a, b) -> (b.getDatetime().compareTo(a.getDatetime())));
    notifyDataSetChanged();
  }


  private void setView(TextView tv, @Nullable String str) {
    if (str != null) {
      tv.setText(str);
    } else {
      tv.setText(UNAVAILABLE);
    }
  }

  public class EventViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_event_id)TextView eventId;
    @BindView(R.id.item_event_medication_name)TextView medicationName;
    @BindView(R.id.item_event_medication_type)TextView medicationType;
    @BindView(R.id.item_event_timestamp)TextView timestamp;

    public EventViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

}
