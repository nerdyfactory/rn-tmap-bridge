import React from 'react';
import {StyleSheet, TextInput} from 'react-native';

export default function SearchInput({handleSearch}) {
  return <TextInput style={styles.search} onChangeText={handleSearch} />;
}

const styles = StyleSheet.create({
  search: {
    width: '90%',
    height: 75,
  },
});
