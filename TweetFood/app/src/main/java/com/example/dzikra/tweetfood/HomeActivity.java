package com.example.dzikra.tweetfood;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    MaterialSearchView materialSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //enable image caching using Universal Image Loader
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        //set the configuration of Universal Image Loader
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

         materialSearchView = (MaterialSearchView)findViewById(R.id.search_view);

        //Create an ArrayList with custom class Place
        final ArrayList<Place> places = new ArrayList<>();
        //Add items to ArrayList
        places.add(new Place("Dancing Crab", "Restaurant", R.drawable.dancingcrab));
        places.add(new Place("Cuanki Serayu", "Street Food", R.drawable.cuankiserayu));
        places.add(new Place("Two Cents", "Cafe", R.drawable.twocents));
        places.add(new Place("Let's Go Gelato", "Restaurant", R.drawable.placeholder));

        //Initialize custom adapter PlaceAdapter
        final PlaceAdapter adapter = new PlaceAdapter(this,places);

        //Initialize ListView, for later population
        final ListView listView = (ListView) findViewById(R.id.list_home);

        //setAdapter to for the listView to be the custom adapter
        listView.setAdapter(adapter);

        //set custom onItemClickListener, so if one of the item from listView is clicked
        //it will go to ContentActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent contentIntent = new Intent(HomeActivity.this, ContentActivity.class);
                startActivity(contentIntent);
            }
        });

        materialSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                //Initialize custom adapter PlaceAdapter
                final PlaceAdapter adapter = new PlaceAdapter(HomeActivity.this,places);

                //Initialize ListView, for later population
                ListView listView = (ListView) findViewById(R.id.list_home);

                //setAdapter to for the listView to be the custom adapter
                listView.setAdapter(adapter);

            }
        });

        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && !newText.isEmpty()){
                    List<Place> lstFound = new ArrayList<Place>();
                    for (Place item:places){
                        if(item.gettPlaceName().toLowerCase().contains(newText))
                            lstFound.add(item);
                    }
                    PlaceAdapter adapter1 = new PlaceAdapter(HomeActivity.this, lstFound);
                    ListView listView1 = (ListView)findViewById(R.id.list_home);
                    listView1.setAdapter(adapter1);
                }
                else {
                    //Initialize custom adapter PlaceAdapter
                    final PlaceAdapter adapter = new PlaceAdapter(HomeActivity.this,places);

                    //Initialize ListView, for later population
                    ListView listView = (ListView) findViewById(R.id.list_home);

                    //setAdapter to for the listView to be the custom adapter
                    listView.setAdapter(adapter);
                }
                return  true;
            }
        });
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_item, menu);

            MenuItem item = menu.findItem(R.id.action_search);
            materialSearchView.setMenuItem(item);

            return true;
        }
}
