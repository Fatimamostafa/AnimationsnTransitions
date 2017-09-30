package com.fatimamostafa.animationsntransitions.transitions.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.fatimamostafa.animationsntransitions.R;
import com.fatimamostafa.animationsntransitions.transitions.crossfade.DataProvider;
import com.fatimamostafa.animationsntransitions.transitions.crossfade.Product;
import com.fatimamostafa.animationsntransitions.transitions.viewpager.transformers.DepthPageTransformer;
import com.fatimamostafa.animationsntransitions.transitions.viewpager.transformers.ZoomPageTransformer;

import java.util.List;

public class ViewpagerActivity extends AppCompatActivity {

    private final List<Product> products = DataProvider.productList;
    private final int numPages = products.size();
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);

        mPager.setPageTransformer(true, new DepthPageTransformer()); // true value reverse the drawing order in animation

        //another transformation animation
        mPager.setPageTransformer(true, new ZoomPageTransformer());

        PagerAdapter mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private static final String TAG = "Adapter";

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ItemFragment.create(products.get(position));
        }

        @Override
        public int getCount() {
            return numPages;
        }
    }
}
