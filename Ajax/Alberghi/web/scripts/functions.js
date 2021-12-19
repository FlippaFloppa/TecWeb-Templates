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
    b.innerHTML += '<button id="thread" onclick="calculate()">Multi Thread</button>'
}

function prefetchAJAX(e,theElement, theXhr,f) {
    var dateIn= myGetElementById("checkin").value;
    var dateOut= myGetElementById("checkout").value;

    // impostazione della funzione di callback
    theXhr.onreadystatechange = function () {

        substituteInnerHTML(theXhr, theElement);
    };
    console.log("Invio :"+e);
    let uri = "Test" + "?elem=" + e + "&checkin=" + dateIn + "&checkout=" + dateOut+"&finalize=false";

    if(f===true) {
        uri = "Test" + "?elem=" + e + "&checkin=" + dateIn + "&checkout=" + dateOut+"&finalize=true";
    }
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

function calculate(r) {
    check();
    var f=false;

        let card = myGetElementById("lista");

        let elem = card.options[card.selectedIndex].value;

        console.log("Ricevuto elemento : " + elem);
        let theElem = myGetElementById("tmp");

        if(r==="finalize") {
        f=true;
        let card = myGetElementById("lista");

        let elem = card.options[card.selectedIndex].value;

        console.log("Ricevuto elemento : " + elem);
        theElem = myGetElementById("result");
    }
    // variabili di funzione
    let xhr = myGetXmlHttpRequest();

    if (xhr) prefetchAJAX(elem,theElem, xhr,f);
    else prefetchIframe();
}

function check(){
    let checkin=myGetElementById("checkin").value;
    let checkout=myGetElementById("checkout").value;
    if(checkin>checkout){
        alert("Inserisci checkin<checkout");
    }
}
