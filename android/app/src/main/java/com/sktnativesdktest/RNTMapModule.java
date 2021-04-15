package com.sktnativesdktest;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;

public class RNTMapModule extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "RNTMap";

    RNTMapModule(ReactApplicationContext context) {
        super(context);
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
}
