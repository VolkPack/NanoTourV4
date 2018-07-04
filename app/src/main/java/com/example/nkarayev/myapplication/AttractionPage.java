package com.example.nkarayev.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.BoolRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class AttractionPage extends AppCompatActivity {

    ArrayList<Attraction> attraction = new ArrayList<>();
    private final int ATTRACTION_MAX = 5;
    String[] names;
    String[] address;
    String[] desc;
    int[] thumbs = null;
    int[] full = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        setRests();
        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        final MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);



        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // This method will be invoked when a new page becomes selected.

            @Override
            public void onPageSelected(int position) {
                ListView listView = (ListView) findViewById(R.id.activity_attraction_list);
                AttractionListAdapter attractionListAdapter = new AttractionListAdapter(AttractionPage.this, attraction);
                attractionListAdapter.notifyDataSetChanged();
                switch (position){
                    case 0:
                        setRests();
                        listView.setAdapter(attractionListAdapter);
                        break;
                    case 1:
                        setInts();
                        listView.setAdapter(attractionListAdapter);
                        break;
                }
                //listView.setAdapter(attractionListAdapter);
                Toast.makeText(AttractionPage.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();

            }

            // This method will be invoked when the current page is scrolled
            Boolean first = true;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (first && positionOffset == 0 && positionOffsetPixels == 0){
                    onPageSelected(0);
                    first = false;
                }

            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {


            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return FirstFragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return FirstFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return FirstFragment.newInstance(2, "Page # 3");
                case 3: // Fragment # 1 - This will show SecondFragment
                    return FirstFragment.newInstance(3, "Page # 4");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + (position+1);
        }
    }


    private void setRests(){
        //ListView listView = (ListView) findViewById(R.id.activity_attraction_list);
        names = getResources().getStringArray(R.array.rest_names_PA);
        address = getResources().getStringArray(R.array.rest_address_PA);
        desc = getResources().getStringArray(R.array.rest_desc_PA);
        attraction = fillArrayList(names, address, desc, thumbs, full);
        /**
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(AttractionList.this, AttractionDetail.class);
                intent.putExtra(getString(R.string.ATTRACTION), attraction.get(position));
                startActivity(intent);
            }
        }); */
    }

    private void setInts(){
        //ListView listView = (ListView) findViewById(R.id.activity_attraction_list);
        names = getResources().getStringArray(R.array.interests_names_PA);
        address = getResources().getStringArray(R.array.interests_address_PA);
        desc = getResources().getStringArray(R.array.interests_desc_pa);
        //thumbs = setThumbIdsforInterests();
        //full = setFullImgIdForInterests();
        attraction = fillArrayList(names, address, desc, thumbs, full);
        /**
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(AttractionList.this, AttractionDetail.class);
                intent.putExtra(getString(R.string.ATTRACTION), attraction.get(position));
                startActivity(intent);
            }
        }); */
    }

    private ArrayList<Attraction> fillArrayList(String[] what, String[] where, String[] why, int[] thumb, int[] full){

        ArrayList<Attraction> list = new ArrayList<>();

        for(int i = 0; i < ATTRACTION_MAX; i++){
            Attraction attraction = new Attraction();
            attraction.setmName(what[i]);
            attraction.setmAddress(where[i]);
           //attraction.setmThumbId(thumb[i]);
            //attraction.setmImgId(full[i]);
            attraction.setmDesc(why[i]);
            list.add(attraction);
        }
        return list;
    }

}
