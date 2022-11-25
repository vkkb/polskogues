import {useState} from 'react';
import Axios from 'axios'
import './App.css';

function Game(props: any) {
  const [answerIsRevealed, setAnswerIsRevealed] = useState(false)
  const [answer, setAnswer] = useState("")

  const handleAnswer = (event: { target: { value: any; }; }) => {
    const value = event.target.value;
    setAnswer(value);
  };

  return (
  <div>
    <h3>Translate "{props.question}"</h3>
    <input type="text" onChange={handleAnswer}></input>
    <div>
      <button onClick={() => setAnswerIsRevealed(true)}>Submit</button>
    </div>
    <RevealAnswer answerIsRevealed = {answerIsRevealed} 
      solution = {props.solution}
      answer = {answer}>
    </RevealAnswer>
  </div>
  );
}

function RevealAnswer(props: any){
  if (!props.answerIsRevealed){
    return <span></span>;
  }
  if (props.answer == props.solution) {
    return (
      <span>Congrats!</span>
    );
  }
  return (
    <span>False. Try again :)</span>
  );
}

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
        <Game question="oi" solution="czesc"/>
      </header>
    </div>
  );
}

export default App;
