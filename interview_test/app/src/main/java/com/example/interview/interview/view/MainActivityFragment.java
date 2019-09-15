package com.example.interview.interview.view;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interview.interview.R;
import com.example.interview.interview.dependencyinjection.component.DaggerFragmentComponent;
import com.example.interview.interview.dependencyinjection.module.LoadImageServiceModule;
import com.example.interview.interview.model.basic.ImageInfo;

import java.util.List;

import javax.inject.Inject;

//https://api.500px.com/v1/photos?feature=fresh_today&sort=created_at&image_size=4&include_store=store_download&include_states=voted&consumer_key=mSDECDmxoEEEw32OgaNxZxhUFuwiZetUaK9xTyTW

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements Contract.View {

    @Inject
    Contract.Presenter presenter;
    private RecyclerView mRecyclerView;
    private PhotoAdapter mAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    public MainActivityFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
        presenter.takeView(this);
        presenter.loadInitialData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = getMAdapter();
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mLayoutManager = getMLayoutManager();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnScrollListener(new MyOnScrollListener());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.dropView();
    }

    //MainContract.View
    @Override
    public void showAddedData(List<ImageInfo> data) {
        if (mAdapter != null) {
            mAdapter.addData(data);
        }
    }

    //Initiate Dagger2
    private void initDagger() {
        DaggerFragmentComponent.builder()
                .loadImageServiceModule(new LoadImageServiceModule())
                .build()
                .inject(this);
    }

    //Get PhotoAdapter
    private PhotoAdapter getMAdapter() {
        return new PhotoAdapter(getContext());
    }

    //Get StaggeredGridLayoutManager
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
        return manager;
    }

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


