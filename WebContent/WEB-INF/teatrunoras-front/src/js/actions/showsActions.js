import axios from "axios";

export function fetchShows() {
  return function(dispatch) {
    axios.get("http://localhost:8081/Friends/shows/getAllShows")
      .then((response) => {
        dispatch({type: "FETCH_SHOWS_FULFILLED", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_SHOWS_REJECTED", payload: err})
      })
  }
}

export function fetchSingleShow(id) {
  return function(dispatch) {
    axios.get("http://localhost:8081/Friends/shows/getShowById/" + id)
      .then((response) => {
        dispatch({type: "FETCH_SINGLE_SHOW_FULFILLED", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_SINGLE_SHOW_REJECTED", payload: err})
      })
  }
}

export function fetchShowsByCreationDate() {
  return function(dispatch) {
    axios.get("http://localhost:8081/Friends/shows/getShowsOrderByCreationDate")
      .then((response) => {
        dispatch({type: "FETCH_SHOWS_BY_ORDER_FULFILLED", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_SHOWS_BY_ORDER_REJECTED", payload: err})
      })
  }
}

export function fetchShowsByReviews() {
  return function(dispatch) {
    axios.get("http://localhost:8081/Friends/shows/getShowsOrderByReviews")
      .then((response) => {
        dispatch({type: "FETCH_SHOWS_BY_REVIEWS_FULFILLED", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_SHOWS_BY_REVIEWS_REJECTED", payload: err})
      })
  }
}