'use strict';

class Statistica extends React.Component {

    render() {


        return (
            <div className="statistica">
                <br></br><br></br>
                Lancia il dado: <br></br>

                <button type="button" value="click" onClick={this.props.handleSubmit}>Calcola</button>
                <br></br>
                <input type="text" id="big" name="big" disabled="yes"></input>
                <br></br>
                <input type="text" id="small" name="small" disabled="yes"></input>
                <br></br>
                <input type="text" id="media" name="media" disabled="yes"></input>
                <br></br>
                <button type="button" value="click" onClick={this.props.destroy}>Destroy</button>
                <br></br>

            </div>
        );
    }

}