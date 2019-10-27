package top.orange233.litereader.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import top.orange233.litereader.view.fragment.HotspotFragment;
import top.orange233.litereader.view.fragment.ShelfFragment;

public class ShelfHotspotFragmenAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public ShelfHotspotFragmenAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        mFragments = new ArrayList<>();
        mFragments.add(new ShelfFragment());
        mFragments.add(new HotspotFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "我的书籍";
            case 1:
                return "发现";
            default:
                return super.getPageTitle(position);
        }
    }
}
