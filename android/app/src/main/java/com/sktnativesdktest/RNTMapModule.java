package com.sktnativesdktest;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.skt.Tmap.TMapView;

import java.util.Map;
import java.util.HashMap;

public class RNTMapModule extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "RNTMapAndroidController";
    private TMapView _mapView;

    RNTMapModule(ReactApplicationContext context, TMapView tMap) {
        super(context);
        _mapView = tMap;
    }

    /**
     * @return the name of this module. This will be the name used to {@code require()} this module
     * from javascript.
     */
    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }


    @ReactMethod
    public void zoomIn() {
        _mapView.MapZoomIn();
    }

    @ReactMethod
    public void zoomOut() {
        _mapView.MapZoomOut();
    }
}
