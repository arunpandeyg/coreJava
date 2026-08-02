import React from "react";
import { FacebookButton, FacebookCount } from "react-social";

 
export default function App() {
  
    let url = "https://picsum.photos/500/300";
 
    return (
      <div className="App">
        <FacebookButton url={url} appId={996130918404977}>
          <FacebookCount url={url} />
          {" Share " + url}
        </FacebookButton>
      </div>
    );
  
}