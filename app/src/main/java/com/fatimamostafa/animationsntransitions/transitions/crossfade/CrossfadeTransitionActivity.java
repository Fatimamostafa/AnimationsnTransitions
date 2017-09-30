package com.fatimamostafa.animationsntransitions.transitions.crossfade;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fatimamostafa.animationsntransitions.R;

import java.util.List;

public class CrossfadeTransitionActivity extends AppCompatActivity {

    private static final int MENU_ITEM_LOGOUT = 1001;
    public static final String PRODUCT_ID = "PRODUCT_ID";
    private CoordinatorLayout coordinatorLayout;

    private List<Product> products = DataProvider.productList;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfade_transition);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        ProductListAdapter adapter = new ProductListAdapter(
                this, R.layout.list_item, products);
        ListView lv = (ListView) findViewById(R.id.listView);
        assert lv != null;
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CrossfadeTransitionActivity.this, DetailActivity.class);

                Product product = products.get(position);
                intent.putExtra(PRODUCT_ID, product.getProductId());

                startActivity(intent);
                overridePendingTransition(
                        android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_about:
                startAboutActivity();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void startAboutActivity() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }*/
}
