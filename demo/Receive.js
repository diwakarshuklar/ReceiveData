/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

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
