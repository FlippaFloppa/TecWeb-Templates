var socket = new WebSocket("ws://localhost:8080/Appello_01feb2021(2)-Telefono/actions2");
console.log("ws://localhost:8080/Appello_01feb2021(2)-Telefono/actions2")

function send(data) {
    socket.send(data);
}

socket.onmessage =  function (event){
    //Se ricevo JSON
    //var message = JSON.parse(event.data);
    var message = (event.data);
    if(message.match('avviato')){
        console.log("Gioco Avviato");
        createPrinter(event.data);
    }
    else if(message.match('end')){
        console.log("Gioco finito");
        createPrinter(event.data);
    }else{
        console.log("Evento ricevuto: "+event.data);
        send(event.data);
    }

}

function createPrinter(msg){
    var txt = document.createElement("testo");
    txt.innerHTML = msg;
    var br = document.createElement("br");
    document.body.appendChild(br);
    document.body.appendChild(txt);
}

function handleMatch(){
    //var frase=document.getElementById("txt").value;

    var frase=myGetElementById("txt").value;
    console.log("Frase: "+frase);
    send(frase);
}


