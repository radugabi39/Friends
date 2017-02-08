export default function reducer(state={
    userProfile: {},
  }, action) {

    switch (action.type) {
      case "FETCH_USER_PROFILE_FULFILLED": {
        return {userProfile: action.payload};
      }
    }

  return state;
}
