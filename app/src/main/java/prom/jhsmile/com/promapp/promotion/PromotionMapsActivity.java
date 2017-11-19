package prom.jhsmile.com.promapp.promotion;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.ArrayList;

import prom.jhsmile.com.promapp.R;
import prom.jhsmile.com.promapp.model.ProductOfert;
import prom.jhsmile.com.promapp.service.EndPointApi;
import prom.jhsmile.com.promapp.service.RestApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PromotionMapsActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView;
    public PromotionMapsActivity() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_promotion_maps, container, false);
        mapView = (MapView) v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapView.getMapAsync(this);

        return v;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApi service = restApiAdapter.connexionToApi();

        Call<ArrayList<ProductOfert>> requesCatalogo = service.getList();

        requesCatalogo.enqueue(new Callback<ArrayList<ProductOfert>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductOfert>> call, Response<ArrayList<ProductOfert>> response) {
                System.out.println(new Gson().toJson(response.body()));
                ArrayList<ProductOfert> myDataset = response.body();
                ArrayList<ProductOfert> data = response.body();
                for (ProductOfert item:
                        data) {
                    double lat = Double.valueOf(item.getLatitud()).doubleValue();
                    double lon = Double.valueOf(item.getLongitud()).doubleValue();
                    LatLng latlon = new LatLng(lat, lon);
                    mMap.addMarker(new MarkerOptions()
                            .position(latlon)
                            .title(item.getTitle())
                            .snippet(item.getShortDescription()));

                    CameraPosition cameraPosition = new CameraPosition.Builder().target(latlon).zoom(12).build();
                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                }
            }

            @Override
            public void onFailure(Call<ArrayList<ProductOfert>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }
}
