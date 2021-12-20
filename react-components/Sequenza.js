'use strict';

class Sequenza extends React.Component {

    render() {

        return (
            <div className="sequenza">
                <br></br>
                <br></br>
                Sono usciti: <br></br>

                <textarea id="usciti" name="usciti" disabled="yes" 
                    rows="4" cols="30" value={this.props.lista}></textarea>
                <br></br>

            </div>
        );
    }

}