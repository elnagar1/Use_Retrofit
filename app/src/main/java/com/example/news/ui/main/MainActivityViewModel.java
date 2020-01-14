package com.example.news.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.news.Data.WebService;
import com.example.news.Models.NewsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivityViewModel extends ViewModel {


     MutableLiveData<String> mutableLiveData = new MutableLiveData<>();




    public void  getNews(){

       WebService.getInstance().getPO().enqueue(new Callback<NewsModel>() {

            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                Log.e("ssssssssssssssss3", "successfully");


                    mutableLiveData.setValue(response.body().getArticles().get(0).getTitle());


            }


            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Log.e("xxxxxxxxxxxxxx", t.getMessage()+call.toString());
            }
        });
    }

}

