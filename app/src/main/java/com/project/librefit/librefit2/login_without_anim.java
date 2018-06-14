package com.project.librefit.librefit2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crashlytics.android.answers.FirebaseAnalyticsEvent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class login_without_anim extends AppCompatActivity {

    TextView registar;
    TextView forget_password;
    LoginButton default_bt;
    Button facebook;
    FirebaseDatabase database;
    DatabaseReference ref;
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(login_without_anim.this);
        setContentView(R.layout.activity_login_without_anim);
        intial_value();
        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login_without_anim.this,signup.class);
                startActivity(intent);
                finish();
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login_without_anim.this,forgetpassword.class);
                startActivity(intent);
                finish();

            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                default_bt.performClick();
            }
        });
        facebook_class.context=login_without_anim.this;
        facebook_class.facebook_login(callbackManager);
    }
    public  void intial_value(){
        registar=(TextView)findViewById(R.id.register);
        forget_password=(TextView)findViewById(R.id.forgetpass);
        default_bt=(LoginButton)findViewById(R.id.login_button);
        facebook=(Button)findViewById(R.id.facebook);
        default_bt.setReadPermissions(Arrays.asList("public_profile","email"));
        callbackManager=CallbackManager.Factory.create();

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slidein,R.anim.slideout);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}

