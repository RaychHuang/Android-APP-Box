package com.example.jingzehuang.dagger2test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_getName_btn)
    Button getNameBtn;
    @BindView(R.id.main_name_tv)
    TextView nameTv;

    @Inject
    Person person;

    @Inject
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        inject();
    }

    private void inject() {
//        DaggerActivityComponent
//                .builder()
//                .activityModule(new ActivityModule())
//                .appComponent(AppComponentHolder.getAppComponent())
//                .build()
//                .inject(this);
    }

}
