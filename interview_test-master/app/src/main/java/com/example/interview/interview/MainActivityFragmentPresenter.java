package com.example.interview.interview;

import android.util.Log;

import com.example.interview.interview.model.ImagePair;
import com.example.interview.interview.model.ResponseItem;
import com.example.interview.interview.network.LoadPhotoService;
import com.example.interview.interview.network.NetworkConfig;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class MainActivityFragmentPresenter implements MainActivityFragmentContract.Presenter {

    @Inject
    LoadPhotoService service;

    private int pageNum;
    private boolean noMoreData;
    private boolean loading;
    private MainActivityFragmentContract.View view;
    private List<ImagePair> localData;

    @Inject
    public MainActivityFragmentPresenter() {
        this.pageNum = 0;
        this.noMoreData = false;
        this.loading = false;
    }

    //MainActivityFragmentContract.Presenter
    @Override
    public void takeView(MainActivityFragmentContract.View view) {
        this.view = view;
        this.pageNum = 0;
    }

    @Override
    public void dropView() {
        this.view = null;
    }

    @Override
    public void loadInitialList() {
        if (localData != null) {
            getView().showAddData(localData);
        } else {
            loadData();
        }
    }

    private void loadData() {
        Log.i("Raych", "MainActivityFragmentPresenter.loadData(): is called.");
        //service.loadPhotos(NetworkConfig.CLIENT_ID)
        if (service == null) {
            Log.i("Raych", "MainActivityFragmentPresenter.loadData(): service is null.");
            return;
        }
        Log.i("Raych", "MainActivityFragmentPresenter.loadData(): is going to load image");
        service.loadPhotos(NetworkConfig.CLIENT_ID)
                .map(new Func1<List<ResponseItem>, List<ImagePair>>() {
                    @Override
                    public List<ImagePair> call(List<ResponseItem> responseItems) {
                        if (responseItems == null) {
                            return null;
                        }
                        List<ImagePair> res = new ArrayList<>(responseItems.size());
                        for (int i = 0, iSize = responseItems.size(); i < iSize; i++) {
                            ResponseItem item = responseItems.get(i);
//                            res.add(new ImagePair(item.id, item.urls.regular));
                            res.add(new ImagePair(item.id, item.urls.regular, item.width, item.height));
                        }
                        return res;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::loadDataSucceed, this::loadDataError);
    }

    //LoadPhoto CallBack Functions
    private void loadDataSucceed(List<ImagePair> data) {
        Log.i("Raych", "MainActivityFragmentPresenter.loadDataSucceed() is called.");
        if (data != null) {
            if (data.size() == 0) {
                noMoreData = true;
            } else {
                pageNum++;
                noMoreData = false;
                if (getView() != null) {;
                    localData = data;
                    getView().showAddData(data);
                }
            }
        }
    }

    private void loadDataError(Throwable e) {
        Log.i("Raych", "MainActivityFragmentPresenter.loadDataError() is called.");
    }

    private MainActivityFragmentContract.View getView() {
        return this.view;
    }
}
