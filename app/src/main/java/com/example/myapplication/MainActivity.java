package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    List<ItemListResponse> itemListResponseData;
    List<ItemListResponse> dataWithName = new ArrayList<>();
    List<ItemListResponse> dataWithoutName = new ArrayList<>();


    ListView listView, listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        listView2 = findViewById(R.id.listView2);
        getItemListData();
    }

    private void getItemListData(){
        Api.getClient().getItemsList(new Callback<List<ItemListResponse>>() {
            @Override
            public void success(List<ItemListResponse> itemListResponses, Response response) {
                itemListResponseData = itemListResponses;

                for(ItemListResponse item: itemListResponses){
                    if(item.name == null || item.name.equals("")){
                        dataWithoutName.add(item);
                    }else{
                        dataWithName.add(item);
                    }
                }

                Collections.sort(dataWithName, (a,b)-> a.listId == b.listId ? a.name.compareTo(b.name): a.listId - b.listId);
                Collections.sort(dataWithoutName, (a,b)-> a.listId- b.listId);



                callListView();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
    private void callListView(){
        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dataWithName);
        listView.setAdapter(adapter);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dataWithoutName);
        listView2.setAdapter(adapter);
    }
}