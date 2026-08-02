import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { loadData } from "../../redux/catRedux/cat.actions";
import { CAT_KEY } from "../../redux/catRedux/cat.reducer";

const CatApp = () => {
  // initialize dispatch
  let dispatch = useDispatch();

  useEffect(() => {
    dispatch(loadData());
  }, [dispatch]);

  // view data from store
  let viewCat = useSelector((state) => {
    return state[CAT_KEY];
  });

  // handle button click
  let handleBtn = () => {
    dispatch(loadData());
  };
  //share socials
  let share = () => {
    console.log("Message and images shared on desired social media app.")
  };

  return (
    <React.Fragment>
      {/* <pre>{JSON.stringify(viewCat)}</pre> */}
      <div className="card">
        <div className="card-header">
          <h5>RANDOM IMAGE VIEW</h5>
        </div>

        {/* body section */}
        <div className="card-body centered">
          <div className="catContainer centered">
            <div className="imgContainer centered">
              {viewCat.data.length === 0 ? null : (
                <React.Fragment>
                  {viewCat.data.map((item) => {
                    return (
                      <div key={item.id}>
                        <img src={item.url} alt="" />
                      </div>
                    );
                  })}
                </React.Fragment>
              )}
            </div>

            <div className="btnContainer">
              <button className="btns" onClick={handleBtn}>
                CAT
              </button>
              <button className="share" onClick={share}>
                SHARE
              </button>
            </div>
          </div>
        </div>
      </div>
    </React.Fragment>
  );
};

export default CatApp;
