package com.example.toolbar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.toolbar.FruitActivity;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2017/8/3.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private Context context;
    private List<Fruit> fruitList;

    public FruitAdapter(List<Fruit> mFruitList){
         fruitList=mFruitList;
     }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context==null){
            context=parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder  holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit=fruitList.get(position);
                Intent intent=new Intent(context,FruitActivity.class);
                intent.putExtra(FruitActivity.FURIT_NAME,fruit.getName());
                intent.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruit.getImageId());
                context.startActivity(intent);
            }

        });

        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Fruit fruit=fruitList.get(position);
        holder.textView.setText(fruit.getName());
        Glide.with(context).load(fruit.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(View view) {
            super(view);
            cardView= (CardView) view;
            imageView= (ImageView) view.findViewById(R.id.fruit_image);
            textView= (TextView) view.findViewById(R.id.fruit_name);
        }
    }
}
