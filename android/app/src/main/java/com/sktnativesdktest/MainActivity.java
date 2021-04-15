package com.sktnativesdktest;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.facebook.react.ReactActivity;
import com.skt.Tmap.TMapView;

public class MainActivity extends ReactActivity {

  private static TMapView _mapView;

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "SktNativeSdkTest";
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tmap_view);
    _mapView = new TMapView(this);
    _mapView.setCenterPoint(126.988205, 37.551135);
    _mapView.setSKTMapApiKey("l7xx9d4d587fe7104a57b8feda886c846d1f");
  }

  public static TMapView getTMap() {
    return _mapView;
  }
}
