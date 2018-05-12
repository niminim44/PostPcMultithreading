package com.postpc.nimrod.postpcmultithreading.threading;

import android.os.Bundle;

import com.postpc.nimrod.postpcmultithreading.R;

class ThreadingPresenter implements ThreadingContract.Presenter{

    private final ThreadingContract.View view;
    private final Bundle extras;
    private int activityMode;
    private TimerAsyncTask asyncTask;

    ThreadingPresenter(ThreadingContract.View view, Bundle extras) {
        this.view = view;
        this.extras = extras;
    }

    @Override
    public void init() {
        this.activityMode = (extras != null) ?
                extras.getInt(ThreadingActivity.MODE, ThreadingActivity.ASYNC_MODE) :
                ThreadingActivity.ASYNC_MODE;
        view.setCurrentState(R.string.create_a_task);
        view.setTextViewBackgroundColor(R.color.white);
        setButtonsEnabled(true, false, false);
    }

    @Override
    public void destroy() {
        switch (activityMode){
            case ThreadingActivity.ASYNC_MODE:
                destroyAsyncTask();
                break;
            case ThreadingActivity.THREAD_MODE:
                destroyThreadTask();
        }
    }

    private void destroyThreadTask() {
        // TODO: 12/05/2018 implement this
    }

    private void destroyAsyncTask() {
        if(asyncTask != null){
            asyncTask.cancel(true);
            asyncTask = null;
        }
    }

    @Override
    public void handleButtonClicked(int buttonId) {
        switch (buttonId){
            case R.id.create_button:
                createTask();
                break;
            case R.id.start_button:
                startTask();
                break;
            case R.id.cancel_button:
                cancelTask();
                break;
        }
    }

    @Override
    public void updateProgress(Integer progress) {
        view.updateProgress(String.valueOf(progress));
    }

    @Override
    public void asyncTaskFinished() {
        asyncTask = null;
        view.setCurrentState(R.string.task_finished);
        view.setTextViewBackgroundColor(R.color.green);
        setButtonsEnabled(true, false, false);
    }

    private void cancelTask() {
        switch (activityMode){
            case ThreadingActivity.ASYNC_MODE:
                cancelAsyncTask();
                break;
            case ThreadingActivity.THREAD_MODE:
                // TODO: 12/05/2018 implement this
                break;
        }
    }

    private void cancelAsyncTask() {
        asyncTask.cancel(true);
        asyncTask = null;
        view.setCurrentState(R.string.task_canceled);
        view.setTextViewBackgroundColor(R.color.red);
        setButtonsEnabled(true, false, false);
    }

    private void startTask() {
        switch (activityMode){
            case ThreadingActivity.ASYNC_MODE:
                startAsyncTask();
                break;
            case ThreadingActivity.THREAD_MODE:
                // TODO: 12/05/2018 implement this
                break;
        }
    }

    private void startAsyncTask() {
        asyncTask.execute();
        view.setTextViewBackgroundColor(R.color.orange);
        setButtonsEnabled(false, false, true);
    }

    private void createTask() {
        switch (activityMode){
            case ThreadingActivity.ASYNC_MODE:
                createAsyncTask();
                break;
            case ThreadingActivity.THREAD_MODE:
                createThreadTask();
                break;
        }
    }

    private void createThreadTask() {
        // TODO: 12/05/2018 implement this
    }

    private void createAsyncTask() {
        this.asyncTask = new TimerAsyncTask(10, this);
        view.setCurrentState(R.string.async_task_created);
        view.setTextViewBackgroundColor(R.color.yellow);
        setButtonsEnabled(false, true, false);
    }

    private void setButtonsEnabled(boolean createButton, boolean startButton, boolean cancelButton){
        view.setCreateButtonEnabled(createButton);
        view.setStartButtonEnabled(startButton);
        view.setCancelButtonEnabled(cancelButton);
    }


}
