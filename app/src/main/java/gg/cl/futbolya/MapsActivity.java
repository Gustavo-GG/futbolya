package gg.cl.futbolya;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import gg.cl.futbolya.databinding.ActivityMaps2Binding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap.getUiSettings().setZoomControlsEnabled((true));
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng san_carlos = new LatLng(-36.4248,-71.9581);
        mMap.addMarker(new MarkerOptions().position(san_carlos).title("San Carlos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(san_carlos, 13.0f));

        LatLng los_palacios= new LatLng(-36.423932, -71.940054);
        mMap.addMarker((new MarkerOptions().position(los_palacios).title("Los palacios Soccer")));

        LatLng Badi_soccer= new LatLng(-36.4071972,-71.9603734);
        mMap.addMarker((new MarkerOptions().position(Badi_soccer).title("BadiSoccer")));

        LatLng Donde_martin= new LatLng(-36.438378, -71.945158);
        mMap.addMarker((new MarkerOptions().position(Donde_martin).title("Donde Martin")));

        LatLng cancha_talo= new LatLng(-36.423001, -71.982234);
        mMap.addMarker((new MarkerOptions().position(cancha_talo).title("Cancha Don talo")));

    }
}