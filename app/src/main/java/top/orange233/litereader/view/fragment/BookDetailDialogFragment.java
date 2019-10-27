package top.orange233.litereader.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.orange233.litereader.R;
import top.orange233.litereader.bean.FuzzySearchResultBean;
import top.orange233.litereader.view.activity.ReadBookActivity;

public class BookDetailDialogFragment extends DialogFragment {

    @BindView(R.id.iv_background)
    ImageView ivBackground;
    @BindView(R.id.iv_book_wrapper)
    ImageView ivBookWrapper;
    @BindView(R.id.tv_book_title)
    TextView tvBookTitle;
    @BindView(R.id.tv_book_author)
    TextView tvBookAuthor;
    @BindView(R.id.tv_category)
    TextView tvCategory;
    @BindView(R.id.tv_last_chapter)
    TextView tvLastChapter;
    @BindView(R.id.rl_hold_book_info)
    RelativeLayout rlHoldBookInfo;
    @BindView(R.id.tv_short_intro)
    TextView tvShortIntro;
    @BindView(R.id.btn_add_to_shelf)
    Button btnAddToShelf;
    @BindView(R.id.btn_start_reading)
    Button btnStartReading;

    FuzzySearchResultBean.BooksBean mFuzzySearchResultBean;

    public BookDetailDialogFragment(FuzzySearchResultBean.BooksBean resultBean) {
        mFuzzySearchResultBean = resultBean;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Window window = getDialog().getWindow();
        View view = inflater.inflate(R.layout.fragment_dialog_book_detail, ((ViewGroup) window.findViewById(android.R.id.content)), false);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置宽高，单位：pixel
        window.setLayout(800, 960);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvBookTitle.setText(mFuzzySearchResultBean.getTitle());
        tvBookAuthor.setText("作者: " + mFuzzySearchResultBean.getAuthor());
        tvCategory.setText("分类: " + mFuzzySearchResultBean.getCat());
        tvLastChapter.setText("最新章节: " + mFuzzySearchResultBean.getLastChapter());
        tvShortIntro.setText(mFuzzySearchResultBean.getShortIntro());
    }

    @OnClick({R.id.btn_add_to_shelf, R.id.btn_start_reading})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add_to_shelf:
                // TODO
                break;
            case R.id.btn_start_reading:
                // TODO
                Intent intent=new Intent(getContext(), ReadBookActivity.class);
                getContext().startActivity(intent);
                break;
            default:
        }
    }
}
