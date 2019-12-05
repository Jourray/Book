package com.example.book;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int numberofPages = 5;
    private int currentPage;
    private LinearLayout mLlContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(this);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.dot_red_shape);
            } else {
                imageView.setBackgroundResource(R.drawable.dot_gray_shape);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER_VERTICAL;
            if (i > 0) {
                params.leftMargin = dpToPixel(10);
            }
            mLlContainer.addView(imageView, params);
        }


    }

    private int dpToPixel(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (density * dp);

    }

    private void initView() {
        mLlContainer = findViewById(R.id.ll_container);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            ImageView image = (ImageView) mLlContainer.getChildAt(currentPage);
            image.setBackgroundResource(R.drawable.dot_gray_shape);
            if (currentPage < numberofPages - 1) {
                currentPage++;
            } else {
                currentPage = 0;
            }
            ImageView current = (ImageView) mLlContainer.getChildAt(currentPage);
            current.setBackgroundResource(R.drawable.dot_red_shape);
        }


        return true;
    }
}
