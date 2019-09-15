package com.example.interview.interview.view;

import com.example.interview.interview.model.basic.ImageInfo;
import com.example.interview.interview.model.basic.LoadImageResponse;
import com.example.interview.interview.model.network.LoadImageService;
import com.example.interview.interview.model.network.NetworkConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Raych on Oct.31, 18.
 */

public class MainPresenter implements Contract.Presenter {

    private final LoadImageService service;
    private CompositeDisposable disposable;
    private Contract.View view;

    public MainPresenter(LoadImageService service) {
        this.service = service;
    }

    @Override
    public void takeView(Contract.View view) {
        this.view = view;
        this.disposable = new CompositeDisposable();
    }

    @Override
    public void dropView() {
        if (disposable != null) {
            this.disposable.dispose();
            this.disposable = null;
        }
        this.view = null;
    }

    /**
     * Load the network the list of images.
     * If succeed, parse List<LoadImageResponse> into List<ImageInfo>.
     */
    @Override
    public void loadInitialData() {
        service.loadImage(NetworkConfig.CLIENT_ID)
                .map((Function<List<LoadImageResponse>, List<ImageInfo>>) responses -> {
                    if (responses == null) {
                        return Collections.emptyList();
                    }
                    List<ImageInfo> res = new ArrayList<>(responses.size());
                    for (int i = 0, size = responses.size(); i < size; i++) {
                        res.add(new ImageInfo(responses.get(i)));
                    }
                    return res;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ImageInfo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<ImageInfo> imageInfos) {
                        onLoadImageSuccess(imageInfos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onLoadImageError(e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    //Handle Network Callback
    private void onLoadImageSuccess(List<ImageInfo> newData) {
        view.showAddedData(newData);
    }

    private void onLoadImageError(Throwable e) {
    }
}
