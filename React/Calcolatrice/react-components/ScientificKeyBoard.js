'use strict';

class ScientificKeyBoard extends React.Component {

    render() {
        return (
            <div className="keypad">
				<hr/>
                <button name="log_e" onClick={this.props.onClick}>log<sub>e</sub>(x)</button>
                <button name="sqrt" onClick={this.props.onClick}>sqrt(x)<sub></sub></button>
                <button name="e_x" onClick={this.props.onClick}>e<sub>x</sub></button>
                <button name="1/x" onClick={this.props.onClick}>1/x<sub></sub></button>
            </div>
        );
    }
}
