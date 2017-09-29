package com.fatimamostafa.animationsntransitions.animationtypes;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.fatimamostafa.animationsntransitions.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObjectAnimatorActivity extends AppCompatActivity {

    @BindView(R.id.ivFace)
    ImageView ivFace;
    @BindView(R.id.btnSingleAnimation)
    Button btnSingleAnimation;
    @BindView(R.id.btnMultipleAnimation)
    Button btnMultipleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btnSingleAnimation, R.id.btnMultipleAnimation})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnSingleAnimation:
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(ivFace,
                        "scaleX", 1f, 2f)
                        .setDuration(1000);
                animatorX.start();
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(ivFace,
                        "scaleY", 1f, 2f)
                        .setDuration(1000);
                animatorY.start();
                break;

            case R.id.btnMultipleAnimation:
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(ivFace,
                        "scaleX", 1f, 2f)
                        .setDuration(1000);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(ivFace,
                        "scaleY", 1f, 2f)
                        .setDuration(1000);

                AnimatorSet animatorSet = new AnimatorSet();
               // animatorSet.playTogether(animator1, animator2); //Like the single animation
                animatorSet.playSequentially(animator1, animator2); //one after another
                animatorSet.setDuration(3000);
                animatorSet.start();

                break;
        }
    }
}
