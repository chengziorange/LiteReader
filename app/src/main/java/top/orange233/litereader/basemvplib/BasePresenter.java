package top.orange233.litereader.basemvplib;

/**
 * 抽象Presenter，由具体功能的Presenter继承
 * @param <T> 继承了IView的接口
 */
public abstract class BasePresenter<T extends IView> implements IPresenter<T> {
    protected T mView;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public boolean isViewAttached() {
        return (mView != null);
    }
}
