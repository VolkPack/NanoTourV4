package com.example.nkarayev.myapplication;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nkarayev on 2/23/17.
 */

public class AttractionListAdapter extends ArrayAdapter<Attraction> {

    public AttractionListAdapter(Activity context, ArrayList<Attraction> attraction)
    {
        super(context, 0, attraction);
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        Attraction currentAttraction = getItem(pos);
        View listItemView = convertView;

        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.attraction_list_layout, parent, false);
        }

        if(currentAttraction.getmThumbId() == 0) {
            ImageView thumb = (ImageView) listItemView.findViewById(R.id.attraction_thumb);
            thumb.setImageResource(R.drawable.missing_img);
        }else {
            ImageView thumb = (ImageView) listItemView.findViewById(R.id.attraction_thumb);
            thumb.setImageResource(currentAttraction.getmThumbId());
        }

        TextView title = (TextView) listItemView.findViewById(R.id.attraction_list_name);
        title.setText(currentAttraction.getmName());

        return listItemView;
    }


}