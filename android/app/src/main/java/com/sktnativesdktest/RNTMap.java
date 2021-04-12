package com.sktnativesdktest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.skt.Tmap.TMapView;

public class RNTMap extends SimpleViewManager<TMapView> {

  public static final String REACT_CLASS = "RNTMap";
  ReactApplicationContext mCallerContext;

  public RNTMap(ReactApplicationContext reactContext) {
    this.mCallerContext = reactContext;
  }

  @NonNull
  @Override
  protected TMapView createViewInstance(@NonNull ThemedReactContext reactContext) {
    try {
      TMapView tMapView = new TMapView(reactContext, 37.570841, 126.988205, 16);
      tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
      tMapView.setSKTMapApiKey("l7xx9d4d587fe7104a57b8feda886c846d1f");
      tMapView.setHttpsMode(false);
      tMapView.initView();
      return tMapView;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @ReactProp(name = "appKey")
  public void setAppKey(TMapView view, @Nullable String appKey) {
    if (view != null) {
      view = new TMapView(this.mCallerContext, 37.570841, 126.988205, 16);
    }
    view.setSKTMapApiKey(appKey);
  }

  @ReactProp(name = "lat", defaultDouble = 126.988205)
  public void setLatitude(TMapView view, double lat) {
    if (view != null) {
      view = new TMapView(this.mCallerContext, 37.570841, 126.988205, 16);
    }
    view.setCenterPoint(view.getLongitude(), lat);
  }

  @ReactProp(name = "lng", defaultDouble = 126.988205)
  public void setLongitude(TMapView view, @Nullable double lng) {
    if (view != null) {
      view = new TMapView(this.mCallerContext, 37.570841, 126.988205, 16);
    }
    view.setCenterPoint(lng, view.getLatitude());
  }
}
