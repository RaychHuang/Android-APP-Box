package com.example.interview.interview;

import com.example.interview.interview.model.ImagePair;
import com.example.interview.interview.network.LoadPhotoService;

import java.util.List;

import javax.inject.Inject;


public class MainActivityFragmentPresenter implements MainActivityFragmentContract.Presenter {

    @Inject
    LoadPhotoService service;

    private int pageNum;
    private boolean noMoreData;
    private boolean loading;
    private MainActivityFragmentContract.View view;


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
    public void loadData() {
        if (noMoreData) {

        }
//        service.loadPhotos(NetworkConfig.CLIENT_ID)
    }

    private void loadDataSucceed(List<ImagePair> data) {
        if (data != null) {
            if (data.size() == 0) {
                noMoreData = true;
            } else {
                pageNum++;
                noMoreData = false;
                view.showAddData(data);
            }
        }
    }

    private void loadDataError() {

    }

    private MainActivityFragmentContract.View getView() {
        return this.view;
    }
}
