package com.ray.pictureloader;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ray.pictureloader.databinding.ItemPictureBinding;
import com.ray.pictureloader.datasource.bean.ImageInfo;

import java.util.Collections;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<ImageInfo> mData = Collections.emptyList();

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPictureBinding binding = ItemPictureBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ImageInfo info = mData.get(position);
        holder.mBinding.setImageUrl(info.getUrl());
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull MainViewHolder holder) {
        holder.onViewAttachedToWindow();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MainViewHolder holder) {
        holder.onViewDetachedFromWindow();
    }

    public void replacePhotos(List<ImageInfo> photos) {
        if (photos != null) {
            this.mData = photos;
            this.notifyDataSetChanged();
        }
    }

    class MainViewHolder extends RecyclerView.ViewHolder implements LifecycleOwner {

        private final LifecycleRegistry mLifecycle;
        private ItemPictureBinding mBinding;

        MainViewHolder(@NonNull ItemPictureBinding binding) {
            super(binding.getRoot());
            this.mLifecycle = new LifecycleRegistry(this);
            this.mBinding = binding;
            this.mBinding.setLifecycleOwner(this);
        }

        @NonNull
        @Override
        public Lifecycle getLifecycle() {
            return mLifecycle;
        }

        void onViewAttachedToWindow() {
            mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }

        void onViewDetachedFromWindow() {
            mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
    }
}
