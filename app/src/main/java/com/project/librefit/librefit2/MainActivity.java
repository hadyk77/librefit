package com.project.librefit.librefit2;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.util.Arrays;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    EditText username;
    Button facebook_custom;
    TextView registar;
    Handler handler=new Handler();
    Runnable runnable;
    ImageView logo;
    LoginButton faceBookDefulat;
    CallbackManager callbackManager;
    Animation animation;
    TextView forget_password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        intial_value();
        logo.startAnimation(animation);

        pullup_animation();
        handler.postDelayed(runnable, 3000);
        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slidein, R.anim.slideout);
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, forgetpassword.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slidein, R.anim.slideout);
            }
        });

        facebook_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Profile.getCurrentProfile()!=null){
                    LoginManager.getInstance().logOut();
                }
                faceBookDefulat.performClick();
            }
        });

     
        facebook_class.context=MainActivity.this;
        facebook_class.facebook_login(callbackManager);


    }
    public  void intial_value(){
        username=(EditText)findViewById(R.id.username);
        facebook_custom=(Button)findViewById(R.id.fb);
        relativeLayout=(RelativeLayout)findViewById(R.id.rela);
        logo=(ImageView)findViewById(R.id.logo);
        registar=(TextView)findViewById(R.id.register);
        animation= AnimationUtils.loadAnimation(this,R.anim.fadein);
        forget_password=(TextView)findViewById(R.id.forgetpass);
        faceBookDefulat=(LoginButton) findViewById(R.id.login_button);
        faceBookDefulat.setReadPermissions(Arrays.asList("public_profile","email"));
        callbackManager=CallbackManager.Factory.create();


    }
    public void pullup_animation(){

        runnable=new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animator = ObjectAnimator.ofFloat(logo, "translationY", -50f);
                animator.setDuration(500);
                animator.start();
                relativeLayout.setVisibility(View.VISIBLE);
                logo.setImageResource(R.drawable.logggowhite);
            }
        };
    }
    /*
    public void facebook_login(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                String accesstoken=loginResult.getAccessToken().getToken();
                GraphRequest request=GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        getdata(object);
                    }
                });
                Bundle parameters=new Bundle();
                parameters.putString("fields","id,email,name");
                request.setParameters(parameters);
                request.executeAsync();


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }
/*
    private void getdata(JSONObject object) {
        startActivity(new Intent(MainActivity.this,profile.class));
        overridePendingTransition(R.anim.slidein,R.anim.slideout);
        finish();
       /*
        Profile profile=Profile.getCurrentProfile();
        Bundle bundle=new Bundle();
        bundle.putParcelable("pic",profile);
        Intent loginint = new Intent(MainActivity.this,profile.class);
        loginint.putExtras(bundle);
        startActivity(loginint);
        finish();


    }
    public  void loggedin(){
            Intent loginedin_intent=new Intent(MainActivity.this,profile.class);
            startActivity(loginedin_intent);


    }
*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}
