package com.example.jingzehuang.propellerhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class InputData {

  @SerializedName("user")
  @Expose
  private User user;
  @SerializedName("events")
  @Expose
  private List<Event> events = null;

  public User getUser() {
    return user;
  }

  public List<Event> getEvents() {
    return events == null ? new ArrayList<Event>() : events;
  }

}
