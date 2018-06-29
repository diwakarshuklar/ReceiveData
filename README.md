
# react-native-receive-data

## Note
Only Android supported for now, we will try to support ios too very soon.

## Getting started

`$ npm install react-native-receive-data --save`

### Mostly automatic installation

`$ react-native link react-native-receive-data`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-receive-data` and add `RNReceiveData.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReceiveData.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

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


## Usage
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
      <View style={styles.container}>
        <Text>{type}</Text>
        <Text>{uri}</Text>
      </View>
    );
  }
}

// TODO: What to do with the module?
RNReceiveData;
```
  