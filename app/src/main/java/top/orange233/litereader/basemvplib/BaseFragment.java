package top.orange233.litereader.basemvplib;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<T extends IPresenter> extends Fragment implements IView {

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        init();
    }

    @Override
    public void onDestroy() {
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
