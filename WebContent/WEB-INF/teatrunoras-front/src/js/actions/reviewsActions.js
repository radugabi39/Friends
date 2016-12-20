import axios from "axios";
import request from "superagent";

export function fetchReviewsForShow(id) {
  return function(dispatch) {
    axios.get("http://localhost:8081/Friends/review/getReviewByShowId/" + id)
      .then((response) => {
        dispatch({type: "FETCH_REVIEWS_FULFILLED", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_REVIEWS_REJECTED", payload: err})
      })
  }
}

// Post Review with axios TO LOOK INTO if I decide to actually use it instead of superagent.
export function postReview(showId, description) {
	return function(dispatch) {
		axios.post("http://localhost:8081/Friends/review/saveReview", 
			{
				showId: showId,
				userId: 1,
				description: description
			}, 
			{
				headers: {
					"Content-Type": "application/json",
					"Access-Control-Allow-Origin": "*"
				}
			})
			.then(function (response) {
			  console.log(response);
			  dispatch({type: "POST_REVIEW_FULFILLED", payload: response.config.data});
			})
		  .catch((err) => {
		    dispatch({type: "POST_REVIEW_REJECTED", payload: err})
		  })
	}
}