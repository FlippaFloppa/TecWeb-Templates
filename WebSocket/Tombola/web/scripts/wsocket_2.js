var socket = new WebSocket("ws://localhost:8080/TemplateWebSocket/actions2");
console.log("ws://localhost:8080/TemplateWebSocket/actions2")

function send( data) {
    socket.send(data);
}

socket.onmessage =  function (event){
    //Se ricevo JSON
    //var message = JSON.parse(event.data);
    var message = (event.data);
    console.log("Evento ricevuto: "+event.data);
    createPrinter(event.data);
}

function createPrinter(msg){
    var txt = document.createElement("testo");
    txt.innerHTML = msg;
    var br = document.createElement("br");
    document.body.appendChild(br);
    document.body.appendChild(txt);
}

function handleMatch(elem){
    var cmd=myGetElementById(elem).innerHTML;
    console.log("Command: "+myGetElementById(elem).innerHTML);
    send(cmd);
}

function myFunction(){
    console.log("Estrazione...");
    send("estrazione");
}

