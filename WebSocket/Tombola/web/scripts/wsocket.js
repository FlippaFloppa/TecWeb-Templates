var socket = new WebSocket("ws://localhost:8080/08_TecWeb/actions");

function send( data) {
    var json = JSON.stringify(data);
    socket.send(json);
}


socket.onmessage =  function (event){
	
	 var message = JSON.parse(event.data);
	 if(message.valid)
		 {
		 	var log = document.getElementById("risultato");
			log.value = "";
		    console.log(event.data);
		   
		    log.value = message.risultato;
		 }else{
			 alert("hai superato il limite massimo di richieste per sessione");
		 }
	
}

function myFunction()
{
	var op1 = document.getElementById("op1").value;
	var op2 = document.getElementById("op2").value;
	if(isNaN(op1) || isNaN(op2))
		{
			alert("uno dei due operandi non è un numero");
			return;
		}
	var operazione = document.getElementsByName("op");
	var op;
	for (var i=0; i< operazione.length;i++)
		{
			if(operazione[i].checked)
				{
					op = operazione[i].value;
					break;
				}
		}
	var operationReq = {};
	operationReq.op1 = op1;
	operationReq.op2 = op2;
	operationReq.operazione = op;
	
	send(operationReq);
	
}

