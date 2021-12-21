class Article extends React.Component {
    constructor(props) {
        super(props);
        this.state = { value: 0 };
    }
    inc(){
        this.setState({value: eval(this.state.value)+1})
    }
    render(){
        return (
            <div>
            <h3>Valore: {this.state.value}</h3>
            <input type="text" id="test" name="test" disabled="yes"></input>
            <button type="button" value="click" onClick={this.props.callback}>callback</button>
            </div>
        )
    }
}