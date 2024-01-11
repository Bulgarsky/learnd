import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'

const isLoading = false;

ReactDOM.createRoot(document.getElementById('root')).render(
  //<React.StrictMode>
    <App isLoading={isLoading} />
  //</React.StrictMode>,
)
