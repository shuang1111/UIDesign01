package com.example.toolbar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {

    public static final String FURIT_NAME="fruit_name";
    public static final String FRUIT_IMAGE_ID="fruit_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        Intent intent=getIntent();
        String  fruitName=intent.getStringExtra(FURIT_NAME);
        int  fruitImageId=intent.getIntExtra(FRUIT_IMAGE_ID,0);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar1);
        CollapsingToolbarLayout collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        ImageView fruitImageView= (ImageView) findViewById(R.id.fruit_image);
        TextView  fruitContentText= (TextView) findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
       collapsingToolbarLayout.setTitle(fruitName);
        Glide.with(this).load(fruitImageId).into(fruitImageView);
        String fruitContent=generateFruitContent(fruitName);
        fruitContentText.setText(fruitContent);

    }
    private String generateFruitContent(String fruitName){
        StringBuilder fruitContent=new StringBuilder();

        for (int i=0;i<5000;i++){

            fruitContent.append(fruitName);
        }
        return  fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                finish();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
