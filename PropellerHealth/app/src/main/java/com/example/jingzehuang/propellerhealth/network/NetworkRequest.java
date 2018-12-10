package com.example.jingzehuang.propellerhealth.network;

import com.example.jingzehuang.propellerhealth.model.InputData;
import retrofit2.http.GET;
import rx.Observable;

public interface NetworkRequest {

  @GET("propeller_mobile_assessment_data.json")
  Observable<InputData> getDate();

}
