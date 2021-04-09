package com.sktnativesdktest;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.skt.Tmap.*;
public class RNTMap extends ReactContextBaseJavaModule {

  private static final String REACT_CLASS = "RNTMap";
  private TMapView mMapView = null;
  private TMapGpsManager gps = null;

  RNTMap(ReactApplicationContext context) {
    super(context);
    this.mMapView =  new TMapView(context);
    this.gps =  new TMapGpsManager(context);
    this.mMapView.initView();
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @ReactMethod
  public void setApiKey(String key) {
    this.mMapView.setSKTMapApiKey(key);
  }

  @ReactMethod
  public void setHttpsMode(Boolean isActive) {
    this.mMapView.setHttpsMode(isActive);
  }

  @ReactMethod
  public void zoomIn() {
    this.mMapView.MapZoomIn();
  }

  @ReactMethod
  public void zoomOut() {
    this.mMapView.MapZoomOut();
  }

  @ReactMethod
  public void setCoordinates(Double lat, Double lng) {
    this.mMapView.setLocationPoint(lng,lat);
  }

  @ReactMethod
  public void search(String searchInput) {
  }
}
