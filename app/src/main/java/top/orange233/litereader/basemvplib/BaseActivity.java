package top.orange233.litereader.basemvplib;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        init();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    protected void initPresenter() {
        mPresenter = createPresenter();
        //绑定生命周期
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 创建一个Presenter
     */
    protected abstract T createPresenter();

    protected abstract void init();
}
