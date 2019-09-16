package com.ray.pictureloader.datasource;

import com.ray.pictureloader.datasource.bean.LoadImageResponse;

import java.util.List;

import io.reactivex.Observable;

public interface MainDataSource {

    Observable<List<LoadImageResponse>> getPhotos();
}
