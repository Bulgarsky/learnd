import logo from './logo.svg';
import './App.css';



function App() {
  return (
    <div className="App">
      <div className='card'>
        <div className='title'>
            <h3>Заголовок</h3>
            <hr/>
            <img src={logo} width="100px"/>
            <hr/>
            <div className='info'>
                Краткое описание
            </div>
        </div>
          <div className='card-info'>
              Текст который повляется
          </div>
          <div class='color-overlay'></div>

      </div>
    </div>
  );
}

export default App;
