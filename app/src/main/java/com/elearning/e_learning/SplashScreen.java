package com.elearning.e_learning;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.vansuita.library.CheckNewAppVersion;

public class SplashScreen extends AppCompatActivity {

    ImageView IMAGE_VIEW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        IMAGE_VIEW = (ImageView)findViewById(R.id.imageView7);

        Glide.with(getApplicationContext()).load(R.drawable.openbook).into(new GlideDrawableImageViewTarget(IMAGE_VIEW));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }, 3000);
    }
}
