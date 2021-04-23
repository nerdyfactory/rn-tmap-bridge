package com.sktnativesdktest;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;

public class RNTMapView extends LinearLayout {
    private Context context;
    private static TMapView _mapView;

    public RNTMapView(Context context, TMapView tMap) {
        super(context);
        this.context = context;
        this._mapView = tMap;
        this._mapView.setOnClickListenerCallBack(new TMapView.OnClickListenerCallback() {
            @Override
            public boolean onPressEvent(ArrayList arrayList, ArrayList arrayList1, TMapPoint tMapPoint, PointF pointF) {
                tMap.setLocationPoint(tMapPoint.getLongitude(), tMapPoint.getLatitude());
                return false;
            }

            @Override
            public boolean onPressUpEvent(ArrayList arrayList, ArrayList arrayList1, TMapPoint tMapPoint, PointF pointF) {
                tMap.setLocationPoint(tMapPoint.getLongitude(), tMapPoint.getLatitude());
                return false;
            }
        });
        this.addView(this._mapView);
    }

    public void init() {
        inflate(context, R.layout.tmap_view, this);
    }


}
