package com.fatimamostafa.animationsntransitions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewAnimation extends AppCompatActivity {

    @BindView(R.id.ivFace)
    ImageView ivFace;
    @BindView(R.id.btnAnimateXML)
    Button btnAnimateXML;
    @BindView(R.id.btnAnimateJava)
    Button btnAnimateJava;
    @BindView(R.id.btnRefresh)
    Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.btnAnimateXML, R.id.btnAnimateJava, R.id.btnRefresh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnAnimateXML:
                Animation animation =
                        AnimationUtils.loadAnimation(this, R.anim.grow);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        ivFace.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ivFace.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                ivFace.startAnimation(animation);
                break;
            case R.id.btnAnimateJava:

                break;
            case R.id.btnRefresh:
                ivFace.setVisibility(View.GONE);
                break;
        }
    }
}
