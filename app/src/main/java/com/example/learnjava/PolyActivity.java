package com.example.learnjava;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class PolyActivity extends AppCompatActivity {

    private Button startGame_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poly);

        startGame_Button = (Button) findViewById(R.id.startGame_Button);
        startGame_Button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                // inflate the layout of the popup window
               setupGameView(view);



           }
       });


    }


    public void setupGameView(View view){

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View asteroids_PopView = inflater.inflate(R.layout.astroid_popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(asteroids_PopView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        asteroids_PopView .setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

       startGame(asteroids_PopView);


    }

    public void startGame(final View asteroid_PopView){
        //ImageView background = (ImageView) asteroid_PopView.getBackground();
        final ImageView backgroundOne =  asteroid_PopView.findViewById(R.id.background_one);
        final ImageView backgroundTwo = asteroid_PopView.findViewById(R.id.background_two);

        final ValueAnimator animator = ValueAnimator.ofFloat(1.0f, 0.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(10000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float height = backgroundOne.getHeight();
                final float translationY = -height * progress;
                backgroundOne.setTranslationY(translationY + height);
                backgroundTwo.setTranslationY(translationY);
            }
        });
        animator.start();



        final ImageView rocketSprite = asteroid_PopView.findViewById(R.id.rocketSprite);
        rocketSprite.setImageResource(R.drawable.rocket);



        final Button moveRightButton = asteroid_PopView.findViewById(R.id.moveRight);
        moveRightButton.setBackgroundResource(R.drawable.right_arrow);
        Button moveLeftButton = asteroid_PopView.findViewById(R.id.moveLeft);
        moveLeftButton.setBackgroundResource(R.drawable.left_arrow);


        moveRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = rocketSprite.getX();

                    x += 40;
                    rocketSprite.setX(x);

            }
        });



        moveLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = rocketSprite.getX();

                    x -= 40;
                    rocketSprite.setX(x);


                //rocketSprite.startAnimation(goLeft);




            }
        });


//        Button moveLeftButton = findViewById(R.id.moveLeft);
//
//        moveLeftButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


    }




}
