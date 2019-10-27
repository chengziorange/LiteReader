package top.orange233.litereader.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.orange233.litereader.R;
import top.orange233.litereader.bean.ShelfBookBean;

public class ShelfBookRecyclerAdapter extends RecyclerView.Adapter<ShelfBookRecyclerAdapter.ShelfBookViewHolder> {

    List<ShelfBookBean> mShelfBookBean;

    static class ShelfBookViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_book_wrapper)
        ImageView ivBookWrapper;
        @BindView(R.id.tv_book_title)
        TextView tvBookTitle;
        @BindView(R.id.tv_book_author)
        TextView tvBookAuthor;
        @BindView(R.id.tv_read_progress)
        TextView tvReadProgress;
        @BindView(R.id.tv_last_chapter)
        TextView tvLastChapter;

        View shelfBookView;

        public ShelfBookViewHolder(@NonNull View itemView) {
            super(itemView);
            shelfBookView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    public ShelfBookRecyclerAdapter() {
        if (!LitePal.isExist(ShelfBookBean.class)) {
            mShelfBookBean = new ArrayList<>();
        } else {
            // TODO
        }
    }

    @NonNull
    @Override
    public ShelfBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item_shelf_book, parent, false);
        return new ShelfBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShelfBookViewHolder holder, int position) {
        ShelfBookBean bookBean = mShelfBookBean.get(position);
        holder.tvBookTitle.setText(bookBean.getTitle());
        holder.tvBookAuthor.setText(bookBean.getAuthor());
        holder.tvReadProgress.setText(bookBean.getReadChapter());
        holder.tvLastChapter.setText(bookBean.getLatestChapter());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
