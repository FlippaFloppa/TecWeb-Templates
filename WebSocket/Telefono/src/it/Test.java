package it;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Random;

@ServerEndpoint("/actions2")
public class Test {

    private Session session;
    private Random random;
    private boolean started;
    private final Character[] alphabet = {'a', 'b', 'c', 'd'};
    private int turn;
    private String frase;

    @OnOpen
    public void open(Session session) {
        //init
        this.session = session;
        random = new Random();
        started = false;
        turn = 0;
        System.out.println("Connessione aperta!");
    }

    @OnClose
    public void close(Session session) throws IOException {
        System.out.println("Connessione chiusa!");
        session.close();
    }

    @OnMessage
    public void handleMessage(String message, Session session) throws EncodeException, IOException {
        if (!started) {
            frase="";
            System.out.println("Ricevuto :" + message + " da " + session.getId());
            sendBack("Ha avviato, il gioco la sessione: " + session.getId());
            started = true;
            frase = removeRandomChar(message);
            sendBack(frase);
        } else {
            if (turn < 3) {
                turn++;
                frase = removeRandomChar(frase);
                sendBack(frase);
            } else {
                sendBack("end-" + frase);
            }

        }
    }

    public void sendBack(String message) throws IOException, EncodeException {
        try {
            //this.session.getBasicRemote().sendText(message);
            //per le ws non è definito un broadcast quindi ciclo le sessioni
            for (Session session : session.getOpenSessions()) {
                System.out.println("Invio " + message + " a: " + session.toString());
                session.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String removeRandomChar(String msg) {
        String res = "";
        int number = random.nextInt(alphabet.length);
        for (int i = 0; i <msg.length(); i++) {
            if (msg.charAt(i) != alphabet[number]) {
                res += msg.charAt(i);
            }
        }
        return res;
    }
}


