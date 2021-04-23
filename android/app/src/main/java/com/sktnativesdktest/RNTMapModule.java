package com.sktnativesdktest;

import android.graphics.PointF;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPOIItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapTapi;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class RNTMapModule extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "RNTMapAndroidController";
    private TMapTapi apiManager;
    private TMapView _mapView;

    RNTMapModule(ReactApplicationContext context, TMapView tMap, TMapTapi mapApi) {
        super(context);
        _mapView = tMap;
        apiManager = mapApi;
        apiManager.invokeTmap();
        System.out.println("URL >>>>" + apiManager.isTmapApplicationInstalled());
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

    @ReactMethod
    public void handleOnPress() {

    }

    @ReactMethod
    public void handleSearch(String searchInput) {
        apiManager.invokeSearchPortal(searchInput);
    }
}
