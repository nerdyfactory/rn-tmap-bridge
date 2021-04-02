import PropTypes from 'prop-types';
import React, {useCallback, useEffect} from 'react';
import {NativeModules, requireNativeComponent, View} from 'react-native';
import SearchInput from './ui/searchInput';
import {SafeAreaProvider} from 'react-native-safe-area-context';
import ZoomButton from './ui/zoomButton';

const {RNTMap: TMap} = NativeModules;

function MapView(props) {
  const {appKey, lat, lng} = props;

  useEffect(() => {
    setMapKey(appKey);
    if (lat && lng) {
      TMap.setCoordinates(lat, lng);
    }
  });

  useEffect(() => {
    if (lat && lng) {
      TMap.setCoordinates(lat, lng);
    }
  }, [lat, lng]);

  const setMapKey = useCallback((key) => {
    TMap.setApiKey(key);
  }, []);

  const handleSearch = useCallback((value) => {
    TMap.searchPlace(value);
  }, []);

  return (
    <SafeAreaProvider style={{flex: 1}}>
      <SearchInput handleSearch={handleSearch} />
      <RNTMap {...props} />
      <ZoomButton label="+" onZoom={TMap.zoomIn} />
      <ZoomButton label="-" onZoom={TMap.zoomOut} />
    </SafeAreaProvider>
  );
}

MapView.propTypes = {
  appKey: PropTypes.string.isRequired,
  lat: PropTypes.number.isRequired,
  lng: PropTypes.number.isRequired,
};

const RNTMap = requireNativeComponent('RNTMap', MapView);

export default MapView;
