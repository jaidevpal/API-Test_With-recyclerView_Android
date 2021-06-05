package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Cust_RecyclerAdapter extends RecyclerView.Adapter<Cust_RecyclerAdapter.MyViewHolder> {

    private static ActivityMainBinding binding;
    private static List<photos> list;
    private static RecyclerViewOnItemClickInterface recyclerViewOnItemClickInterface;

    public Cust_RecyclerAdapter(List<photos> list, RecyclerViewOnItemClickInterface recyclerViewOnItemClickInterface) {
        this.list = list;
        this.recyclerViewOnItemClickInterface = recyclerViewOnItemClickInterface;
    }

    @Override
    public Cust_RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent, false);

        Cust_RecyclerAdapter.MyViewHolder viewHolder = new Cust_RecyclerAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        Picasso.get()
                .load(list.get(position).getUrl())
                .placeholder(R.drawable.iconfinder_18350_image_icon_256px)
                .fit()
                .into(holder.imageView);
//        holder.imageView.setImageResource(R.drawable.ic_launcher_foreground);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewCL);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewOnItemClickInterface.OnItemClickRV(getAdapterPosition(), list.get(getAdapterPosition()).getUrl());
                }
            });
        }
    }
}
