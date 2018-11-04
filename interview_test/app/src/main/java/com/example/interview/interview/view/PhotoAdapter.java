package com.example.interview.interview.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.interview.interview.R;
import com.example.interview.interview.model.basic.ImageInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {


    private final Context context;
    private final List<ImageInfo> mData;
    private int baseWidth = 0;

    public PhotoAdapter(Context context) {
        this.context = context;
        mData = new ArrayList<>(20);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {// create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_photo, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.i("Ray", "onBindViewHolder.");
        ImageInfo info = mData.get(position);

        int height = info.getTargetHeight(baseWidth);
        if (baseWidth > 0) {
            ViewGroup.LayoutParams imageLayoutParams = holder.mImageView.getLayoutParams();
            imageLayoutParams.width = baseWidth;
            imageLayoutParams.height = height;
            holder.mImageView.setMinimumWidth(baseWidth);
            holder.mImageView.setMinimumWidth(height);
            holder.mImageView.setLayoutParams(imageLayoutParams);
        } else {
            int picWidth = holder.mImageView.getWidth();
            if (picWidth > 0) {
                setBaseWidth(picWidth);
                ViewGroup.LayoutParams imageLayoutParams = holder.mImageView.getLayoutParams();
                imageLayoutParams.width = picWidth;
                imageLayoutParams.height = info.getTargetHeight(picWidth);
                holder.mImageView.setLayoutParams(imageLayoutParams);
            } else {
                holder.mImageView.setMinimumWidth(0);
                holder.mImageView.setMinimumHeight(0);
            }
        }

        if (baseWidth > 0) {
            Picasso.get()
                    .load(info.getUrl())
                    .resize(baseWidth, height)
                    .onlyScaleDown()
                    .into(holder.mImageView);
        } else {
            Picasso.get()
                    .load(info.getUrl())
                    .into(holder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void AddData(List<ImageInfo> newData) {
        if (newData != null) {
            mData.addAll(newData);
            notifyDataSetChanged();
            Log.i("Ray", "DataChanged.");
        } else {
            Log.i("Ray", "newData is null.");
        }
    }

    private void setBaseWidth(int width) {
        if (baseWidth > 0) {
            return;
        }
        baseWidth = width > 0 ? width : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v;
        }
    }
}
