package com.example.loginsignupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button login_btn;
    ImageView image;
    TextView logoText , sologanText;
    TextInputLayout username, password;

    Button callSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);


        // hooks
        callSignUp = findViewById(R.id.signup_screen);

        login_btn = findViewById(R.id.log_in);
//        logoText = findViewById(R.id.logo_name);
//        sologanText = findViewById(R.id.);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);



        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
//
//                Pair[] pairs = new Pair[6];
//
//                pairs[0] = new Pair()
            }
        });

    }
}