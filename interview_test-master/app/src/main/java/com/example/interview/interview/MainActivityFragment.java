package com.example.interview.interview;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interview.interview.adapters.PhotoAdapter;
import com.example.interview.interview.dependencyinjection.component.DaggerMainActivityFragmentComponent;
import com.example.interview.interview.dependencyinjection.module.LoadPhotoServiceModule;
import com.example.interview.interview.model.ImagePair;

import java.util.List;

import javax.inject.Inject;

//https://api.500px.com/v1/photos?feature=fresh_today&sort=created_at&image_size=4&include_store=store_download&include_states=voted&consumer_key=mSDECDmxoEEEw32OgaNxZxhUFuwiZetUaK9xTyTW

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainActivityFragmentContract.View {

    @Inject
    MainActivityFragmentContract.Presenter presenter;

    private RecyclerView mRecyclerView;
    private PhotoAdapter mAdapter;
    private StaggeredGridLayoutManager mLayoutManager;
    private boolean isLoadData = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectPresenter();
        presenter.takeView(this);
        if (savedInstanceState == null) {
            presenter.loadInitialList();
            isLoadData = true;
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

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mLayoutManager = getMLayoutManager();
        mAdapter = new PhotoAdapter(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnScrollListener(new MyOnScrollListener());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        presenter.loadInitialList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    //MainActivityFragmentContract.View
    @Override
    public void showAddData(List<ImagePair> data) {
        if (mAdapter != null) {
            mAdapter.replaceData(data);
        }
    }

    //Dagger2 setup
    private void injectPresenter() {
        DaggerMainActivityFragmentComponent
                .builder()
                .loadPhotoServiceModule(new LoadPhotoServiceModule())
                .build()
                .inject(this);
    }

    //
    private StaggeredGridLayoutManager getMLayoutManager() {
        StaggeredGridLayoutManager manager;
        Configuration config = getResources().getConfiguration();
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            manager = new StaggeredGridLayoutManager(2,
                    StaggeredGridLayoutManager.VERTICAL);
        } else {
            manager = new StaggeredGridLayoutManager(1,
                    StaggeredGridLayoutManager.VERTICAL);
        }
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        return  manager;
    }

    //
    private class MyOnScrollListener extends RecyclerView.OnScrollListener {

        public MyOnScrollListener() {
            super();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            mLayoutManager.invalidateSpanAssignments();
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    }
}


