import PropTypes from 'prop-types';
import React, {useCallback, useEffect} from 'react';
import {NativeModules, requireNativeComponent} from 'react-native';

const RNTMap = requireNativeComponent('RNTMap', MapView);

const {RNTMap: TMap} = NativeModules;

type Props = {
  appKey: string;
  lat: number;
  lng: number;
};

function MapView(props: Props) {
  const {appKey, lat, lng} = props;

  useEffect(() => {
    setMapKey(appKey);
  });

  useEffect(() => {
    if (lat && lng) {
      TMap.setCoordinates(lat, lng);
    }
  }, [lat, lng]);

  const setMapKey = useCallback((key: string) => {
    TMap.setApiKey(key);
  }, []);

  return <RNTMap />;
}

MapView.propTypes = {
  appKey: PropTypes.string.isRequired,
  lat: PropTypes.number.isRequired,
  lng: PropTypes.number.isRequired,
};

export default MapView;
