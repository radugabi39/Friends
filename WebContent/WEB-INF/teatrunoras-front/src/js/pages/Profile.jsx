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
	                <div className="ratingBarOverlayProfile" style={{width: (review.rating / 5 * 100).toString() + '%'}}>
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
	                {review.noVotes ? review.noVotes + ' voturi (' : '0 voturi ('}{review.points ? review.points + ' Puncte acumulate)' : '0 Puncte acumulate)'} 
	              </div>
            	</div>
						</div>
					</li>
			);		
		}

		if (typeof userProfile.itemList !== 'undefined') {
			itemsList = userProfile.itemList.map(
				item => 
					<tr>
			      <td>{item.name}</td>
			      <td>{item.price}</td>
			      <td>{new Date(item.purchaseDate).toUTCString()}</td>
			    </tr>
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
	      	<h2>Recenzii</h2>
	      	<ul className="profileReviews">{reviewsList}</ul>
	      </div>

	      <div>
	      	<h2>Comenzi</h2>
	      	<table class="table table-sm table-striped table-hover">
					  <thead>
					    <tr>
					      <th>Nume produs</th>
					      <th>Puncte</th>
					      <th>Data cumpararii</th>
					    </tr>
					  </thead>
					  <tbody>{itemsList}</tbody>
					</table>
	      	<ul></ul>
	      </div>

      </div>
		)
	}
}