package com.ray.pictureloader.datasource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ray.pictureloader.datasource.bean.LoadImageResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class MainDataSourceImpl implements MainDataSource {

    @Override
    public Observable<List<LoadImageResponse>> getPhotos() {
        return Observable.create(new ObservableOnSubscribe<List<LoadImageResponse>>() {
            @Override
            public void subscribe(ObservableEmitter<List<LoadImageResponse>> e) {
                try (InputStream is = AssertLoader.getInstance().getGsonInputStream()) {
                    InputStreamReader isr = new InputStreamReader(is);
                    TypeToken<List<LoadImageResponse>> typeToken = new TypeToken<List<LoadImageResponse>>() {};
                    List<LoadImageResponse> photos = new Gson().fromJson(isr, typeToken.getType());
                    e.onNext(photos);
                    e.onComplete();
                } catch (IOException ex) {
                    e.onError(ex);
                }
            }
        });
    }
}
