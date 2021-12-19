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

function prefetchAJAX(theElement, theXhr) {

    // impostazione della funzione di callback
    theXhr.onreadystatechange = function () {

        substituteInnerHTML(theXhr, theElement);
    };

    var data=myGetElementById("data").value;
    var orario=myGetElementById("orario").value;
    var campi=myGetElementById("campi");
    var scelta=myGetElementById("scelta");
    var c=campi.options[campi.selectedIndex].value
    var s=scelta.options[scelta.selectedIndex].value
    var request=new Object();

    request.data=data;
    request.orario=orario;
    request.campi=c;
    request.scelta=s;

    //let uri = "Test" + "?elem=" + e;
    let uri = "Test";
    // impostazione richiesta asincrona in GET
    try {
        theXhr.open("post", uri, true);
    } catch (e) {
        // Exceptions are raised when trying to access cross-domain URIs
        alert(e);
    }
    console.log(JSON.stringify(request));
    // sostituzione dell'header "connection" (default = "keep alive")
    theXhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    theXhr.setRequestHeader("connection", "close");

    // invio richiesta
    //theXhr.send(null);
    theXhr.send("p1=json&p2="+JSON.stringify(request));
}

function calculate() {

        //controllo
        check();

        //elemento su cui stampo(div)
        theElem = myGetElementById("result");

    // variabili di funzione xhr
    var xhr = myGetXmlHttpRequest();

    if (xhr) prefetchAJAX(theElem, xhr);

    else prefetchIframe();
}

function check(){
var data=myGetElementById("data").value;
var orario=myGetElementById("orario").value;
if(isNaN(data)||isNaN(orario)){
    alert("Inserisci numeri!");
}else if(data<0||orario<0){
    alert("Inserisci validi!");
}
}
