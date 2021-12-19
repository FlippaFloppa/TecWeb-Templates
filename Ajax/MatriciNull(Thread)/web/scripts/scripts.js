//risposta da servlet
function substituteInnerHTML(ajax, theElement) {

    // designiamo la formattazione della zona dell'output
    theElement.class = "content";

    // verifica dello stato
    if (ajax.readyState === 2) {
        theElement.innerHTML = "Richiesta inviata...";
    }

    else if (ajax.readyState === 3) {
        theElement.innerHTML = "Ricezione della risposta...";
    }

    else if (ajax.readyState === 4) {

        // verifica della risposta da parte del server
        if (ajax.status === 200) {
            // operazione avvenuta con successo

            // per i campi di testo
            //theElement.value = ajax.responseText;

            // per il formato JSON
           //theElement.innerHTML = JSON.parse(ajax.responseText);

            //per i div
            theElement.innerHTML = ajax.responseText;
        }

        else {
            // errore di caricamento
            theElement.innerHTML = "Impossibile effettuare l'operazione richiesta.<br />";
            theElement.innerHTML += "Errore riscontrato: " + ajax.statusText;
        }

    }

}

function prefetchIframe() {
    alert("Non supportiamo iframe");
}

function prefetchAJAX(e,theElement, theXhr,status) {

    // impostazione della funzione di callback
    theXhr.onreadystatechange = function () {

        substituteInnerHTML(theXhr, theElement);
    };

    console.log("Invio :"+e);
    let uri = "Test";

    // impostazione richiesta asincrona in GET
    try {
        theXhr.open("post", uri, true);
    } catch (e) {
        // Exceptions are raised when trying to access cross-domain URIs
        alert(e);
    }

    // sostituzione dell'header "connection" (default = "keep alive")
    theXhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    theXhr.setRequestHeader("connection", "close");
    // invio richiesta
    theXhr.send("p1="+e+"&p2="+status);

}

function calculate(status) {

        //genero matrice

        //elemento da cui prendo il value
        var elem=generateMatrix();
        console.log("Ricevuto elemento : " + elem);

        //elemento su cui stampo(div)
        theElem = myGetElementById("result");

    // variabili di funzione xhr
    var xhr = myGetXmlHttpRequest();

    if (xhr) prefetchAJAX(elem,theElem, xhr,status);

    else prefetchIframe();
}

function generateMatrix(){
    var matrix = [];
    for(var i=0; i<9; i++) {
        matrix[i] = new Array(9);
    }
    return matrix;
}
