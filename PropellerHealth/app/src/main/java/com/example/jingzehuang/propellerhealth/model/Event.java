package com.example.jingzehuang.propellerhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Event {
  @SerializedName("uid")
  @Expose
  private String uid;
  @SerializedName("datetime")
  @Expose
  private String datetime;
  private Date timestamp;
  @SerializedName("medication")
  @Expose
  private String medication;
  @SerializedName("medicationtype")
  @Expose
  private String medicationtype;
  @SerializedName("id")
  @Expose
  private Integer id;

  public Event() {

  }

  public Event(int id, String name, String type, String timestamp) {
    this.id = id;
    this.medication = name;
    this.medicationtype = type;
    this.datetime = timestamp;
  }


  public String getUid() {
    return uid;
  }

  public String getDatetime() {
    return datetime;
  }

  public Date getTimestamp() {
    if (timestamp == null) {
      timestamp = new Date(datetime);
    }
    return timestamp;
  }

  public String getMedication() {
    return medication;
  }

  public String getMedicationtype() {
    return medicationtype;
  }

  public Integer getId() {
    return id;
  }

}
