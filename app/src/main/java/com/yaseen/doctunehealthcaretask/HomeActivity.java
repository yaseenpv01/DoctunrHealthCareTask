package com.yaseen.doctunehealthcaretask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements LocationListener {

    Button btnlocation;
    TextView locationTextView;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnlocation=findViewById(R.id.buttonlocation);
        locationTextView=findViewById(R.id.textViewlocation);

        btnlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });


    }

    private void getLocation() {

        try {
            locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5, (LocationListener) this);
        }
        catch (SecurityException e){
            e.printStackTrace();
        }
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        locationTextView.setText("Current Location:"+location.getLatitude()+","+location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {


    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        Toast.makeText(HomeActivity.this,"Please Enable GPS and Internet",Toast.LENGTH_LONG);

    }
}