package prom.jhsmile.com.promapp.promotion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import prom.jhsmile.com.promapp.R;
import prom.jhsmile.com.promapp.model.ProductOfert;

public class DetailActivity extends AppCompatActivity {
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Gson gson = new Gson();
        Intent intent = getIntent();
        if (intent.hasExtra("data")) {

            String datas = intent.getStringExtra("data");
            ProductOfert productOfert = gson.fromJson(datas, ProductOfert.class);
            TextView textView = (TextView)findViewById(R.id.titledetail);
            TextView textDescription = (TextView)findViewById(R.id.description);
            ImageView imageView = (ImageView)findViewById(R.id.image);
            TextView textPhone = (TextView)findViewById(R.id.phone);
            TextView textDirection = (TextView)findViewById(R.id.direction);

            textView.setText(productOfert.getTitle());
            textDescription.setText(productOfert.getDescription());
            Glide.with(this).load(productOfert.getImageUrl())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);

            textPhone.setText("Teléfono: " + productOfert.getPhone());
            textDirection.setText("Dirección: " + productOfert.getDirection());

        }

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }


}

