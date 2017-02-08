import axios from "axios";

export function fetchUserProfile() {
  return function(dispatch) {
    axios.get("http://localhost:8081/Friends/user/getUserProfile")
      .then((response) => {
        dispatch({type: "FETCH_USER_PROFILE_FULFILLED", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_USER_PROFILE_REJECTED", payload: err})
      })
  }
}