package com.project.librefit.librefit2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.facebook.AccessToken;
import com.facebook.Profile;
import io.fabric.sdk.android.Fabric;

public class check_if_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_check_if_login);
        if (Profile.getCurrentProfile()!=null){
            startActivity(new Intent(check_if_login.this,profiledemo.class));
            finish();
        }
        else
            startActivity(new Intent(check_if_login.this,MainActivity.class));
        finish();
    }
}
