package com.demo.receive;

import com.demo.BuildConfig;
import com.reactlibrary.RNReceiveDataPackage;

import android.app.Application;

import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactPackage;

import java.util.Arrays;
import java.util.List;


public class ReceiveApplication extends Application implements ReactApplication {
 private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
   @Override
   public boolean getUseDeveloperSupport() {
     return BuildConfig.DEBUG;

   }

   @Override
   protected List<ReactPackage> getPackages() {
     return Arrays.<ReactPackage>asList(
         new MainReactPackage(),
         new RNReceiveDataPackage()
     );
   }
 };

 @Override
 public ReactNativeHost getReactNativeHost() {
     return mReactNativeHost;
 }
}

