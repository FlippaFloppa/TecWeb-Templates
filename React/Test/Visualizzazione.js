class Visualizzazione extends React.Component {
    constructor(props) {
        super(props);
    }
    render(){
        return (
            <div>
           <h2>Risultati:</h2>
           {this.props.result}
            </div>
        )
    }
}