package servlets;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import beans.UserDB;
import com.google.gson.Gson;
import beans.User;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/actions2")
public class ProvaWS_2{

    private Session session;
    private Gson g;
    static int counter = 0;
    private Random random;
    private List<Integer> list;
    public static List<User> sessioni;

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private boolean started=false;
    @OnOpen
    public void open(Session session) {
        //init
        this.session = session;
        g = new Gson();
        System.out.println("Connessione aperta!");
        sessioni=new ArrayList<>();
        list=new ArrayList<>();
    }

    @OnClose
    public void close(Session session) throws IOException {
        System.out.println("Connessione chiusa!");
        session.close();
    }
    @OnMessage
    public void handleMessage(String message, Session session) throws EncodeException, IOException {
        System.out.println("Ricevuto :" + message + " da " + session.getId());

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
                    launch();
                    started = true;
                    UserDB u=new UserDB(sessioni);
                }
            }
                break;
            case "quit": {
                sendBack("Gioco lasciato, " + session.getId()+" Estratti numeri: "+list.toString());
                executor.shutdownNow();
                System.exit(1);
                //started=false;
            }
                break;
            default:
                sendBack("Hai estratto un numero, ID Sessione: "+session.getId());
        }
    }

    public void sendBack(String message) throws IOException, EncodeException {
        try{
            //this.session.getBasicRemote().sendText(message);
            //per le ws non è definito un broadcast quindi ciclo le sessioni
            for (Session session : session.getOpenSessions()) {
                    System.out.println("Invio " + message + " a: " + session.toString());
                    session.getBasicRemote().sendText(message);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void launch(){
        random=new Random();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable periodicTask = new Runnable() {

            public void run() {
                System.out.println(counter);
                if(counter%1==0){
                    int number = 0 + random.nextInt((90) + 1);
                    while(list.contains(number)) {
                        number = 0 + random.nextInt((90) + 1);
                        if(list.size()==90){
                            //finisce la tombola
                            System.exit(1);
                        }
                    }
                    list.add(number);
                    try {
                        sendBack("Tempo: "+counter+" valore estratto: "+number);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (EncodeException e) {
                        e.printStackTrace();
                    }
                }
                counter++;
            }
        };
        executor.scheduleAtFixedRate(periodicTask, 0, 1, TimeUnit.SECONDS);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user=req.getParameter("utente");
        System.out.println("Ricevuto utente da espellere: "+user);
        sessioni.remove(Integer.parseInt(user));

    }
}
