package com.project.librefit.librefit2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class signup extends AppCompatActivity {
    Button ok;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initial_value();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(signup.this,login_without_anim.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public  void initial_value(){
        ok=(Button) findViewById(R.id.ok);
        back=(Button) findViewById(R.id.back);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slidein,R.anim.slideout);
    }
}
