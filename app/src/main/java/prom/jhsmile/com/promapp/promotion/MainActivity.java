package prom.jhsmile.com.promapp.promotion;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import prom.jhsmile.com.promapp.R;
import prom.jhsmile.com.promapp.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.vp);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CatalogFragment(), getString(R.string.promotion));
        adapter.addFragment(new PromotionMapsActivity(), getString(R.string.place));

        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setupWithViewPager(viewPager);

    }

}
