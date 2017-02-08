import React from "react"
import { connect } from "react-redux"

import { fetchUserProfile } from "../actions/profileActions";

@connect((store) => {
  return {
    userProfile: store.userProfile.userProfile,
  }
})

export default class Profile extends React.Component {
	componentDidMount() {
    this.props.dispatch(fetchUserProfile());
  }

	render() {
		const {userProfile} = this.props;
		let reviewsList = [];
		let itemsList = [];
		if (typeof userProfile.revList !== 'undefined') {
			reviewsList = userProfile.revList.map(
				review => 
					<li>
						<div>
							<div>
		            {review.descrReview}
		          </div>

							<div className="ratingBarWrapperProfile">
		            <div className="ratingBarProfile">
			            <div className="ratingBarClickableProfile">
	                  <span className="glyphicon glyphicon-star" ></span>
	                  <span className="glyphicon glyphicon-star" ></span>
	                  <span className="glyphicon glyphicon-star" ></span>
	                  <span className="glyphicon glyphicon-star" ></span>
	                  <span className="glyphicon glyphicon-star" ></span>
	                </div>
	                <div className="ratingBarOverlayProfile" style={{width: (4 / 5 * 100).toString() + '%'}}>
	                  <div className="ratingBarOverlayInnerProfile">
	                    <span className="glyphicon glyphicon-star"></span>
	                    <span className="glyphicon glyphicon-star"></span>
	                    <span className="glyphicon glyphicon-star"></span>
	                    <span className="glyphicon glyphicon-star"></span>
	                    <span className="glyphicon glyphicon-star"></span>
	                  </div>
	                </div>
	              </div> 

	              <div className="noVotesProfile">
	                {'0 voturi (' + review.points + ' Puncte)'} 
	              </div>
            	</div>
						</div>
					</li>
			);		
		}

		if (typeof userProfile.itemList !== 'undefined') {
			itemsList = userProfile.itemList.map(
				item => 
					<li>
						<div>
							<div>
				           {item.name}
				         </div>
							<div>
				           {item.price} Puncte
				         </div>
							<div>
				           {new Date(item.purchaseDate).toUTCString()}
				         </div>
						</div>
					</li>
			);		
		}

		return (
			<div>
				<div className="page-header">
	        <h1>{userProfile.name}</h1>

	        <div>
	        	<span><i>{userProfile.noPoints} Puncte</i></span>
	        </div>
	      </div>

	      <div>
	      	<h2>Reviews</h2>
	      	<ul className="profileReviews">{reviewsList}</ul>
	      </div>

	      <div>
	      	<h2>Purchased Items</h2>
	      	<ul>{itemsList}</ul>
	      </div>

      </div>
		)
	}
}