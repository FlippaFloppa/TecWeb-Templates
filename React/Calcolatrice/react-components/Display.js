'use strict';

class Display extends React.Component {

    render() {
    let result = this.props.result;
    return (
        <div className="result">
        <p>{result}</p>
        </div>
        );
    }
}
