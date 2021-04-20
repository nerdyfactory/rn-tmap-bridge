package com.sktnativesdktest;

import android.os.Looper;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RNTMapPackage implements ReactPackage {

    private TMapView _mapView;
    private static String APIKEY = "l7xx9d4d587fe7104a57b8feda886c846d1f";

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new RNTMapViewManager(reactContext, _mapView)
        );
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        Looper.prepare();
        _mapView = new TMapView(reactContext);
        _mapView.setCenterPoint(126.988205, 37.551135);
        _mapView.setSKTMapApiKey(APIKEY);
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new RNTMapModule(reactContext, _mapView));
        return modules;
    }
}
