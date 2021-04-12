package com.sktnativesdktest;

import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.skt.Tmap.*;

public class RNTMap extends SimpleViewManager<TMapView> {

  public static final String REACT_CLASS = "RNTMap";
  ReactApplicationContext mCallerContext;

  public RNTMap(ReactApplicationContext reactContext) {
    this.mCallerContext = reactContext;
  }

  @NonNull
  @Override
  protected TMapView createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new TMapView(reactContext, 37.570841, 126.988205, 16);
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @ReactProp(name = "appKey")
  public void setAppKey(TMapView view, @Nullable String appKey) {
    view.setSKTMapApiKey(appKey);
  }

  @ReactProp(name = "lat", defaultDouble = 126.988205)
  public void setLatitude(TMapView view, double lat) {
    view.setCenterPoint(view.getLongitude(), lat);
  }

  @ReactProp(name = "lng", defaultDouble = 126.988205)
  public void setLongitude(TMapView view, @Nullable double lng) {
    view.setCenterPoint(lng, view.getLatitude());
  }
}
