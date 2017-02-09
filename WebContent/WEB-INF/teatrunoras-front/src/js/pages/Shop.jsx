import React from "react";
import { connect } from "react-redux";

import { fetchItems } from "../actions/itemsActions";
import { buyItem } from "../actions/itemsActions.js";

@connect((store) => {
  return {
    items: store.items.items,
  }
})

export default class Shop extends React.Component {
	componentDidMount() {
    this.props.dispatch(fetchItems());
  }

  dispatchBuyItem(itemId) {
    if(confirm('Sunteti sigur ca vreti sa achizitionati aceasta oferta?')) {
    	return this.props.dispatch(buyItem(itemId)); 
    }
  }

  render() {
  	const {items} = this.props;
  	let itemsList = [];

  	if (typeof items.list !== 'undefined') {
			itemsList = items.list.map(function(item) {
        if (!item.stock) 
          return null;

        return (
					<div className="col-md-6" key={item.id}>
            <div className="row singleItemContainer" style={{marginBottom: '20px'}}>
              <div className="col-md-4" style={{backgroundImage: 'url(' + item.avatarURL + ')', height: '170px', backgroundSize: 'cover'}} ></div>
              <div className="col-md-8">
                <div className="itemTitle">{item.name}</div>
                <div>{item.description}</div>
                <div>
                  <span className="itemPrice">{item.price} puncte</span>
                  <span className="itemStock">{item.stock} ramase</span>
                </div>
                <div className="buyButton"><span className="btn btn-primary" onClick={(itemId) => this.dispatchBuyItem(item.id)}>Cumpara</span></div>
              </div>
            </div>						
					</div>
        )
      });
		}

    return (
    	<div>
    		<div className="page-header">
	        <h1>Oferte</h1>
	      </div>

	    	<div className="row itemsContainer">{itemsList}</div>
    	</div>
    );
  }
}