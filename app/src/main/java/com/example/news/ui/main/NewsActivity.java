package com.example.news.ui.main;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.news.Adapters.NewsAdapter;
import com.example.news.Models.NewsModel;
import com.example.news.R;
import com.todkars.shimmer.ShimmerRecyclerView;

public class NewsActivity extends AppCompatActivity {

    private  final NewsAdapter newsAdapter = new NewsAdapter();
    private ShimmerRecyclerView shimmerRecyclerView;
    private MainActivityViewModel mainActivityViewModel ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_to_refresh);
        mainActivityViewModel = ViewModelProviders.of( this).get(MainActivityViewModel.class);
        shimmerRecyclerView = findViewById(R.id.recycler);
        shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        shimmerRecyclerView.showShimmer();
        mainActivityViewModel.getNews(getIntent().getStringExtra("category"));

        mainActivityViewModel.mutableLiveData.observe(this, new Observer<NewsModel>() {
            @Override
            public void onChanged(NewsModel s) {
                setData(s);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainActivityViewModel.getNews(getIntent().getStringExtra("category"));
            }
        });



}

public  void  setData(NewsModel S){
        newsAdapter.setList(S.getArticles());
        newsAdapter.notifyDataSetChanged();
        shimmerRecyclerView.setAdapter(newsAdapter);

        shimmerRecyclerView.hideShimmer();
        Log.e(this.getClass().getName()," ArrayList Add Successfully    ");
    }
}