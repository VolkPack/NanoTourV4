package com.example.nkarayev.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AttractionDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);
        Intent intent = getIntent();
        Attraction attraction = (Attraction)intent.getSerializableExtra(getString(R.string.ATTRACTION));

        ImageView fullImg = (ImageView) findViewById(R.id.fullIImage);
        TextView title = (TextView) findViewById(R.id.titleName);
        TextView address = (TextView) findViewById(R.id.address);
        TextView desc = (TextView)findViewById(R.id.desc);

        title.setText(attraction.getmName());
        address.setText(attraction.getmAddress());
        fullImg.setImageResource(attraction.getmImgId());
        desc.setText(attraction.getmDesc());
    }
}