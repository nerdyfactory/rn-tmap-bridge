/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React from 'react';
import {StyleSheet, StatusBar} from 'react-native';
import MapView from './src/MapView';

import {Colors} from 'react-native/Libraries/NewAppScreen';

const App = () => {
  return (
    <>
      <StatusBar barStyle="dark-content" />
      <MapView
        appKey="l7xx9d4d587fe7104a57b8feda886c846d1f"
        style={styles.map}
        lat={48.577741}
        lng={27.602706}
      />
    </>
  );
};

const styles = StyleSheet.create({
  map: {
    flex: 1,
    backgroundColor: Colors.lighter,
  },
});

export default App;
