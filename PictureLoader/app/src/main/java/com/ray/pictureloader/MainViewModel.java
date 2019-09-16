package com.ray.pictureloader;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ray.pictureloader.datasource.MainDataSource;
import com.ray.pictureloader.datasource.MainDataSourceImpl;
import com.ray.pictureloader.datasource.bean.ImageInfo;
import com.ray.pictureloader.datasource.bean.LoadImageResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private MainDataSource mDataSource = new MainDataSourceImpl();
    private CompositeDisposable mDisposable;

    private MutableLiveData<List<ImageInfo>> mPhotos = new MutableLiveData<>();

    public LiveData<List<ImageInfo>> getPhotos() {
        return mPhotos;
    }

    public void onStart() {
        mDisposable = new CompositeDisposable();
        mDataSource.getPhotos()
                .map(new Function<List<LoadImageResponse>, List<ImageInfo>>() {
                    @Override
                    public List<ImageInfo> apply(List<LoadImageResponse> responses) {
                        if (responses == null) {
                            return Collections.emptyList();
                        }
                        List<ImageInfo> res = new ArrayList<>(responses.size());
                        for (int i = 0, size = responses.size(); i < size; i++) {
                            res.add(new ImageInfo(responses.get(i)));
                        }
                        return res;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ImageInfo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(List<ImageInfo> imageInfos) {
                        mPhotos.setValue(imageInfos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void onStop() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
            mDisposable = null;
        }
    }
}
