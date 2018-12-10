package com.example.jingzehuang.propellerhealth.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.jingzehuang.propellerhealth.R;
import com.example.jingzehuang.propellerhealth.model.Event;
import com.example.jingzehuang.propellerhealth.model.InputData;
import com.example.jingzehuang.propellerhealth.network.BaseUrl;
import com.example.jingzehuang.propellerhealth.network.NetworkRequest;
import com.example.jingzehuang.propellerhealth.utils.DateUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.schedulers.Schedulers;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.recycler_view)RecyclerView recyclerView;
  @BindView(R.id.fab)FloatingActionButton fab;

  private LayoutManager layoutManager;
  private EventAdapter adapter;
  private List<Event> events;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);

  }

  @Override
  protected void onStart() {
    super.onStart();

    fab.setOnClickListener(this::fabAction);

    adapter = new EventAdapter(getBaseContext());
    recyclerView.setAdapter(adapter);
//    adapter.addAll(mockData());
    getBackendData();
  }

  public void getBackendData() {

    RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

    NetworkRequest retrofitInterface =  new Retrofit.Builder()
        .baseUrl(BaseUrl.BASE_URL)
        .addCallAdapterFactory(rxAdapter)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(NetworkRequest.class);

    Observer<InputData> inputDataObserver = new Observer<InputData>() {

      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable e) {

      }

      @Override
      public void onNext(InputData inputData) {
        events = inputData.getEvents();
        if (events != null) {
          adapter.addAll(events);
        }
      }

    };

    retrofitInterface.getDate()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(inputDataObserver);
  }

  private List<Event> mockData() {
    Event event = new Event(1, "proair", "rescue", "2015-01-01T11:32:00.000Z");
    return Arrays.asList(event, event);
  }

  private void fabAction(View v) {
    NewEventDialog dialog = NewEventDialog.newInstance(this::onNewEventAdd);
    dialog.show(getSupportFragmentManager(), NewEventDialog.TAG);
  }

  private void onNewEventAdd(String name, String type, Date date) {
    Event event = new Event(events.size() + 1, name, type, DateUtils.dateToString(date));
    events.add(event);
    adapter.addAll(events);
  }

}
