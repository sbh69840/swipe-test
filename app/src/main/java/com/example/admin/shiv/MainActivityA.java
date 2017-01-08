package com.example.admin.shiv;

/**
 * Created by admin on 31/12/2016.
 */

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;





public class MainActivityA extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    private GestureDetectorCompat GestureDetect;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GestureDetect=new GestureDetectorCompat(this,this);
        GestureDetect.setOnDoubleTapListener(this);
        textView=(TextView) findViewById(R.id.textView);


    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        GestureDetect.onTouchEvent(event);






        return super.onTouchEvent(event);

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        textView.setText("onSingleTapConfirmed"+motionEvent.toString());
        launchApp("com.whatsapp");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        textView.setText("onDoubleTap"+motionEvent.toString());
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        textView.setText("onDoubleTapEvent"+motionEvent.toString());
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        textView.setText("onDown"+motionEvent.toString());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        textView.setText("onShowPress"+motionEvent.toString());

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        textView.setText("onSingleTapUp"+motionEvent.toString());
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        textView.setText("onScroll"+motionEvent.toString()+motionEvent1.toString());

        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        textView.setText("onLongPress"+motionEvent.toString());

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        textView.setText("onFling"+motionEvent.toString()+motionEvent1.toString());
        return false;
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





}