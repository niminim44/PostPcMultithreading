package com.postpc.nimrod.postpcmultithreading;

public interface MainContract {

    interface View{

        void startThreadingActivity(int activityMode);
    }

    interface Presenter{

        void handleButtonClick(int buttonId);
    }

}
