package com.example.interview.interview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interview.interview.adapters.PhotoAdapter;
import com.example.interview.interview.model.ImagePair;

import java.util.List;

import javax.inject.Inject;

//https://api.500px.com/v1/photos?feature=fresh_today&sort=created_at&image_size=4&include_store=store_download&include_states=voted&consumer_key=mSDECDmxoEEEw32OgaNxZxhUFuwiZetUaK9xTyTW

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainActivityFragmentContract.View {

    @Inject
    MainActivityFragmentPresenter presenter;

    private RecyclerView mRecyclerView;
    private PhotoAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectPresenter();
        presenter.takeView(this);
        if (savedInstanceState == null) {
            presenter.loadData();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new PhotoAdapter(getContext());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    //MainActivityFragmentContract.View
    @Override
    public void showAddData(List<ImagePair> data) {
        mAdapter.replaceData(data);
    }

    @Override
    public void noMoreData() {

    }

    @Override
    public void netWorkError() {

    }

    //Dagger2 setup
    private void injectPresenter() {
//        DaggerMainActivityFragmentComponent
//                .builder()
//                .build()
//                .inject(this);
    }
}


