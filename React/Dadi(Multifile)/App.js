'use strict';

class App extends React.Component {
    constructor() {
        super();

        var data = '{"data":[{"name":"Pasta","categoria":"alimentari","price":"2"},{"name":"Acqua","categoria":"alimentari","price":"1"},{"name":"Svelto","categoria":"cucina","price":"5"}]}';
        this.arr = JSON.parse(data);

        this.state = {
            inLista: [],
            fuoriLista: [],
            lista: "",
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.calcolo = this.calcolo.bind(this);
        this.destroy = this.destroy.bind(this);
    }



    handleSubmit(e) {
        var a = Math.floor(Math.random() * 6) + 1;
        var b = Math.floor(Math.random() * 6) + 1;

        document.getElementById("dado1").value = a;
        document.getElementById("dado2").value = b;

        if ((a + b) >= 3 && (a + b) <= 10) {
            this.setState({
                inLista: (this.state.inLista.concat(a)).concat(b),
            }, this.scriviLista);
        }
        else {
            this.setState({
                fuoriLista: (this.state.fuoriLista.concat(a)).concat(b),
            });
        }
    }

    scriviLista() {
        var tmp = "";
        for (var i = 0; i < this.state.inLista.length; i++) {

            if (i % 2 == 0) {
                tmp += ("Dado1: " + this.state.inLista[i]);
            }
            if (i % 2 == 1) {
                tmp += ("-Dado2: " + this.state.inLista[i] + " ");
            }
        }
        this.setState({
            lista: tmp,
        });
    }

    calcolo() {
        var sum1 = 0;

        for (var i = 0; i < this.state.inLista.length / 2; i++) {

            var x = this.state.inLista[i * 2] + this.state.inLista[i * 2 + 1];
            if (x > sum1) sum1 = x;
        }

        var sum2 = 15;

        for (var i = 0; i < this.state.inLista.length / 2; i++) {

            var x = this.state.inLista[i * 2] + this.state.inLista[i * 2 + 1];
            if (x < sum2) sum2 = x;
        }

        var sum3 = 0;

        for (var i = 0; i < this.state.fuoriLista.length; i++) {

            sum3 += this.state.fuoriLista[i];
        }
        sum3 = sum3 / (this.state.fuoriLista.length / 2);

        document.getElementById("big").value = sum1;
        document.getElementById("small").value = sum2;
        document.getElementById("media").value = sum3;

        document.getElementById("dado1").value = "";
        document.getElementById("dado2").value = "";

    }

    destroy() {
        this.setState({
            inLista: [],
            fuoriLista: [],
            lista: "",
        });
        document.getElementById("big").value = "";
        document.getElementById("small").value = "";
        document.getElementById("media").value = "";
    }


    render() {
        return (

            <div className="body">
                <h1>App</h1>
                <Lancio
                    handleSubmit={this.handleSubmit}
                />

                <Sequenza
                    lista={this.state.lista}
                />

                <Statistica
                    handleSubmit={this.calcolo}
                    destroy={this.destroy}
                />


            </div>
        );
    }

}