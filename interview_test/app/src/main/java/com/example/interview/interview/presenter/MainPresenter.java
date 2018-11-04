package com.example.interview.interview.presenter;

import android.util.Log;

import com.example.interview.interview.model.basic.ImageInfo;
import com.example.interview.interview.model.basic.LoadImageResponse;
import com.example.interview.interview.model.network.LoadImageService;
import com.example.interview.interview.model.network.NetworkConfig;
import com.example.interview.interview.view.Contract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Raych on Oct.31, 18.
 */

public class MainPresenter implements Contract.Presenter {

    @Inject
    LoadImageService service;
    private Contract.View view;
    private CompositeDisposable disposable;

    @Inject
    public MainPresenter() {
        disposable = new CompositeDisposable();
    }

    @Override
    public void takeView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        if (disposable != null) {
            disposable.dispose();
        }
        this.view = null;
    }

    /**
     * Load the network the list of images.
     * If succeed, parse List<LoadImageResponse> into List<ImageInfo>.
     */
    @Override
    public void loadInitialData() {
        disposable.add (
                service.loadImage(NetworkConfig.CLIENT_ID)
                        .map(new Function<List<LoadImageResponse>, List<ImageInfo>>() {
                            @Override
                            public List<ImageInfo> apply(List<LoadImageResponse> responses) throws Exception {
                                if (responses == null) {
                                    return null;
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
                        .subscribe(this::onLoadImageSuccess, this::onLoadImageError));

    }

    //Handle Network Callback
    private void onLoadImageSuccess(List<ImageInfo> newData) {
        Log.i("Raych", "Load Image succeeded.");
        Log.i("Raych", "The list size: " + newData.size());
        view.showAddedData(newData);
    }

    private void onLoadImageError(Throwable e) {
        Log.e("Raych", "Load Image failed.");
    }
}
