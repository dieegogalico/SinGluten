package com.checkfood.singluten.presentation.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.checkfood.singluten.R;
import com.checkfood.singluten.domain.model.GithubModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.galico on 14/09/2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<GithubModel> mItems;

    public CardAdapter() {
        super();
        mItems = new ArrayList<GithubModel>();
    }

    public void addData(GithubModel github) {
        mItems.add(github);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                               .inflate(R.layout.recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        GithubModel github = mItems.get(i);
        viewHolder.login.setText(github.getLogin());
        viewHolder.repos.setText("repos: " + github.getPublicRepos());
        viewHolder.blog.setText("blog: " + github.getBlog());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView login;
        public TextView repos;
        public TextView blog;

        public ViewHolder(View itemView) {
            super(itemView);
            login = (TextView) itemView.findViewById(R.id.login);
            repos = (TextView) itemView.findViewById(R.id.repos);
            blog = (TextView) itemView.findViewById(R.id.blog);
        }
    }
}