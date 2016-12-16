export function fetchShows() {
  return function(dispatch) {
    dispatch({
      type: 'FETCH_SHOWS', 
      payload: response.data
    });
  }
}

export function fetchSingleShow(id) {
	return {
		type: 'FETCH_SHOW',
		payload: id
	};
}