class App extends React.Component {
            constructor(props) {
                super(props);
                this.state = { value: 0,lista:[], res: "" };
                this.cerca = this.cerca.bind(this);
                this.aggiungi = this.aggiungi.bind(this);
            }

            cerca(){
                var cognome=document.getElementById("ricerca").value;
                console.log(cognome);
                var cognomi=[];
                for(var i=0; i<this.state.lista.length; i++){
                    if(this.state.lista[i]===cognome){
                        cognomi.concat(cognome);
                        this.setState({ res: this.state.res+=" "+cognome });
                    }
                    }

                }

            aggiungi(){
                var nome=document.getElementById("nome").value;  
                var cognome=document.getElementById("cognome").value;  
                var telefono=document.getElementById("telefono").value;  
                console.log(nome,cognome,telefono);
                if(nome===""||cognome===""||telefono===""){
                    alert("Inserisci informazioni!");
                }else{
                    this.setState({ lista: this.state.lista.concat(cognome) });
                }
            }

            render() {
                return (
                    <div>
                        <h2>Rubrica</h2>
                        <Aggiunta
                        aggiungi={this.aggiungi}
                        />
                        <Ricerca
                        cerca={this.cerca}
                        />
                        <Visualizzazione
                        result={this.state.res}
                        />
                    </div>
                );
            }
        }
