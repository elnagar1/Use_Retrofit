package com.example.news.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.news.Models.NewsModel;
import com.example.news.WebServices.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivityViewModel extends ViewModel {


    MutableLiveData<NewsModel> mutableLiveData = new MutableLiveData<>();


    public void getNews(String category) {

        WebService.getInstance().getPO( category).enqueue(new Callback<NewsModel>() {

            @Override


            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                mutableLiveData.setValue(response.body());
                Log.e("LiveData", "Set Successfully");
            }


            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Log.e("Erorr  ", t.getMessage() + "  " + call.toString());
            }
        });
    }

}

