export function fetchShows() {
  return function(dispatch) {
    dispatch({
      type: 'FETCH_SHOWS', 
      payload: response.data
    });
  }
}