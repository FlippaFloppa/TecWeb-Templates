//risposta da servlet
function substituteInnerHTML(ajax, theElement) {

    // designiamo la formattazione della zona dell'output
    theElement.class = "content";

    // verifica dello stato
    if (ajax.readyState === 2) {
        theElement.innerHTML = "Richiesta inviata...";
    } // if 2

    else if (ajax.readyState === 3) {
        theElement.innerHTML = "Ricezione della risposta...";
    } // else if 3

    else if (ajax.readyState === 4) {

        // verifica della risposta da parte del server
        if (ajax.status === 200) {
            // operazione avvenuta con successo
            // per i campi di testo
            //theElement.value = ajax.responseText;
            theElement.innerHTML = (ajax.responseText);
        } // if 200

        else {
            // errore di caricamento
            theElement.innerHTML = "Impossibile effettuare l'operazione richiesta.<br />";
            theElement.innerHTML += "Errore riscontrato: " + ajax.statusText;
        } // else (if ! 200)

    }// else if 4

}

function prefetchIframe() {
    alert("Non supportiamo iframe");
}

function show() {
    var b = myGetElementById('pulsanti');
    b.innerHTML = '<button id="seq" onClick="matrixCalculatorSingle()">Single Thread</button>'
    b.innerHTML += '<button id="thread" onclick="calculate()">Multi Thread</button>'
}

function prefetchAJAX(e, theElement, theXhr) {

    // impostazione della funzione di callback
    theXhr.onreadystatechange = function () {

        substituteInnerHTML(theXhr, theElement);
    };
    var toJson = JSON.stringify(e);

    console.log("Invio : " + toJson);
    let uri = "Test" + "?elem=" + toJson;

    // impostazione richiesta asincrona in GET
    try {
        theXhr.open("get", uri, true);
    } catch (e) {
        // Exceptions are raised when trying to access cross-domain URIs
        alert(e);
    }

    // sostituzione dell'header "connection" (default = "keep alive")
    theXhr.setRequestHeader("connection", "close");

    // invio richiesta
    theXhr.send(null);

}

function calculate() {
    if (!check()) return;

    var txt = myGetElementById("txt").value;

    var theElem = myGetElementById("result");

    // variabili di funzione
    let xhr = myGetXmlHttpRequest();

    if (xhr) prefetchAJAX(txt, theElem, xhr);
    else prefetchIframe();
}

function check() {
    var txt = myGetElementById("txt").value;

    if (txt.length < 100) {
        alert("Inserisci almeno 100 caratteri!");
        return false;
    }
    return true;
}
