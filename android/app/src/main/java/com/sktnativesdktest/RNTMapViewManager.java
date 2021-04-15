package com.sktnativesdktest;

import android.app.Activity;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;
import com.skt.Tmap.TMapTapi;
import com.skt.Tmap.TMapView;

public class RNTMapViewManager extends SimpleViewManager<TMapView> {

    public static final String REACT_CLASS = "RNTMap";
    private static String APIKEY = "l7xx9d4d587fe7104a57b8feda886c846d1f";
    ReactApplicationContext mCallerContext;
    private TMapView _mapView;

    public RNTMapViewManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    /**
     * Subclasses should return a new View instance of the proper type.
     *
     * @param reactContext
     */
    @NonNull
    @Override
    protected TMapView createViewInstance(@NonNull ThemedReactContext reactContext) {
        _mapView = MainActivity.getTMap();
        return _mapView;
    }

    @ReactProp(name = "appKey")
    public void setAppKey(TMapView view, @Nullable String appKey) {
        view.setSKTMapApiKey(appKey);
    }

    @ReactProp(name = "lat", defaultDouble = 126.988205)
    public void setLatitude(TMapView view, double lat) {

    }

    @ReactProp(name = "lng", defaultDouble = 126.988205)
    public void setLongitude(TMapView view, @Nullable double lng) {

    }
}