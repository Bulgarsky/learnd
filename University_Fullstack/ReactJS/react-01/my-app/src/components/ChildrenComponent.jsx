import React from 'react'
import logo from '../logo.svg';

const ChildrenComponent = (props) => {
  return (
    <div>
        <h2>{props.text}</h2>
        <img src={logo} style={{width: props.width}} />
    </div>
  )
}

export default ChildrenComponent