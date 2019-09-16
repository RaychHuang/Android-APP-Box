package com.ray.pictureloader;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ray.pictureloader.databinding.FragmentMainBinding;
import com.ray.pictureloader.datasource.bean.ImageInfo;

import java.util.List;

public class MainFragment extends Fragment {

    private FragmentMainBinding mBinding;
    private MainAdapter mAdapter;
    private MainViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mAdapter = new MainAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentMainBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mBinding.setLifecycleOwner(this);
        mBinding.recyclerView.setAdapter(mAdapter);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mViewModel.getPhotos().observe(this, new Observer<List<ImageInfo>>() {
            @Override
            public void onChanged(List<ImageInfo> photos) {
                mAdapter.replacePhotos(photos);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        mViewModel.onStop();
    }
}
