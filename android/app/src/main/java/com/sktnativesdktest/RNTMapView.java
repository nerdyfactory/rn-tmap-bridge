package com.sktnativesdktest;

import android.content.Context;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapView;

public class RNTMapView extends LinearLayout {
    private Context context;
    private static TMapView _mapView;

    public RNTMapView(Context context, TMapView tMap) {
        super(context);
        this.context = context;
        this._mapView = tMap;
        this.addView(tMap);
    }

    public void init() {
        inflate(context, R.layout.tmap_view, this);
    }
}
