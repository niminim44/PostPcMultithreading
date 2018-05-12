package com.postpc.nimrod.postpcmultithreading;

import static com.postpc.nimrod.postpcmultithreading.threading.ThreadingActivity.ASYNC_MODE;
import static com.postpc.nimrod.postpcmultithreading.threading.ThreadingActivity.THREAD_MODE;

class MainPresenter implements MainContract.Presenter{

    private final MainContract.View view;

    MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void handleButtonClick(int buttonId) {
        switch (buttonId){
            case R.id.async_task_button:
                view.startThreadingActivity(ASYNC_MODE);
                break;
            case R.id.threads_button:
                view.startThreadingActivity(THREAD_MODE);
                break;
        }
    }

}
