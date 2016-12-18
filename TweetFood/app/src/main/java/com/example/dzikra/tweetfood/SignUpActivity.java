package com.example.dzikra.tweetfood;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Display tv_title with custom typeface
        TextView tx = (TextView)findViewById(R.id.tv_title);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Confetti-Stream.ttf");
        tx.setTypeface(custom_font);

        //Set custom typeface for EditText registerPass and make it asterix
        EditText password = (EditText) findViewById(R.id.et_registerPass);
        password.setTypeface(Typeface.SANS_SERIF);
        password.setTransformationMethod(new PasswordTransformationMethod());

        //Set custom typeface for EditText registerPassConf and make it asterix
        EditText passwordConf = (EditText) findViewById(R.id.et_registerPassConf);
        passwordConf.setTypeface(Typeface.SANS_SERIF);
        passwordConf.setTransformationMethod(new PasswordTransformationMethod());

    }
}
