package com.example.nkarayev.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.nkarayev.myapplication.Attraction;

import java.util.ArrayList;

public class AttractionList extends AppCompatActivity {

    private final int ATTRACTION_MAX = 5;
    String[] names;
    String[] address;
    String[] desc;
    int[] thumbs = null;
    int[] full = null;
    ArrayList<Attraction> attraction = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_list);


    }

    private ArrayList<Attraction> fillArrayList(String[] what, String[] where, String[] why, int[] thumb, int[] full){

        ArrayList<Attraction> list = new ArrayList<>();

        for(int i = 0; i < ATTRACTION_MAX; i++){
            Attraction attraction = new Attraction();
            attraction.setmName(what[i]);
            attraction.setmAddress(where[i]);
            attraction.setmThumbId(thumb[i]);
            attraction.setmImgId(full[i]);
            attraction.setmDesc(why[i]);
            list.add(attraction);
        }
        return list;
    }

    private int[] setThumbIdsforInterests(){
        int[] thumbIds = new int[ATTRACTION_MAX];

        thumbIds[0] = R.drawable.pmhthumb;
        thumbIds[1] = R.drawable.cheesethumb;
        thumbIds[2] = R.drawable.ssmthumb;
        thumbIds[3] = R.drawable.meltthumbimg;
        thumbIds[4] = R.drawable.seethumbimg;

        return thumbIds;
    }

    private int[] setFullImgIdForInterests(){
        int[] fullImgID = new int[ATTRACTION_MAX];

        fullImgID[0] = R.drawable.pizzamyheart;
        fullImgID[1] = R.drawable.cheesecakefactoryfullimg;
        fullImgID[2] = R.drawable.stanfordfullimg;
        fullImgID[3] = R.drawable.meltfullimg;
        fullImgID[4] = R.drawable.seesfullimg;

        return fullImgID;
    }

    private void setRests(){
        ListView listView = (ListView) findViewById(R.id.activity_attraction_list);
        names = getResources().getStringArray(R.array.rest_names_PA);
        address = getResources().getStringArray(R.array.rest_address_PA);
        desc = getResources().getStringArray(R.array.rest_desc_PA);
        thumbs = setThumbIdsforInterests();//TODO ADD PICTURES
        full = setFullImgIdForInterests();//TODO ADD PICTURES
        attraction = fillArrayList(names, address, desc, thumbs, full);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(AttractionList.this, AttractionDetail.class);
                intent.putExtra(getString(R.string.ATTRACTION), attraction.get(position));
                startActivity(intent);
            }
        });
    }

    private void setInts(){
        ListView listView = (ListView) findViewById(R.id.activity_attraction_list);
        names = getResources().getStringArray(R.array.interests_names_PA);
        address = getResources().getStringArray(R.array.interests_address_PA);
        desc = getResources().getStringArray(R.array.interests_desc_pa);
        thumbs = setThumbIdsforInterests();
        full = setFullImgIdForInterests();
        attraction = fillArrayList(names, address, desc, thumbs, full);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(AttractionList.this, AttractionDetail.class);
                intent.putExtra(getString(R.string.ATTRACTION), attraction.get(position));
                startActivity(intent);
            }
        });
    }
}