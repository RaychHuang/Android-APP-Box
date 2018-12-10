package com.example.jingzehuang.propellerhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class User {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("address1")
  @Expose
  private String address1;
  @SerializedName("address2")
  @Expose
  private String address2;
  @SerializedName("uid")
  @Expose
  private String uid;
  @SerializedName("sex")
  @Expose
  private String sex;
  @SerializedName("dob")
  @Expose
  private String dob;
  @SerializedName("disease")
  @Expose
  private String disease;
  @SerializedName("medications")
  @Expose
  private List<Medication> medications = null;

  public String getName() {
    return name;
  }

  public String getAddress1() {
    return address1;
  }

  public String getAddress2() {
    return address2;
  }

  public String getUid() {
    return uid;
  }

  public String getSex() {
    return sex;
  }

  public String getDob() {
    return dob;
  }

  public String getDisease() {
    return disease;
  }

  public List<Medication> getMedications() {
    return medications;
  }

}
