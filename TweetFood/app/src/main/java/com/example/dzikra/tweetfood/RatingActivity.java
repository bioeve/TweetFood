package com.example.dzikra.tweetfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        //Display background with Universal Image Loader library
        ImageLoader imageLoader = ImageLoader.getInstance();
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(RatingActivity.this));

        ImageView imageView = (ImageView) findViewById(R.id.ratingBg);
        imageLoader.displayImage("drawable://"+R.drawable.rating_bg, imageView);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(RatingActivity.this, String.valueOf(v),Toast.LENGTH_SHORT).show();
            }
        });

        TextView suggest = (TextView)findViewById(R.id.suggestButton);
        suggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent suggest = new Intent(Intent.ACTION_SEND);
                suggest.setType("message/rfc822");
                suggest.putExtra(Intent.EXTRA_EMAIL, new String[]{"tweetFoodDev@gmail.com"});
                suggest.putExtra(Intent.EXTRA_SUBJECT, "New place suggestion");
                try {
                    startActivity(Intent.createChooser(suggest, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(RatingActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
