package com.example.interview.interview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.interview.interview.R;
import com.example.interview.interview.model.ImagePair;
import com.example.interview.interview.model.ResponseItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private int baseWidth;
    private final Context context;
    private final List<ImagePair> mData;

    public PhotoAdapter(Context context) {
        this.context = context;
        mData = new ArrayList<>(40);
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
        ImagePair imagePair = mData.get(position);
        String url = imagePair.getUrl();

        int height = imagePair.getTargetHeight(baseWidth);
        if (baseWidth > 0) {
            ViewGroup.LayoutParams imageLayoutParams = holder.mImage.getLayoutParams();
            imageLayoutParams.width = baseWidth;
            imageLayoutParams.height = height;
            holder.mImage.setMinimumWidth(baseWidth);
            holder.mImage.setMinimumWidth(height);
            holder.mImage.setLayoutParams(imageLayoutParams);
        } else {
            int picWidth = holder.mImage.getWidth();
            if (picWidth > 0) {
                setBaseWidth(picWidth);
                ViewGroup.LayoutParams imageLayoutParams = holder.mImage.getLayoutParams();
                imageLayoutParams.width = picWidth;
                imageLayoutParams.height = imagePair.getTargetHeight(picWidth);
                holder.mImage.setLayoutParams(imageLayoutParams);
            } else {
                holder.mImage.setMinimumWidth(0);
                holder.mImage.setMinimumHeight(0);
            }
        }

        if (baseWidth > 0) {
            Picasso.with(context)
                    .load(url)
                    .resize(baseWidth, height)
                    .onlyScaleDown()
                    .into(holder.mImage);
        } else {
            Picasso.with(context)
                    .load(url)
                    .into(holder.mImage);
        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public void addData(@NonNull List<ImagePair> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void replaceData(@NonNull List<ImagePair> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    private void setBaseWidth(int width) {
        if (baseWidth > 0) {
            return;
        }
        baseWidth = width;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.childImage)ImageView mImage;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
