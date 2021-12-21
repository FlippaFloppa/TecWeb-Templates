'use strict';

class Lancio extends React.Component {

    render() {


        return (
            <div className="lancio">
                Lancia il dado: <br></br>

                <button type="button" value="click" onClick={this.props.handleSubmit}>Lancia</button>
                <br></br>
                <input type="text" id="dado1" name="dado1" disabled="yes"></input>
                <br></br>
                <input type="text" id="dado2" name="dado2" disabled="yes"></input>
                <br></br>

            </div>
        );
    }

}