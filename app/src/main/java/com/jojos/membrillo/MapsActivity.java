package com.jojos.membrillo;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jojos.membrillo.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
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


        LatLng tokyo = new LatLng(35.6828387, 139.7594549);
        mMap.addMarker(new MarkerOptions().position(tokyo).title("Tokyo, Japon").snippet("Aqui es donde los Crusaders comienzan su viaje"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tokyo));

        LatLng hong_kong = new LatLng(22.2793278, 114.1628131);
        mMap.addMarker(new MarkerOptions().position(hong_kong).title("Hong Kong, China"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hong_kong));

        LatLng singapur = new LatLng(1.357107, 103.8194992);
        mMap.addMarker(new MarkerOptions().position(singapur).title("Singapur"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(singapur));

        LatLng calcuta = new LatLng(22.5726723, 88.3638815);
        mMap.addMarker(new MarkerOptions().position(calcuta).title("Calcuta, Bengala Occidental, India"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(calcuta));

        LatLng karachi = new LatLng(24.8546842, 67.0207055);
        mMap.addMarker(new MarkerOptions().position(karachi).title("Karachi, Sind, Pakistán"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(karachi));

        LatLng riyadh = new LatLng(24.638916, 46.7160104);
        mMap.addMarker(new MarkerOptions().position(riyadh).title("Riad, Provincia de Riad, Arabia Saudita"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(riyadh));

        LatLng abu = new LatLng(22.3370866, 31.6258054);
        mMap.addMarker(new MarkerOptions().position(abu).title("Calle del Templo, Ciudad de Abu Simbel, 81525, Egipto"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(abu));

        LatLng cairo = new LatLng(30.0443879, 31.2357257);
        mMap.addMarker(new MarkerOptions().position(cairo).title("El Cairo, Egipto").snippet("Aqui es donde los Crusaders terminan su viaje hacia Egipto en busca de DIO"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cairo));
    }
}