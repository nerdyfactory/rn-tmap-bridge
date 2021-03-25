import PropTypes from 'prop-types';
import React, {useCallback, useEffect} from 'react';
import {NativeModules, requireNativeComponent} from 'react-native';

const {RNTMap: TMap} = NativeModules;

function MapView(props) {
  const {appKey, lat, lng, marker} = props;

  useEffect(() => {
    setMapKey(appKey);
    if (lat && lng) {
      TMap.setCoordinates(lat, lng);
    }
    if (marker) {
      TMap.setMarker(marker, 'mainMarker');
    }
  });

  useEffect(() => {
    if (lat && lng) {
      TMap.setCoordinates(lat, lng);
    }
  }, [lat, lng]);

  useEffect(() => {
    if (marker) {
      TMap.setMarker(marker, 'mainMarker');
    }
  }, [marker]);

  const setMapKey = useCallback((key) => {
    TMap.setApiKey(key);
  }, []);

  return <RNTMap {...props} />;
}

MapView.propTypes = {
  appKey: PropTypes.string.isRequired,
  lat: PropTypes.number.isRequired,
  lng: PropTypes.number.isRequired,
};

const RNTMap = requireNativeComponent('RNTMap', MapView);

export default MapView;
