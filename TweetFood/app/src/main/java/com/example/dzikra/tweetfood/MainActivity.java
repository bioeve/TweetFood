package com.example.dzikra.tweetfood;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaration for username and password EditText
        final EditText username = (EditText)findViewById(R.id.et_uname);
        final EditText pass = (EditText)findViewById(R.id.et_pass);

        //Display background with Universal Image Loader library
        ImageLoader imageLoader = ImageLoader.getInstance();
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(MainActivity.this));

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageLoader.displayImage("drawable://"+R.drawable.bg2, imageView);

        //Display tv_title with custom typeface
        TextView tx = (TextView)findViewById(R.id.tv_title);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Confetti-Stream.ttf");

        //Set custom typeface for EditText password and make it asterix
        tx.setTypeface(custom_font);
        final EditText password = (EditText) findViewById(R.id.et_pass);
        password.setTypeface(Typeface.SANS_SERIF);
        password.setTransformationMethod(new PasswordTransformationMethod());

        TextView signUp = (TextView) findViewById(R.id.tv_SignUp);

        // Set a click listener on that View
        signUp.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the sign up button is clicked on.
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
                    startActivity(signUpIntent);

            }

        });

        Button home = (Button) findViewById(R.id.b_signin);
        //Set custom onClickListener if the username EditText and password EditText values equals
        //"admin" then go to HomeActivity
        //if not show Toast that says username/id not found
        home.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent HomeIntent = new Intent(MainActivity.this, HomeActivity.class);
                if (username.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
                    startActivity(HomeIntent);
                else
                    Toast.makeText(getApplicationContext(), "Username or ID not Found!", Toast.LENGTH_LONG).show();

            }

        });

    }
}
