package com.receive;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import android.graphics.Bitmap;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;


public class RNReceiveDataModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNReceiveDataModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNReceiveData";
  }

  @ReactMethod
  public void close() {
    getCurrentActivity().finish();
  }

  @ReactMethod
  public void data(Promise promise) {
    promise.resolve(processIntent());
  }

  private WritableMap processIntent () {
    WritableMap map = Arguments.createMap();
    String type = "", value = "";

    Activity currentActivity = getCurrentActivity();
    if (currentActivity != null) {
      Intent intent = currentActivity.getIntent();
      String action = intent.getAction();
      type = intent.getType();

      if (Intent.ACTION_SEND.equals(action) && type != null) {
        Uri uri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (uri != null) {
          value = uri.toString();
        }
      } 
    }
    map.putString("type", type);
    map.putString("uri", value);
    return map;
  }

  private String getUri(Intent intent) {
    Uri fileUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
    if (fileUri != null) {
      return fileUri.toString();
    }

    return "";
  }
}