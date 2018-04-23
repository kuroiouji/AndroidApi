package com.kamitoon.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kamitoon.api.adapter.RvStatusAdapter;
import com.kamitoon.api.model.ProjectDao;
import com.kamitoon.api.model.StatusDao;
import com.kamitoon.api.service.HttpManager;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<StatusDao> status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview_list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        getSt();
        service();
    }

    public void service() {
        Call<List<ProjectDao>> call = HttpManager.getInstance().getService().getProjectByYear(5);
        Log.d("service", "GG ");
        call.enqueue(new Callback<List<ProjectDao>>() {
            @Override
            public void onResponse(Call<List<ProjectDao>> call, Response<List<ProjectDao>> response) {
                if (response.isSuccessful()) {
                    List<ProjectDao> res = response.body();
                    Log.d("service", "if :: " + response.message());
                    RvStatusAdapter adapter = new RvStatusAdapter(res, status, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                    for (ProjectDao row : res) {
                        Log.d("service", row.getPjName());
                    }
                } else {
                    try {
                        Log.d("service", "else :: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ProjectDao>> call, Throwable t) {
                Log.d("service", "else :: " + t);
            }
        });
    }

    public void getSt() {

        Call<List<StatusDao>> call = HttpManager.getInstance().getService().getStatus();
        call.enqueue(new Callback<List<StatusDao>>() {
            @Override
            public void onResponse(Call<List<StatusDao>> call, Response<List<StatusDao>> response) {
                if (response.isSuccessful()) {
                    List<StatusDao> res = response.body();
                    Log.d("service", "if :: " + response.message());
                    status = res;

                } else {
                    try {
                        Log.d("service", "else :: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<StatusDao>> call, Throwable t) {
                Log.d("service", "else :: " + t);
            }
        });
    }
}
