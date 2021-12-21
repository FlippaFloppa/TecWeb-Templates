package it;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import bean.User;
import com.google.gson.Gson;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/actions2")
public class ProvaWS_2{

    private Gson g;
    static int counter = 0;
    private boolean started=false;
    private Session session;
    private List<User> sessioni;
    private List<Integer> numeri;
    private Random r;

    @OnOpen
    public void open(Session session) {
        //init
        this.session = session;
        sessioni=new ArrayList<>();
        numeri=new ArrayList<>();
        g = new Gson();
        System.out.println("Connessione aperta!");
        r=new Random();
    }

    @OnClose
    public void close(Session session) throws IOException {
        System.out.println("Connessione chiusa!");
        session.close();
    }
    @OnMessage
    public void handleMessage(String message, Session session) throws EncodeException, IOException {
        System.out.println("Ricevuto :" + message + " da " + session.getId());
        if(message.contains("Tombola")){
            String tombola=g.fromJson(message,String.class);
            System.out.println(tombola);
            resetGame();
        }
        switch(message){
            case "register": {
                if(!started){
                    sendBack("Registrazione avvenuta, "+session.getId());
                    sessioni.add(new User(session.getId(),session));
                }else{
                    sendBack("Game running, non è possibile registrarsi, "+session.getId());
                }
            }
            break;
            case "start": {
                if(!started) {
                    sendBack("Gioco avviato da utente " + session.getId() + " Numero giocatori: " + sessioni.size());
                    started = true;
                }
            }
            break;
            case "quit": {
                sendBack("Gioco lasciato, " + session.getId());
            }
            break;
            default:
                //metti 10 per debuggare per carità
                sendBack(""+r.nextInt(90));
        }
    }
    public void resetGame(){
        numeri.clear();
        sessioni.clear();
        started=false;
        counter=0;
    }
    public void sendBack(String message) throws IOException, EncodeException {
        try{
            //this.session.getBasicRemote().sendText(message);
            //per le ws non è definito un broadcast quindi ciclo le sessioni
            for (Session session : session.getOpenSessions()) {
                session.getBasicRemote().sendText(message);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user=req.getParameter("utente");
        System.out.println("Ricevuto utente da espellere: "+user);
        sessioni.remove(Integer.parseInt(user));
    }
}
