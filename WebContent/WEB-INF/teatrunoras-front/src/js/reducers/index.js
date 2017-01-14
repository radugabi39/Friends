import { combineReducers } from "redux"

import shows from "./showsReducer"
import reviews from "./reviewsReducer"
import auth from "./auth"

export default combineReducers({
  shows, reviews, auth
})
