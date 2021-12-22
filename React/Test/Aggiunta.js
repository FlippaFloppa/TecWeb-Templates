class Aggiunta extends React.Component {
    constructor(props) {
        super(props);
    }
    render(){
        return (
            <div>
            <h3>Inserisci un nuovo elemento:</h3>
            <input type="text" id="nome" name="nome"/>
            <br/>
            <br/>
            <input type="text" id="cognome" name="cognome"/>
            <br/>
            <br/>
            <input type="text" id="telefono" name="telefono"/>
            <br/>
            <br/>

            <button type="button" value="click" onClick={this.props.aggiungi}>aggiungi</button>
            </div>
        )
    }
}