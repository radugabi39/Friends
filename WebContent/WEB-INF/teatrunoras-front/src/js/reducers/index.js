import { combineReducers } from "redux"

import shows from "./showsReducer"
import reviews from "./reviewsReducer"
import auth from "./auth"
import userProfile from "./profileReducer"
import items from "./itemsReducer"

export default combineReducers({
  shows, reviews, auth, userProfile, items
})
