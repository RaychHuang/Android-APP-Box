package com.ray.pictureloader;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class DatabindingAdapter {

    @BindingAdapter(value = {"imageUrl"})
    public static void imageUrl(ImageView view, String url) {
        if (url == null) {
            return;
        }
        Glide.with(view.getContext()).load(url).into(view);
    }
}
