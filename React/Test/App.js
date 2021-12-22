class App extends React.Component {
            constructor(props) {
                super(props);
                this.state = { value: 0, res: "" };
                this.aggiungi = this.aggiungi.bind(this);
            }

            aggiungi(){
                var text=document.getElementById("nome").value;
                this.setState({ res: text});
            }

            render() {
                return (
                    <div>
                        <h2>Rubrica</h2>
                        <Aggiunta
                        aggiungi={this.aggiungi}
                        />
                        <Visualizzazione
                        result={this.state.res}
                        />
                    </div>
                );
            }
        }
