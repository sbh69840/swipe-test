package com.example.admin.shiv;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;


public class MainActivity extends MainActivityA {
    float x1,x2;
    float y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            // when user first touches the screen we get x and y coordinate
            case MotionEvent.ACTION_DOWN:
            {
                x1 = event.getX();
                y1 = event.getY();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                x2 = event.getX();
                y2 = event.getY();

                //if left to right sweep event on screen
                if (x1 < x2 && x1<(getScreenWidth()*0.08))
                {
                    Toast.makeText(this, "Left to Right Swap Performed", Toast.LENGTH_LONG).show();
                }

                // if right to left sweep event on screen
                if (x1 > x2 && x1>(getScreenWidth()*0.9))
                {
                    Toast.makeText(this, "Right to Left Swap Performed", Toast.LENGTH_LONG).show();
                }

                // if UP to Down sweep event on screen
                if (y1 < y2 && y1<(getScreenHeight()*0.2))
                {
                    Toast.makeText(this, "UP to Down Swap Performed", Toast.LENGTH_LONG).show();
                }



                break;
            }
        }







        return super.onTouchEvent(event);

    }



    protected void launchApp(String packageName) {

        Intent mIntent = getPackageManager().getLaunchIntentForPackage(

                packageName);

        if (mIntent != null) {

            try {

                startActivity(mIntent);

            } catch (ActivityNotFoundException err) {

                Toast t = Toast.makeText(getApplicationContext(),

                        R.string.app_not_found, Toast.LENGTH_SHORT);

                t.show();

            }

        }

    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }



}