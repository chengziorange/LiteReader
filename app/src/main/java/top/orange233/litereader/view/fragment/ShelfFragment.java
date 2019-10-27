package top.orange233.litereader.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import top.orange233.litereader.R;
import top.orange233.litereader.basemvplib.BaseFragment;
import top.orange233.litereader.presenter.ShelfPresenter;
import top.orange233.litereader.presenter.contract.ShelfContract;

public class ShelfFragment extends BaseFragment<ShelfPresenter> implements ShelfContract.View {

    public ShelfFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shelf, container, false);
    }

    @Override
    protected void init(View view) {
        // TODO
    }

    @Override
    protected ShelfPresenter createPresenter() {
        return null;
    }


    @Override
    public void updateShelf() {
        // TODO
    }
}
