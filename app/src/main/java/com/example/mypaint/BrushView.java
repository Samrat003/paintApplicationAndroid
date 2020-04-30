package com.example.mypaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BrushView  extends View {
    ViewGroup.LayoutParams layoutParams;    //here it is for the dinamically implement for view
    Path path=new Path();
    Paint brush=new Paint();
    Button erase,blk,grn,blu,yel,pnk,rd,dt;
    int flagBlack=0;

    public BrushView(Context context) {
        super(context);
        brush.setAntiAlias(true);       // true for smoothly draw
       // brush.setColor(Color.BLUE);         //set the color
        brush.setStrokeWidth(10f);
        brush.setStyle(Paint.Style.STROKE);     //here the brush style is Stroke
        brush.setStrokeJoin(Paint.Join.ROUND);  // when we hit the stroke its shape will be round
        erase=findViewById(R.id.er);
        blk=findViewById(R.id.black);
        grn=findViewById(R.id.green);
        blu=findViewById(R.id.blue);
        yel=findViewById(R.id.yellow);
        pnk=findViewById(R.id.pink);
        rd=findViewById(R.id.red);
        dt=findViewById(R.id.delete);
        //erase=new Button(context);
       // erase.setText("Erase");
       // layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
       // erase.setLayoutParams(layoutParams);
        erase.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                path.reset();
                postInvalidate();
            }
        });

        blk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                brush.setColor(Color.rgb(255,255,255));
                flagBlack=1;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        if (flagBlack==1) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(x, y);       // where we first touch save the position by moveTo function
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(x, y);          // for draw -by remembering the first position by moveTo function and draw the line by lineTo function
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
        }
        postInvalidate();
        return true;
    }

    @Override
    public void draw(Canvas canvas) {   // for creating the canvas for draw
        super.draw(canvas);
        canvas.drawPath(path,brush);
    }
}
