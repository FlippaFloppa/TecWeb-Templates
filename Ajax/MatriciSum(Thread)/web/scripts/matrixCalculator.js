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
            theElement.innerHTML = ajax.responseText;
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
    b.innerHTML += '<button id="thread" onclick="matrixCalculatorMulti()">Multi Thread</button>'
}

function prefetchAJAX(x, y, theElement, theXhr, type) {
    // impostazione della funzione di callback
    theXhr.onreadystatechange = function () {

        substituteInnerHTML(theXhr, theElement);
    };

    let uri = "Test" + "?first=" + x + "&second=" + y + "&request=" + type;

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

function matrixCalculatorSingle() {
    var e = myGetElementById("single");
    var type = "s";
    console.log("Ricevuto elemento :" + e + " Richiesta: " + type);
    let x = myGetElementById("first").value;
    let y = myGetElementById("second").value;

    console.log("Calcolo matrici" + x + " e " + y);

    // variabili di funzione
    var xhr = myGetXmlHttpRequest();

    if (xhr) prefetchAJAX(x, y, e, xhr, type);
    else prefetchIframe();
}

function matrixCalculatorMulti() {
    var e = myGetElementById("multi");
    var type = "m";
    console.log("Ricevuto elemento :" + e + " Richiesta: " + type);
    let x = myGetElementById("first").value;
    let y = myGetElementById("second").value;

    console.log("Calcolo matrici" + x + " e " + y);

    // variabili di funzione
    var xhr = myGetXmlHttpRequest();

    if (xhr) prefetchAJAX(x, y, e, xhr, type);
    else prefetchIframe();
}