package com.sktnativesdktest;

import android.app.Activity;
import android.graphics.PointF;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapTapi;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;
import java.util.Map;

public class RNTMapViewManager extends SimpleViewManager<RNTMapView> {

    public static final String REACT_CLASS = "RNTMap";
    private static String APIKEY = "l7xx9d4d587fe7104a57b8feda886c846d1f";
    ReactApplicationContext mCallerContext;
    private TMapView _mapView;

    public RNTMapViewManager(ReactApplicationContext reactContext, TMapView tmap) {
        mCallerContext = reactContext;
        _mapView = tmap;
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
    protected RNTMapView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new RNTMapView(reactContext, _mapView);
    }

    @ReactProp(name = "appKey")
    public void setAppKey(RNTMapView view, @Nullable String appKey) {
    }

    @ReactProp(name = "lat", defaultDouble = 126.988205)
    public void setLatitude(RNTMapView view, double lat) {
    }

    @ReactProp(name = "lng", defaultDouble = 126.988205)
    public void setLongitude(RNTMapView view, @Nullable double lng) {
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put(
                        "onPressEvent",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onPress")))
                .put(
                        "onPressUpEvent",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onPress")))
                .build();
    }
}