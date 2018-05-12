package com.postpc.nimrod.postpcmultithreading;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.postpc.nimrod.postpcmultithreading.threading.ThreadingActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View{


    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
    }

    @Override
    public void startThreadingActivity(int activityMode) {
        Intent intent = new Intent(this, ThreadingActivity.class);
        intent.putExtra(ThreadingActivity.MODE, activityMode);
        startActivity(intent);
    }

    @OnClick({R.id.async_task_button, R.id.threads_button})
    public void onButtonClicked(View view){
        presenter.handleButtonClick(view.getId());
    }
}
