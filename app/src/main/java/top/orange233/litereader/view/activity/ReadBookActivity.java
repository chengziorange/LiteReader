package top.orange233.litereader.view.activity;

import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;
import top.orange233.litereader.R;
import top.orange233.litereader.basemvplib.BaseActivity;
import top.orange233.litereader.presenter.ReadBookPresenter;
import top.orange233.litereader.presenter.contract.ReadBookContract;

public class ReadBookActivity extends BaseActivity<ReadBookPresenter> implements ReadBookContract.View {

    @Override
    protected void init() {
        setContentView(R.layout.activity_read_book);
        ButterKnife.bind(this);
        StatusBarUtil.setLightMode(this);
    }

    @Override
    protected ReadBookPresenter createPresenter() {
        return null;
    }

}
