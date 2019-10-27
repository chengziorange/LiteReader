package top.orange233.litereader.presenter.contract;

import top.orange233.litereader.basemvplib.IView;

public interface ShelfContract {

    interface View extends IView {

        void updateShelf();
    }

    interface Presenter {

        void addToShelf();
    }
}
