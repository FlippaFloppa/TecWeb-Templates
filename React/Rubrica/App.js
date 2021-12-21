class App extends React.Component {
            constructor(props) {
                super(props);
                this.state = { value: 0 };
            }
            myFunction(val) {
                this.setState({ value: val });
            }
            callback(){
                document.getElementById("test").value = 10;  
            }

            render() {
                return (
                    <div>
                        <input type="text" id="input" name="input"></input>
                        <h3>Prezzo: {this.state.value}</h3>
                        <button Articolo onClick={() => this.myFunction(document.getElementById("input").value)}>Set value</button>
                        <Article 
                        callback={this.callback}
                        />
                    </div>
                );
            }
        }
