package com.example.interview.interview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
        String url = mData.get(position).getUrl();
        Picasso.with(context)
                .load(url)
                .fit()
                .into(holder.mImage);
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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.childImage)ImageView mImage;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
