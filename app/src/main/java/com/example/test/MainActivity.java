package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnItemClickInterface{

    ActivityMainBinding binding;

    API_Interface api_interface;
    private List<photos> photosList = new ArrayList<>();
    private static final String TAG = "MainActivity's: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        api_interface = API_Client.getClient().create(API_Interface.class);
        callData();
        binding.rv1.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        binding.rv1.setLayoutManager(gridLayoutManager);
    }

    private void callData() {
        Call<List<photos>> call = api_interface.getPhotos();
        call.enqueue(new Callback<List<photos>>() {
            @Override
            public void onResponse(Call<List<photos>> call, Response<List<photos>> response) {
                if (response.isSuccessful()) {
                    Log.e(TAG, "onResponseSuccess: " + response.body());

                    photosList = response.body();
                    binding.rv1.setAdapter(new Cust_RecyclerAdapter(photosList, MainActivity.this));

//                    Cust_RecyclerAdapter cra = new Cust_RecyclerAdapter(response.body());
//                    rv.setAdapter(cra);

                }

            }

            @Override
            public void onFailure(Call<List<photos>> call, Throwable t) {
                Log.e(TAG, "onResponseFailure: " + t.getLocalizedMessage());
            }
        });
    }


    @Override
    public void OnItemClickRV(int position, String url) {
        Toast.makeText(this, "Item "+position+" Clicked!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "here is the link to the image: "+url);
        intent.setType("text/plain");
        this.startActivity(Intent.createChooser(intent,"Send to"));

    }
}