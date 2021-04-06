import React, {useState, useCallback} from 'react';
import {StyleSheet, TextInput} from 'react-native';

export default function SearchInput({handleSearch}) {
  const [searchValue, setSearchValue] = useState('');

  const search = useCallback(() => {
    handleSearch(searchValue);
  }, [handleSearch, searchValue]);

  const handleKeyPress = useCallback(
    (nativeEvent) => {
      if (nativeEvent?.key === 'Enter') {
        search();
      }
    },
    [search],
  );

  return (
    <TextInput
      style={{...styles.search}}
      placeholder="Search"
      onChangeText={setSearchValue}
      onEndEditing={search}
      onBlur={search}
      onKeyPress={handleKeyPress}
      value={searchValue}
      blurOnSubmit
      enablesReturnKeyAutomatically
    />
  );
}

const styles = StyleSheet.create({
  search: {
    fontSize: 18,
    paddingLeft: 15,
    position: 'absolute',
    top: 50,
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
