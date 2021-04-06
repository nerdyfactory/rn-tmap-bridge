import React from 'react';
import PropTypes from 'prop-types';
import {StyleSheet, Text, TouchableOpacity} from 'react-native';

const ZoomButton = ({onZoom, label}) => {
  return (
    <TouchableOpacity
      style={styles.button}
      activeOpacity={0.9}
      onPress={onZoom}>
      <Text style={styles.text}>{label}</Text>
    </TouchableOpacity>
  );
};

export default ZoomButton;

ZoomButton.propTypes = {
  onZoom: PropTypes.func.isRequired,
  label: PropTypes.string.isRequired,
};

const styles = StyleSheet.create({
  button: {
    borderRadius: 5,
    backgroundColor: 'white',
    height: 40,
    width: 40,
    alignSelf: 'center',
    zIndex: 2,
    color: 'grey',
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    elevation: 5,
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    fontSize: 30,
  },
});
