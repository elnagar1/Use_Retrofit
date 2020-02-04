package com.example.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.news.Models.NewsModel;
import com.example.news.R;
import com.example.news.ui.main.DetailActivity;
import com.example.news.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsModel.ArticlesEntity> articlesList = new ArrayList<>();
    private Context context;


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     this.context =parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newscard, parent, false);
            return new NewsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsModel.ArticlesEntity articlesEntity = articlesList.get(position);

        holder.title.setText(articlesEntity.getTitle());
        holder.time.setText(articlesEntity.getPublishedAt().replace("T","  "));
        holder.details.setText(articlesEntity.getDescription());
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }


  public void setList(List<NewsModel.ArticlesEntity> articles) {

        this.articlesList = articles;
        notifyDataSetChanged();
        Log.e(this.getClass().getName(), " ArrayList Add Successfully");
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView time,title,details;

        private NewsViewHolder(View view) {
            super(view);
            time= view.findViewById(R.id.news_time);
            title= view.findViewById(R.id.news_title);
            details = view.findViewById(R.id.news_details);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(Utils.Json_description, articlesList.get(getAdapterPosition()).getDescription());
                    intent.putExtra(Utils.Json_author, articlesList.get(getAdapterPosition()).getAuthor());
                    intent.putExtra(Utils.Json_title, articlesList.get(getAdapterPosition()).getTitle());
                    intent.putExtra(Utils.Json_fullNewUrl, articlesList.get(getAdapterPosition()).getUrl());
                    intent.putExtra(Utils.Json_imgUrl, articlesList.get(getAdapterPosition()).getUrlToImage());
                     context.startActivity(intent);
                }
            });
        }

    }


}
