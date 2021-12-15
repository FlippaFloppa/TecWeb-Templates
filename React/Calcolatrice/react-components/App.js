'use strict';

class App extends React.Component {
  constructor(){
        super();
        this.state = {
        result: "",
        input: ""
        }
        this.onClick = this.onClick.bind(this); 
        this.ajaxCalculation = this.ajaxCalculation.bind(this); 
  }

  onClick(e) {
        let button = e.target.name
        if(button === "="){
            this.calculate()
        }

      else if(button === "C"){
          this.reset()
      }
      else if(button === "CE"){
          this.backspace()
      }

      else {
          this.setState({
            input: this.state.input + button
          })
      }
  };

  ajaxCalculation(e){
    const _url = "./calculateOperationServlet";
    let _number = false;
    const _operation = e.target.name + ""; 
    try {
        _number = (eval(this.state.input) || "" ) + "";
    } catch (e) {
        this.setState({
            result: "error"
        });
    }
    if (!_number) return;

    requestServerCalculation(
        _url,
        _number,
        _operation,
        (calculated_result) => {
            this.setState({result: calculated_result})
        }
    );
  }


  calculate() {
        try {
              this.setState({
              result: (eval(this.state.input) || "" ) + ""
            })
        } catch (e) {
            this.setState({
            result: "error"
        })

        }
  };

  reset(){
      this.setState({
          result: "",
          input: ""
      })
        };


  backspace(){
      this.setState({
          input: this.state.input.slice(0, -1)
      })
  };

  render() {
      return (

        <div className="calculator-body">
            <h1>Calcolatrice</h1>
            <Display result={this.state.input}/>
            <Display result={this.state.result}/>
            <KeyBoard onClick={this.onClick}/>
            <ScientificKeyBoard onClick={this.ajaxCalculation}/>
        </div>

      );
  }
}
