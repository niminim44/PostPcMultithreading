package com.postpc.nimrod.postpcmultithreading.threading;

public interface ThreadingContract {

    interface View{

        void updateProgress(String progress);

        void setCurrentState(int stringResourceId);

        void setTextViewBackgroundColor(int colorResourceId);

        void setCreateButtonEnabled(boolean enabled);

        void setStartButtonEnabled(boolean enabled);

        void setCancelButtonEnabled(boolean enabled);
    }

    interface Presenter{

        void init();

        void destroy();

        void handleButtonClicked(int buttonId);

        void updateProgress(Integer progress);

        void asyncTaskFinished();
    }

}
