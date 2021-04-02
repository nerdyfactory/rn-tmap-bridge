import React, {useState, useCallback} from 'react';
import {StyleSheet, TextInput} from 'react-native';
import {useSafeAreaInsets} from 'react-native-safe-area-context';

export default function SearchInput({handleSearch}) {
  const {top} = useSafeAreaInsets();
  const [searchValue, setSearchValue] = useState('');

  const search = useCallback(() => {
    handleSearch(searchValue);
  }, [handleSearch, searchValue]);

  return (
    <TextInput
      style={{...styles.search, marginTop: top}}
      placeholder="Search"
      onChangeText={setSearchValue}
      value={searchValue}
      onEndEditing={search}
    />
  );
}

const styles = StyleSheet.create({
  search: {
    fontSize: 18,
    paddingLeft: 15,
    position: 'absolute',
    top: 5,
    left: 10,
    right: 10,
    borderRadius: 5,
    backgroundColor: 'white',
    height: 50,
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
  },
});
