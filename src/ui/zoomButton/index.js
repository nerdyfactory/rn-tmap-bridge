import React from 'react';
import PropTypes from 'prop-types';
import {Text, TouchableOpacity} from 'react-native';

const ZoomButton = ({onZoom, label}) => {
  return (
    <TouchableOpacity activeOpacity={0.9} onPress={onZoom}>
      <Text>{label}</Text>
    </TouchableOpacity>
  );
};

export default ZoomButton;

ZoomButton.propTypes = {
  onZoom: PropTypes.func.isRequired,
  label: PropTypes.string.isRequired,
};
