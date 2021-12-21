//risposta da servlet
var tempo=0;
var risultato=0;

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
            var res=JSON.parse(ajax.responseText);

            tempo=parseInt(res.tempo)+tempo;
            risultato=parseInt(res.risultato)+risultato;

            //per i div
            theElement.innerHTML = "Occorrenze: "+risultato+" Tempo impiegato: "+tempo;
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

function prefetchAJAX(e,parola,theElement, theXhr) {

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
    theXhr.send("p1="+parola+"&p2="+JSON.stringify(e));

}

function calculate(choice) {

        //1Thread
        var string="asdasdasdasdasdasdasd";

        //2Threads
        var firstHalf=string.substring(0,string.length/2);
        var secondHalf=string.substring((string.length/2)+1,string.length);

        //4Threads
        var firstFourth=string.substring(0,string.length/4);
        var secondFourth=string.substring((string.length/4)+1,string.length/2);
        var thirdFourth=string.substring((string.length/2)+1,(string.length/2)+string.length/4);
        var fourthFourth=string.substring((string.length/4)+1,string.length);

        if(choice==="1") {
            tempo=0;
            risultato=0;
            console.log("Processo elemento : " + string);

            sendAjax(string);
        }
        else if(choice==="2") {

        console.log("Processo elementi : " + firstHalf+"-"+secondHalf);
            tempo=0;
            risultato=0;
            sendAjax(firstHalf);
            sendAjax(secondHalf);
        }
        else if(choice==="3") {
            tempo=0;
            risultato=0;
            console.log("Processo elementi : " + fourthFourth+"-"+secondFourth+"-"+thirdFourth+"-"+fourthFourth);

            sendAjax(firstFourth);
            sendAjax(secondFourth);
            sendAjax(thirdFourth);
            sendAjax(fourthFourth);
        }
}
function hasNumber(myString) {
    return /\d/.test(myString);
}
function sendAjax(string){

    var parola=myGetElementById("parola").value;

    if (hasNumber(parola)) {
    alert("Non può contenere caratteri non alfabetici!");
    return;
    }

    //elemento su cui stampo(div)
    theElem = myGetElementById("result");

    // variabili di funzione xhr
    var xhr = myGetXmlHttpRequest();

    if (xhr) prefetchAJAX(string,parola, theElem, xhr);

    else prefetchIframe();
}


