//rafce
import React from 'react';
import ChildrenComponent from './ChildrenComponent';


const FirstComponent = () => {
  return (
        <div>
        <h1>Первый компонент</h1>
        <p>параграф 1</p>
        <ChildrenComponent text="Текст дочернего компонента" width="200px" /> 
    </div>
  )
}

export default FirstComponent