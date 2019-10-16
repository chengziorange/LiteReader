package top.orange233.litereader.basemvplib;

/**
 * 公共接口，生命周期适配
 */
public interface IPresenter<T extends IView> {

    void attachView(T view);

    void detachView();

    boolean isViewAttached();
}
