package top.orange233.litereader.view.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexboxLayout;
import com.jaeger.library.StatusBarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.orange233.litereader.R;
import top.orange233.litereader.basemvplib.BaseActivity;
import top.orange233.litereader.bean.FuzzySearchResultBean;
import top.orange233.litereader.bean.SearchHistoryBean;
import top.orange233.litereader.presenter.SearchBookPresenter;
import top.orange233.litereader.presenter.contract.SearchBookContract;
import top.orange233.litereader.util.Callback;
import top.orange233.litereader.view.adapter.FuzzySearchBookRecyclerAdapter;
import top.orange233.litereader.view.fragment.BookDetailDialogFragment;
import tyrantgit.explosionfield.ExplosionField;

public class SearchBookActivity extends BaseActivity<SearchBookPresenter> implements SearchBookContract.View {

    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.rv_search_result)
    RecyclerView recyclerView;
    @BindView(R.id.flex_box_search_history)
    FlexboxLayout flexBoxSearchHistory;
    @BindView(R.id.rl_search_history)
    RelativeLayout rlSearchHistory;
    @BindView(R.id.tv_clear_history)
    TextView tvClearHistory;

    FuzzySearchBookRecyclerAdapter rvAdapter;
    ExplosionField mExplosionField;

    // 创建 Activity 时的初始化
    @Override
    protected void init() {
        setContentView(R.layout.activity_search_book);
        ButterKnife.bind(this);
        StatusBarUtil.setLightMode(this);
        mExplosionField = ExplosionField.attach2Window(this);

        initSearchView();
        initRecyclerView();
    }

    @Override
    protected SearchBookPresenter createPresenter() {
        return new SearchBookPresenter();
    }

    // P 回调显示搜索结果
    @Override
    public void showFuzzySearchResult(List<FuzzySearchResultBean.BooksBean> list) {
        rvAdapter.setResultBeanList(list);
        rvAdapter.notifyDataSetChanged();
    }

    // P 回调更新搜索历史
    @Override
    public void updateSearchHistory(List<SearchHistoryBean> list) {
        flexBoxSearchHistory.removeAllViews();
        TextView tagView;
        if (!list.isEmpty()) {
            tvClearHistory.setVisibility(View.VISIBLE);
            for (SearchHistoryBean shb : list) {
                tagView = (TextView) getLayoutInflater().inflate(R.layout.flex_item_search_history, flexBoxSearchHistory, false);
                tagView.setTag(shb);
                tagView.setText(shb.getContent());

                // 监听短按搜索
                tagView.setOnClickListener(view -> {
                    rlSearchHistory.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    mPresenter.fuzzySearchBook(shb.getContent(), 1, 20);
                    searchView.clearFocus();
                    mPresenter.getSearchHistory();
                });
                // 监听长按删除
                tagView.setOnLongClickListener(view -> {
                    shb.delete();
                    mExplosionField.explode(view);
                    mPresenter.getSearchHistory();
                    return true;
                });

                flexBoxSearchHistory.addView(tagView);
            }
        } else {
            tvClearHistory.setVisibility(View.INVISIBLE);
        }
    }

    // P 回调清除搜索历史
    @Override
    public void cleanSearchHistory() {
        mExplosionField.explode(tvClearHistory);
        tvClearHistory.setVisibility(View.GONE);
        mExplosionField.explode(flexBoxSearchHistory);
        flexBoxSearchHistory.setVisibility(View.GONE);
    }

    // 转场动画
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, android.R.anim.fade_out);
    }

    // 初始化搜索栏
    private void initSearchView() {
        searchView.setQueryHint("搜索书名、作者");
        searchView.setSubmitButtonEnabled(true);
        searchView.onActionViewExpanded();
        mPresenter.getSearchHistory();

        // 监听搜索事件
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.isEmpty()) {
                    return false;
                } else {
                    rlSearchHistory.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    mPresenter.fuzzySearchBook(query.trim(), 1, 20);
                    searchView.clearFocus();
                    mPresenter.getSearchHistory();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        // 监听焦点改变
        searchView.setOnQueryTextFocusChangeListener((view, hasFocus) -> {
            // 从搜索结果页点击搜索栏，显示搜索历史
            if (hasFocus) {
                mPresenter.getSearchHistory();
                recyclerView.setVisibility(View.GONE);
                rlSearchHistory.setVisibility(View.VISIBLE);
            }
        });

        // 监听清除按钮
        tvClearHistory.setOnClickListener(view -> {
            mPresenter.cleanSearchHistory();
        });
    }

    // 初始化 RecyclerView
    private void initRecyclerView() {
        rvAdapter = new FuzzySearchBookRecyclerAdapter(new Callback<View, Boolean>() {
            @Override
            public void onSuccess(View data) {
                new BookDetailDialogFragment((FuzzySearchResultBean.BooksBean)data.getTag()).show(getSupportFragmentManager(),"BookDetail");
            }

            @Override
            public void onFail(Boolean data) {

            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(this);
        DividerItemDecoration did = new DividerItemDecoration(recyclerView.getContext(), llm.getOrientation());
        recyclerView.addItemDecoration(did);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(rvAdapter);
    }
}


