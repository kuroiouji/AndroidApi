package com.kamitoon.api.service;

import com.kamitoon.api.model.BudgetYearDao;
import com.kamitoon.api.model.ProjectDao;
import com.kamitoon.api.model.StatusDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("getBudgetYear")
    Call<List<BudgetYearDao>> getBudgetYear();

    @GET("getStatus")
    Call<List<StatusDao>> getStatus();

    @POST("getProjectByYear")
    Call<List<ProjectDao>> getProjectByYear();
}
