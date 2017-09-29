package com.fatimamostafa.animationsntransitions.animationtypes;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.fatimamostafa.animationsntransitions.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrawableAnimationActivity extends AppCompatActivity {

    @BindView(R.id.btnStart)
    Button btnStart;
    @BindView(R.id.btnStop)
    Button btnStop;
    @BindView(R.id.ivMonkey)
    ImageView ivMonkey;

    private AnimationDrawable monkeyAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);
        ButterKnife.bind(this);

        if(ivMonkey == null) throw new AssertionError();

        ivMonkey.setVisibility(View.INVISIBLE);
        ivMonkey.setBackgroundResource(R.drawable.monkey_animation);

        monkeyAnimation = (AnimationDrawable) ivMonkey.getBackground();
        monkeyAnimation.setOneShot(true);
    }

    @OnClick({R.id.btnStart, R.id.btnStop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnStart:

                ivMonkey.setVisibility(View.VISIBLE);
                if(monkeyAnimation.isRunning()){
                    monkeyAnimation.stop();
                }
                monkeyAnimation.start();

                break;

            case R.id.btnStop:
                monkeyAnimation.stop();
                break;
        }
    }
}
