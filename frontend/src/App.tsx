import React,{useState} from 'react';
import Axios from 'axios'
import logo from './logo.svg';
import './App.css';

function App() {

  const [contents, setContents]=useState([])

  const getContents = async () => {
    const getValuesCall = "http://localhost:8080/contents";
    const response = await Axios(getValuesCall);
    setContents(response.data);
}

  return (
    <div className="App">
      <header className="App-header">
        <p>
          Choose game mode.
        </p>
        <button onClick={getContents}>Polish to Portuguese translation</button>
        <button onClick={getContents}>Portuguese to Polish translation</button>
        {/* <div>
          <h4>{JSON.stringify(contents['_embedded']['contents'])}</h4>
        </div> */}
      </header>
    </div>
  );
}

export default App;
