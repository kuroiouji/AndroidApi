package com.kamitoon.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.kamitoon.api.model.StudentDao;
import com.kamitoon.api.service.HttpManager;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        
        service();
    }

    public void service() {
        /*Call<List<StudentDao>> call = HttpManager.getInstance().getService().getStudent();
        Log.d("service", "GG ");
        call.enqueue(new Callback<List<StudentDao>>() {
            @Override
            public void onResponse(Call<List<StudentDao>> call, Response<List<StudentDao>> response) {
                if(response.isSuccessful()){
                    List<StudentDao> res = response.body();
                    Log.d("service", "if :: " + response.message());
                    for(StudentDao row : res) {
                        Log.d("service", row.getFname());
                    }
                }else{
                    try {
                        Log.d("service", "else :: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<StudentDao>> call, Throwable t) {
                Log.d("service", "onFailure: " + t);
            }
        });*/
    }
}
