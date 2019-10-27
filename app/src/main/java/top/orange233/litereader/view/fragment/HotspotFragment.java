package top.orange233.litereader.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import top.orange233.litereader.R;
import top.orange233.litereader.basemvplib.BaseFragment;
import top.orange233.litereader.presenter.HotspotPresenter;
import top.orange233.litereader.presenter.contract.HotspotContract;

public class HotspotFragment extends BaseFragment<HotspotPresenter> implements HotspotContract.View {

    public HotspotFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotspot, container, false);
    }

    @Override
    protected void init(View view) {
    }

    @Override
    protected HotspotPresenter createPresenter() {
        return null;
    }
}
