package com.fatimamostafa.animationsntransitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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
                "View Animation with XML",
                "View Animation with Java"
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
                Intent intent = new Intent(this, ViewAnimation.class);
                startActivity(intent);
                break;
        }
    }
}
