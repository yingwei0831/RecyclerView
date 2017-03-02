package com.yw.testrecyclerview.ui;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.yw.testrecyclerview.R;

public class TestAnimationViewActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_animation_view);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setEnterTransition(new Explode().setDuration(2000));
//            getWindow().setExitTransition(new Explode().setDuration(2000));
//        }

        tvAnimationView = (TextView) findViewById(R.id.tv_test_animation);
        tvAnimationView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_test_animation:
                animate(view);
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void animate(View view) {
        int centerX = (view.getRight() - view.getLeft()) / 2;
        int centerY = (view.getBottom() - view.getTop()) / 2;

        int finalRadius = Math.max(view.getWidth(), view.getHeight());
//        Animator anim = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, 0, finalRadius); //从中心向最大值处扩散
//        anim.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
////                tvAnimationView.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//            }
//        });
//        Animator anim = ViewAnimationUtils.createCircularReveal(view, view.getWidth()/2, view.getHeight()/2, finalRadius, 0); //沿着中心缩小
        Animator anim = ViewAnimationUtils.createCircularReveal(view, view.getMeasuredWidth()/2, view.getMeasuredHeight()/2, finalRadius, 0);
//        Animator anim = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, finalRadius, 0);
//        Animator anim = ViewAnimationUtils.createCircularReveal(view, 0, 0, 0, (float) Math.hypot(view.getWidth(), view.getHeight()));
        anim.setDuration(2000);
        anim.setInterpolator(new LinearInterpolator());
//        tvAnimationView.setVisibility(View.VISIBLE);
        anim.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        supportFinishAfterTransition();
    }
}
