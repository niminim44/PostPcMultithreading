package com.postpc.nimrod.postpcmultithreading.threading;

import android.os.AsyncTask;
import android.os.SystemClock;

public class TimerAsyncTask extends AsyncTask<Void, Integer, Integer> {


    private static final long ONE_SECOND = 1000;
    private static final int SUCCESS = 0;
    private int time;
    private final ThreadingContract.Presenter listener;

    TimerAsyncTask(int time, ThreadingContract.Presenter listener) {
        this.time = time;
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        while(time > 0 && !isCancelled()){
            publishProgress(time);
            SystemClock.sleep(ONE_SECOND);
            time--;
        }
        return SUCCESS;
    }

    @Override
    protected void onPostExecute(Integer statusCode) {
        super.onPostExecute(statusCode);
        listener.asyncTaskFinished();
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        listener.updateProgress(progress[0]);
    }
}
