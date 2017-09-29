package com.fatimamostafa.animationsntransitions.animationtypes;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fatimamostafa.animationsntransitions.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InterPolatorActivity extends AppCompatActivity {

    @BindView(R.id.btnAnimate)
    Button btnAnimate;
    @BindView(R.id.ivFace)
    ImageView ivFace;
    @BindView(R.id.rlCanvas)
    RelativeLayout rlCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_polator);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAnimate)
    public void onViewClicked() {
        Log.d("Interpolator", "onViewClicked: ");
        int screenHeight = rlCanvas.getHeight();
        int targetY = screenHeight - ivFace.getHeight();

        ObjectAnimator animator = ObjectAnimator.ofFloat(
                ivFace, "y", 0, targetY)
                .setDuration(1000);

        animator.setInterpolator(new BounceInterpolator());
        animator.setRepeatCount(1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Log.d("Interpolator", "onAnimationUpdate: " + valueAnimator.getAnimatedValue());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.d("Interpolator", "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.d("Interpolator", "onAnimationEnd: ");
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.d("Interpolator", "onAnimationRepeat: ");
            }
        });
        animator.start();
    }
}
