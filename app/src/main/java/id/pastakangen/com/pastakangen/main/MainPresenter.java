package id.pastakangen.com.pastakangen.main;

import android.content.Context;

import id.pastakangen.com.pastakangen.R;

/**
 * Created by rifky on 30/09/18.
 */

public class MainPresenter implements  MainContract.Presenter{
    private MainContract.View mView;
    private Context mContext;

    public  MainPresenter (MainContract.View view, Context context) {
        mView = view;
        mContext = context;
    }

    @Override
    public void init() {
        mView.setActionbar(false, "");
    }
}
