package com.fatimamostafa.animationsntransitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fatimamostafa.animationsntransitions.animationtypes.DrawableAnimationActivity;
import com.fatimamostafa.animationsntransitions.animationtypes.InterPolatorActivity;
import com.fatimamostafa.animationsntransitions.animationtypes.ObjectAnimatorActivity;
import com.fatimamostafa.animationsntransitions.animationtypes.PropertyAnimationActivity;
import com.fatimamostafa.animationsntransitions.animationtypes.ViewAnimationActivity;
import com.fatimamostafa.animationsntransitions.transitions.crossfade.CrossfadeTransitionActivity;
import com.fatimamostafa.animationsntransitions.transitions.flip.FlipAnimationActivity;
import com.fatimamostafa.animationsntransitions.transitions.transitionframework.TransitionScenesActivity;
import com.fatimamostafa.animationsntransitions.transitions.viewpager.ViewpagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnClickCallback{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    HomeAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String[] titles = {
                "View Animation",
                "Drawable Animation",
                "Property Animation",
                "Object Animator",
                "Interpolator Animator",
                "CrossFade Transition",
                "Viewpage Transition",
                "Flip Transition",
                "Transition Framework"
        };

        mLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HomeAdapter(titles,this,this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClickCallback(int position) {
        switch (position) {
            case 0:
                Intent viewIntent = new Intent(this, ViewAnimationActivity.class);
                startActivity(viewIntent);
                break;
            case 1:
                Intent drawableIntent = new Intent(this, DrawableAnimationActivity.class);
                startActivity(drawableIntent);
                break;
            case 2:
                Intent propertyIntent = new Intent(this, PropertyAnimationActivity.class);
                startActivity(propertyIntent);
                break;
            case 3:
                Intent objectIntent = new Intent(this, ObjectAnimatorActivity.class);
                startActivity(objectIntent);
                break;
            case 4:
                Intent interpolatorIntent = new Intent(this, InterPolatorActivity.class);
                startActivity(interpolatorIntent);
                break;
            case 5:
                Intent crossfadeIntent = new Intent(this, CrossfadeTransitionActivity.class);
                startActivity(crossfadeIntent);
                break;
            case 6:
                Intent viewpagerIntent = new Intent(this, ViewpagerActivity.class);
                startActivity(viewpagerIntent);
                break;
            case 7:
                Intent flipIntent = new Intent(this, FlipAnimationActivity.class);
                startActivity(flipIntent);
                break;
            case 8:
                Intent trFramwrkIntent = new Intent(this, TransitionScenesActivity.class);
                startActivity(trFramwrkIntent);
                break;
        }
    }
}
