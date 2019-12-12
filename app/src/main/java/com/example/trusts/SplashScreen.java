package com.example.trusts;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trusts.support.Preferences;

public class SplashScreen extends AppCompatActivity {
        private Preferences mPreference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            mPreference = new Preferences(this);
            if(mPreference.isLogin()){
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            }else{
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
            }
        }
}
