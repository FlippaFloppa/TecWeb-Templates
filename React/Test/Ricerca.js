class Ricerca extends React.Component {
    constructor(props) {
        super(props);
        this.state = { value: 0 };
    }
    render() {
        return (
            <div>
                <h2>Inserisci elemento da cercare:</h2>
              <input type="text" id="ricerca" name="ricerca"/>
              <button type="button" value="click" onClick={this.props.cerca}>cerca</button>
            </div>)
    }
}