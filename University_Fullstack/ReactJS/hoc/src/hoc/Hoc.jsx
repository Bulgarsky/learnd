import React from 'react';

const Hoc = (Component) => {
    return class extends React.Component{

        componentDidUpdate(prevProps, prevState, snapshot) {
            console.log('old props:', prevProps);
            console.log('actual props:', this.props);
        }

        render(){
            return <Component {...this.props} />
        }

    }
}

export default Hoc;