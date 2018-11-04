package com.example.interview.interview.view;

import com.example.interview.interview.model.basic.ImageInfo;

import java.util.List;

/**
 * Created by Raych on Oct.31, 18.
 */

public interface Contract {

    interface View {

        /**
         * Get callback by the Presenter with data List<ImageInfo>.
         * @param data
         */
        void showAddedData(List<ImageInfo> data);
    }

    interface Presenter {

        /**
         * Called by View, to pass the instance of the Contract.View into Presenter.
         * @param view Instance of Contract.View
         */
        void takeView(View view);

        /**
         * Called by View, to Release the instance of View and do resource recycling.
         */
        void dropView();

        void loadInitialData();
    }

}
