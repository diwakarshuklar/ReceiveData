
# react-native-receive-data

## Note
Only Android supported for now, we will try to support ios too very soon.

## Getting started

`$ npm install react-native-receive-data --save`

### Mostly automatic installation

`$ react-native link react-native-receive-data`

### Manual installation

<!-- 
#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-receive-data` and add `RNReceiveData.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReceiveData.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`) -->

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReceiveDataPackage;` to the imports at the top of the file
  - Add `new RNReceiveDataPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-receive-data'
  	project(':react-native-receive-data').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-receive-data/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-receive-data')
  	```

## Setup for new Activity to open (Required)
1. create a file `/android/app/src/main/java/com/[project_name]/receive/ReceiveActivity.java` with content as bellow

  ```package com.demo.receive; // Your package name here

  import com.facebook.react.ReactActivity;

  public class ReceiveActivity extends ReactActivity {
      @Override
      protected String getMainComponentName() {
          return "receive"; // this will be Component name to register using React Native
      }
  }
  ```

2. create a file `/android/app/src/main/java/com/[project_name]/receive/ReceiveApplication` with content as bellow

  ```
  package com.demo.receive; // Your package Name here

  import com.demo.BuildConfig; // Take from Your Package
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
  ```

3. Open AndroidManifest.xml and update 
  
    ```
    <application>
    ...
    <activity android:name=".receive.ReceiveActivity" >
          <intent-filter>
              <action android:name="android.intent.action.SEND" />
              <category android:name="android.intent.category.DEFAULT" />
              <data android:mimeType="application/pdf" />
          </intent-filter>
      </activity>
    </application>
  ```

## Usage

index.js

```javascript
  import { AppRegistry } from 'react-native';
  import App from './App';
  import ReceiveData from './Receive';

  AppRegistry.registerComponent('demo', () => App);
  AppRegistry.registerComponent('receive', ()=> ReceiveData);
```

Recive.js

```javascript
import React, { Component } from 'react';
import {
  Text,
  View
} from 'react-native';
import RNReceive from 'react-native-receive-data';

type Props = {};
export default class App extends Component<Props> {

    state = { type : '', uri: '' };

    async componentDidMount() {
        const {type, uri} = await RNReceive.data();
        this.setState({type, uri});
    }

  render() {
      const { type, uri } = this.state;
    return (
      <View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
        <Text>{type}</Text>
        <Text>{uri}</Text>
      </View>
    );
  }
}
```
  