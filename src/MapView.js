import PropTypes from 'prop-types';
import React, {Fragment, useCallback, useEffect} from 'react';
import {
  NativeModules,
  Platform,
  requireNativeComponent,
  StyleSheet,
  View,
} from 'react-native';
import SearchInput from './ui/searchInput';
import ZoomButton from './ui/zoomButton';

const {RNTMap: TMap, RNTMapAndroidController: TMapAndroid} = NativeModules;

const IS_IOS = Platform.OS === 'ios';

function MapView(props) {
  const {appKey, lat, lng} = props;

  useEffect(() => {
    if (IS_IOS) {
      setMapKey(appKey);
      if (lat && lng) {
        TMap.setCoordinates(lat, lng);
      }
    }
  });

  useEffect(() => {
    if (lat && lng && IS_IOS) {
      TMap.setCoordinates(lat, lng);
    }
  }, [lat, lng]);

  const setMapKey = useCallback((key) => {
    IS_IOS && TMap.setApiKey(key);
  }, []);

  const handleSearch = useCallback((value) => {
    IS_IOS && TMap.search(value || '');
  }, []);

  const zoomIn = useCallback(() => {
    IS_IOS ? TMap.zoomIn() : TMapAndroid.zoomIn();
  }, []);

  const zoomOut = useCallback(() => {
    IS_IOS ? TMap.zoomOut() : TMapAndroid.zoomOut();
  }, []);

  return (
    <Fragment>
      <RNTMap {...props} />
      <SearchInput handleSearch={handleSearch} />
      <View style={styles.zoomWrapper}>
        <ZoomButton label="+" onZoom={zoomIn} />
        <ZoomButton label="-" onZoom={zoomOut} />
      </View>
    </Fragment>
  );
}

MapView.propTypes = {
  appKey: PropTypes.string.isRequired,
  lat: PropTypes.number.isRequired,
  lng: PropTypes.number.isRequired,
};

const styles = StyleSheet.create({
  zoomWrapper: {
    position: 'absolute',
    bottom: 20,
    right: 20,
    width: 50,
    height: 90,
    justifyContent: 'space-evenly',
  },
});

const RNTMap = requireNativeComponent('RNTMap', MapView);

export default MapView;
