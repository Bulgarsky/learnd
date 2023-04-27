import logo from './logo.svg';
import './App.css';

function App() {

  //axios.get(process.env.REACT_APP_ENV_FILE)
  const array = [
    {
      name: 'shell',
      value: process.env.REACT_APP_SHELL || 'Нет данных shell'
    },
    {
      name: 'env',
      value: process.env.REACT_APP_ENV_FILE || 'Нет данных env'
    },
    {
      name: 'localpath',
      value: process.env.REACT_APP_LOCAL_PATH || 'Нет данных localpath'
    }
  ]


  return (
      <div>
        {
          array.map(({name, value}, index) =>(
              <div>
                <p>
                  <b>
                    index: [{index+1}]
                  </b>
                  <b>
                    {' '} name: [{name}]
                  </b>
                  <b>
                    {' '} value: [{value}]
                  </b>

                </p>
              </div>
          ))
        }
      </div>
  );
}

export default App;
