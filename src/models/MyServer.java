package models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    private Socket socket;
    private ServerSocket serverSocket;
    private boolean running = true;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private MySparceMatrixx <String> stringMySparceMatrixx;


    public MyServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.startServer();
        this.dataInputStream  = new DataInputStream(this.socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
        this.stringMySparceMatrixx = new MySparceMatrixx<>(20,20);
    }

    private void startServer() {
        System.out.println("[*] Listening on port --> " + this.serverSocket.getLocalPort());
        while(running){
            try {
                this.socket = serverSocket.accept();
                System.out.println("Conectado cliente en --> " + this.socket.getInetAddress().getHostAddress());



            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private void handleChangePos(String data){
        System.out.println("Has seleccionado ---> ***Cambiar de posicion un elemento*** ");
        this.stringMySparceMatrixx.swapPos();


    }


    public static void main(String[] args) throws IOException {
        MyServer server = new MyServer(23);

    }



}
