package com.example.dzikra.tweetfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import static com.example.dzikra.tweetfood.R.id.placePic;

/**
 * Created by Dzikra on 05/12/2016.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    //Constructor for custom Adapter
    public PlaceAdapter(Context context, List<Place> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View listItemView = convertView;
        //if the listView is empty, inflate the listView
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //get current Item position
        Place currentPlace = getItem(position);

        //get PlaceName
        TextView placeName = (TextView) listItemView.findViewById(R.id.placeName);
                placeName.setText(currentPlace.gettPlaceName());

        //get PlaceType
        TextView placeType = (TextView) listItemView.findViewById(R.id.placeType);
        placeType.setText(currentPlace.gettPlaceType());

        //customize the options for ImageLoader, such as what to display if the item
        //contains no image
        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.placeholder)
                .showImageOnFail(R.drawable.placeholder).build();

        //Load image with Universal Image Loader
        ImageView mplacePic = (ImageView) listItemView.findViewById(placePic);
        imageLoader.displayImage("drawable://"+currentPlace.getImage(), mplacePic, options);

        return listItemView;
    }
}
