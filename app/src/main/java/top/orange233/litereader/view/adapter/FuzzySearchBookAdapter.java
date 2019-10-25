package top.orange233.litereader.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.orange233.litereader.R;
import top.orange233.litereader.bean.FuzzySearchResultBean;

public class FuzzySearchBookAdapter extends RecyclerView.Adapter<FuzzySearchBookAdapter.FuzzySearchViewHolder> {
    private List<FuzzySearchResultBean.BooksBean> resultBeanList;

    static class FuzzySearchViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.tv_short_intro)
        TextView tvShortIntro;

        FuzzySearchViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public FuzzySearchBookAdapter() {
        this.resultBeanList = new ArrayList<>();
    }

    public void setResultBeanList(List<FuzzySearchResultBean.BooksBean> resultBeanList) {
        this.resultBeanList = resultBeanList;
    }

    @NonNull
    @Override
    public FuzzySearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item_fuzzy_search_book, parent, false);
        return new FuzzySearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuzzySearchViewHolder holder, int position) {
        FuzzySearchResultBean.BooksBean book = resultBeanList.get(position);
        holder.tvBookTitle.setText(book.getTitle());
        holder.tvBookAuthor.setText("作者: "+book.getAuthor());
        holder.tvCategory.setText("分类: "+book.getCat());
        holder.tvLastChapter.setText("最新章节: "+book.getLastChapter());
        holder.tvShortIntro.setText("内容概要: "+book.getShortIntro());
    }

    @Override
    public int getItemCount() {
        return resultBeanList.size();
    }
}
