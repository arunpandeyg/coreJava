import React, { useState } from 'react';
import axios from 'axios';

import './App.css';
const getImage = () => {
  console.log("image shared");
}

function App() {
  
  return (
    <>
      <div className="App my-2">
        <img src="https://picsum.photos/500/300" alt="" /> <br />
        <button className="btn btn-primary" onClick={getImage}>
          Get Image
        </button>
      </div>
    </>
  );
};



export default App;
