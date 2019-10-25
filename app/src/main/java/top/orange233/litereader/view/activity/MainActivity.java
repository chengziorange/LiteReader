package top.orange233.litereader.view.activity;

import android.content.Intent;
import android.view.Menu;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.orange233.litereader.R;
import top.orange233.litereader.basemvplib.BaseActivity;
import top.orange233.litereader.presenter.MainPresenter;

public class MainActivity extends BaseActivity {

    @BindView(R.id.card_search)
    CardView cardSearch;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void init() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtil.setLightMode(this);

        setSupportActionBar(toolbar);

        initDrawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerToggle.syncState();
        drawerLayout.addDrawerListener(mDrawerToggle);
    }

    @OnClick(R.id.card_search)
    protected void startSearchBookActivity() {
        startActivityByAnim(new Intent(this, SearchBookActivity.class),
                toolbar, "sharedView", android.R.anim.fade_in, android.R.anim.fade_out);
    }


    @Override
    protected MainPresenter createPresenter() {
        return null;
    }
}
