package com.example.loginsignupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    adding a variable to move from spalsh screen to next screen
    private static int SPLASH_SCREEN = 5000;


    // for anim add some variables
    Animation topAnim,bottomAnim;

    //adding animation to the text and image
    ImageView image;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Hide action bar and status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // the above code is for hiding status bar


        setContentView(R.layout.activity_main);


        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animination);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animination);
        // now animation hooked to backend and we need to add these animations to the text and image


        // after creating the image view and textview objects we need to add animations to them

        // adding animations to them
        image = findViewById(R.id.img1);
        logo = findViewById(R.id.text1);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(image,"logo_name");
                pairs[1] = new Pair<View,String>(logo,"logo_text");


                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }
                // finish is must bcz if user hit backButton then he will again goes to splashscreen
            }
        },SPLASH_SCREEN);
    }
}


// we have also done chnage in temes.xml for removing status bar navigation bar
// we have changed style name="Theme.LogInSignUpDemo" parent="Theme.MaterialComponents.DayNight.NoActionBar">
// earlier there wa style name="Theme.LogInSignUpDemo" parent="Theme.MaterialComponents.DayNight.ActionBar">
// we have remove both of them