package com.example.mypaint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BrushView brushView=new BrushView(this);
        setContentView(brushView);  //for setting the brush view dinamically
        //addContentView(brushView.erase,brushView.layoutParams);     // passing the parameter
    }
}
