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
export function postReview2() {
	return function(dispatch) {
		const data = new FormData();

		data.append('showId', 1);
		data.append('userId', 1);
		data.append('description', 'Posted Rview');

		axios.post("http://localhost:8081/Friends/review/saveReview", 
			{
				showId: 1,
				userId: 1,
				description: 'Posted rev'
			}, 
			{
				headers: {
					"Content-Type": "application/json",
					"Access-Control-Allow-Origin": "*"
				},
				"params": {
					showId: 1,
					userId: 1,
					description: 'Posted rev'
				}
			})
			.then(function (response) {
			  console.log(response);
			})
		  .catch((err) => {
		    dispatch({type: "POST_REVIEW_REJECTED", payload: err})
		  })
	}
}

export function postReview() {
	return function(dispatch) {
		request
		  .post("http://localhost:8081/Friends/review/saveReview")
		  .send({
		  	showId: 1,
				userId: 1,
				description: 'Posted rev'
		  })
		  .set('ACCEPT', 'application/json')
		  .set('ACCESS-CONTROL-ALLOW-ORIGIN', '*')
		  .end(function(err, res){
		    // Calling the end function will send the request
		  });
	}
}