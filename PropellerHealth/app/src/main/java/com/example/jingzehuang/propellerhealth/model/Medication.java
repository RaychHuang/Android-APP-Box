package com.example.jingzehuang.propellerhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medication {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("medicationtype")
  @Expose
  private String medicationtype;

  public String getName() {
    return name;
  }

  public String getMedicationtype() {
    return medicationtype;
  }

}
