package com.postpc.nimrod.postpcmultithreading.threading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.postpc.nimrod.postpcmultithreading.R;

import butterknife.ButterKnife;

public class ThreadingActivity extends AppCompatActivity {

    public static final int ASYNC_MODE = 1;
    public static final int THREAD_MODE = 2;
    public static final String MODE = "mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threading);
        ButterKnife.bind(this);
    }
}
