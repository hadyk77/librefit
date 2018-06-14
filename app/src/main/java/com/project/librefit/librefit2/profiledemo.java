package com.project.librefit.librefit2;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class profiledemo extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
ImageView profile_pic;
TextView username,email,user_nav,title;
DrawerLayout nav;
ImageView open_nav;
NavigationView navigationView;
View hView;
ImageView imgvw;
ListView listView;
String [] items={"Settings","LOG OUT","RATE US","REPORT A PROBLEM"};
List<design_post_modele> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiledemo);
        intial_variables();
        user_data();
        open_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav.openDrawer(Gravity.LEFT);
            }
        });
        adapter ad=new adapter();
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(position==1){
                   LoginManager.getInstance().logOut();
                   startActivity(new Intent(profiledemo.this,login_without_anim.class));
                   overridePendingTransition(R.anim.slidein,R.anim.slideout);
                   finish();
               }

            }
        });
        intialize_Data();
        /*nonsrollable profile_content=(nonsrollable)findViewById(R.id.profile_content);
        adaper2 ad1=new adaper2();
        profile_content.setAdapter(ad1);
        */
        RecyclerView recyclerView=findViewById(R.id.profile_content);
        recyclerview re=new recyclerview(this,intialize_Data());
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(re);


    }
    public void intial_variables(){
        navigationView=(NavigationView)findViewById(R.id.nav_view);
        hView =  navigationView.inflateHeaderView(R.layout.customheader);
        imgvw = (ImageView)hView.findViewById(R.id.profile_image);
        profile_pic=(ImageView)findViewById(R.id.profile_image);
        username=(TextView)findViewById(R.id.username);
        nav=(DrawerLayout)findViewById(R.id.drawer_layout);
        open_nav=(ImageView)findViewById(R.id.open_nev);
        user_nav=(TextView) hView.findViewById(R.id.username_navigation);
        email=(TextView)findViewById(R.id.email);
        title=(TextView)findViewById(R.id.Title);
        listView=findViewById(R.id.listview);
        ScrollView sc=(ScrollView)findViewById(R.id.scrollview);
        sc.fullScroll(View.FOCUS_UP);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    public void close(View view) {
        nav.closeDrawer(Gravity.LEFT);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
 class adapter extends BaseAdapter{

     @Override
     public int getCount() {
         return items.length;
     }

     @Override
     public Object getItem(int position) {
         return null;
     }

     @Override
     public long getItemId(int position) {
         return 0;
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
         convertView=getLayoutInflater().inflate(R.layout.text_view,null);
         TextView textView=(TextView)convertView.findViewById(R.id.textView);
         textView.setText(items[position]);
         return convertView;
     }
 }

class adaper2 extends BaseAdapter{

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=getLayoutInflater();
        convertView=inflater.inflate(R.layout.content_design,null);
        ImageView img=(ImageView)convertView.findViewById(R.id.designs);
        TextView txt1=(TextView)convertView.findViewById(R.id.price);
        TextView txt2=(TextView)convertView.findViewById(R.id.rate);
        img.setImageResource(list.get(position).getImage());
        txt1.setText(list.get(position).getPrice());
        txt2.setText(list.get(position).getRate());
        return convertView;
    }

}
public  List<design_post_modele> intialize_Data(){
    list=new ArrayList<>();
    list.add(new design_post_modele("120 LE","3",R.drawable.tshirt));
    list.add(new design_post_modele("120 LE","3",R.drawable.tshirt));
    list.add(new design_post_modele("120 LE","3",R.drawable.tshirt));
    list.add(new design_post_modele("120 LE","3",R.drawable.tshirt));
    list.add(new design_post_modele("120 LE","3",R.drawable.tshirt));
    list.add(new design_post_modele("120 LE","3",R.drawable.tshirt));
    list.add(new design_post_modele("120 LE","3",R.drawable.tshirt));
    return  list;
}
public void user_data(){
    Picasso.get().load(Profile.getCurrentProfile().getProfilePictureUri(75,75)).into(imgvw);
    Picasso.get().load(Profile.getCurrentProfile().getProfilePictureUri(75,75)).into(profile_pic);
    username.setText(Profile.getCurrentProfile().getName());
    user_nav.setText(Profile.getCurrentProfile().getName());
    email.setText(Profile.getCurrentProfile().getName()+"@Librefit.com");
    title.setText(Profile.getCurrentProfile().getName()+"'s Profile");
}

}