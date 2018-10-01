package id.pastakangen.com.pastakangen.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import id.pastakangen.com.pastakangen.R;
import id.pastakangen.com.pastakangen.core.CoreActivity;
import id.pastakangen.com.pastakangen.core.CoreContract;
import id.pastakangen.com.pastakangen.main.element.MainFragment;
import id.pastakangen.com.pastakangen.splash.SplashActivity;

public class MainActivity extends CoreActivity implements MainContract.View {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    private NavigationView mNavigationView;
    private View mNavigationalHeader;

    private TextView mTvNotifCount;
    private MainPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, new MainFragment());
        ft.commit();


        mPresenter = new MainPresenter(this, this);
        mPresenter.init();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.getItemId() == R.id.menu_notification) {
                View view = item.getActionView();
                if (view != null) {
                    mTvNotifCount = view.findViewById(R.id.tv_count);
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override public void onClick(View view) {
                            startActivity(new Intent(MainActivity.this
                                    , SplashActivity.class));
                        }
                    });
                }
            }
        }
        return true;
    }


    @Override public void setActionbar(boolean showBack, int stringResource) {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.action_bar_logo, null);
        actionBar.setCustomView(v);

        if(actionBar != null) {
            mTvMenu.setText(stringResource);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable
                    .ic_menu));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}
