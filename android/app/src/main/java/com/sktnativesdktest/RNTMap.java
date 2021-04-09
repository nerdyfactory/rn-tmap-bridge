package com.sktnativesdktest;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.skt.Tmap.*;
public class RNTMap extends ReactContextBaseJavaModule {

  private static final String REACT_CLASS = "RNTMap";
  ReactApplicationContext mCallerContext;

  private TMapView mMapView = null;
  TMapGpsManager gps = null;

  RNTMap(ReactApplicationContext context) {
    super(context);
    this.mMapView =  new TMapView(mCallerContext);
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
    this.mMapView.setCenterPoint(lng,lat);
  }

  @ReactMethod
  public void search(String searchInput) {
  }
}
