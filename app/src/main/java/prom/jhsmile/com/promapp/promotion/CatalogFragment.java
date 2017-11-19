package prom.jhsmile.com.promapp.promotion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import prom.jhsmile.com.promapp.service.EndPointApi;
import prom.jhsmile.com.promapp.adapter.ProductItemListAdapter;
import prom.jhsmile.com.promapp.model.ProductOfert;
import prom.jhsmile.com.promapp.R;
import prom.jhsmile.com.promapp.service.RestApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jhdev on 11-11-17.
 */

public class CatalogFragment extends Fragment {
    private ArrayList<ProductOfert> myDataset;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    ProductItemListAdapter mAdapter;

    public CatalogFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_catalog, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        loadProducts();
        return v;
    }


    public void loadProducts() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApi service = restApiAdapter.connexionToApi();

        Call<ArrayList<ProductOfert>> requesCatalogo = service.getList();



        requesCatalogo.enqueue(new Callback<ArrayList<ProductOfert>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductOfert>> call, Response<ArrayList<ProductOfert>> response) {
                System.out.println(new Gson().toJson(response.body()));
                myDataset = response.body();
                refreshDataset();
            }

            @Override
            public void onFailure(Call<ArrayList<ProductOfert>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    public void refreshDataset() {
        if (mRecyclerView == null)
            return;

        if (mAdapter == null) {
            mAdapter = new ProductItemListAdapter(getContext(), myDataset);

            //Listener
            mAdapter.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),
                            myDataset.get(mRecyclerView.getChildAdapterPosition(v)).getTitle(),Toast.LENGTH_SHORT).show();
                    Gson gson = new Gson();
                    String productJson = gson.toJson(myDataset.get(mRecyclerView.getChildAdapterPosition(v)));

                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("data", productJson);
                    startActivity(intent);

                }
            });

            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

}
