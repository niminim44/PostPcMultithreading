package com.postpc.nimrod.postpcmultithreading.threading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.postpc.nimrod.postpcmultithreading.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThreadingActivity extends AppCompatActivity implements ThreadingContract.View{

    public static final int ASYNC_MODE = 1;
    public static final int THREAD_MODE = 2;
    public static final String MODE = "mode";

    private ThreadingContract.Presenter presenter;

    @BindView(R.id.info_text_view)
    TextView infoTextView;

    @BindView(R.id.create_button)
    Button createButton;

    @BindView(R.id.start_button)
    Button startButton;

    @BindView(R.id.cancel_button)
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threading);
        ButterKnife.bind(this);
        presenter = new ThreadingPresenter(this, getIntent().getExtras());
        presenter.init();
    }

    @Override
    public void onBackPressed() {
        presenter.destroy();
        finish();
    }

    @OnClick({R.id.create_button, R.id.start_button, R.id.cancel_button})
    public void onButtonClicked(View view){
        presenter.handleButtonClicked(view.getId());
    }

    @Override
    public void updateProgress(String progress) {
        infoTextView.setText(progress);
    }

    @Override
    public void setCurrentState(int stringResourceId) {
        infoTextView.setText(getResources().getString(stringResourceId));
    }

    @Override
    public void setTextViewBackgroundColor(int colorResourceId) {
        infoTextView.setBackgroundColor(getResources().getColor(colorResourceId));
    }

    @Override
    public void setCreateButtonEnabled(boolean enabled) {
        createButton.setEnabled(enabled);
    }

    @Override
    public void setStartButtonEnabled(boolean enabled) {
        startButton.setEnabled(enabled);
    }

    @Override
    public void setCancelButtonEnabled(boolean enabled) {
        cancelButton.setEnabled(enabled);
    }
}
