package com.example.experience;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    FrameLayout frameLayout;
    Button btn;
    Animation animation;

    TranslateAnimation anim;
    int Fwidth;
    int Fheight;

    FrameLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fl);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        //animation.setAnimationListener(this);
        animation.setFillAfter(false);




        //getSizeOfLayout();
        System.out.println(Fwidth+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams((int)919/3,(int)919/3);
        frameLayout.setBackgroundColor(Color.GREEN);
        btn = new Button(this);
        btn.setBackgroundColor(Color.RED);
        btn.setLayoutParams(btnParams);
        frameLayout.addView(btn);
        btn.setY(919/3);
        btn.setOnClickListener(this);
        params = (FrameLayout.LayoutParams)btn.getLayoutParams();


        anim = new TranslateAnimation(0,306, 0, 0);

        anim.setDuration(1000);
        anim.setAnimationListener(this);


    }

    private Point getPointOfView(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Point(location[0], location[1]);
    }

    @Override
    public void onClick(View view) {

        //btn.setAnimation(animation);
        Toast.makeText(this, "kkkkk", Toast.LENGTH_SHORT).show();
        btn.startAnimation(anim);


    }

    public void getSizeOfLayout(){
        ViewTreeObserver vto = frameLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    frameLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                Fwidth  = frameLayout.getMeasuredWidth();
                Fheight = frameLayout.getMeasuredHeight();

            }
        });
    }


    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //btn.setX(btn.getWidth());


        params.leftMargin += btn.getWidth();
        btn.setLayoutParams(params);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}