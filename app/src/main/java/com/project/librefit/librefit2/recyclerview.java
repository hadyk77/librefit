package com.project.librefit.librefit2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class recyclerview extends RecyclerView.Adapter<recyclerview.view_holder> {
    private Context mcontext;
    private List<design_post_modele> mdata;

    public recyclerview(Context mcontext, List<design_post_modele> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        View v=inflater.inflate(R.layout.content_design,parent,false);
        return new view_holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
      holder.price.setText(mdata.get(position).getPrice());
      holder.rate.setText(mdata.get(position).getRate());
      holder.designs.setImageResource(mdata.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    static class view_holder extends RecyclerView.ViewHolder{
       static ImageView designs;
       static TextView price;
       static TextView rate;
        public view_holder(View itemView) {
            super(itemView);
            designs=(ImageView)itemView.findViewById(R.id.designs);
            price  =(TextView)itemView.findViewById(R.id.price);
            rate=(TextView)itemView.findViewById(R.id.rate);


        }
    }
}
