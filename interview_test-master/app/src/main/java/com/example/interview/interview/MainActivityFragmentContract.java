package com.example.interview.interview;

import com.example.interview.interview.model.ImagePair;

import java.util.List;

public interface MainActivityFragmentContract {

    interface View {
        
        void showAddData(List<ImagePair> data);
    }

    interface Presenter {

        void takeView(View view);

        void dropView();

        void loadInitialList();
    }
}
