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
        this.stringMySparceMatrixx = new MySparceMatrixx<>(50,50);
        this.serverSocket = new ServerSocket(port);
        this.startServer();
        this.dataInputStream  = new DataInputStream(this.socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
    }

    private void startServer() {
        System.out.println("[*] Listening on port --> " + this.serverSocket.getLocalPort());
        while (running) {
            try {
                this.socket = serverSocket.accept();
                DataInputStream dataInputStreamaux = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStreamaux = new DataOutputStream(socket.getOutputStream());
                System.out.println("[*] Client connected on --> " + this.socket.getInetAddress().getHostAddress());


                Integer opcion = (dataInputStreamaux.readInt());


                int opcion2 = dataInputStreamaux.readInt();



                switch (opcion2) {
                    case 1:
                        //System.out.println("Ingrese las coordenadas ");
                        this.handleChangePos(dataInputStreamaux.readUTF());

                        break;
                    case 2:
                        dataOutputStreamaux.writeUTF( this.handleDistanceBetweenElements(dataInputStreamaux.readUTF()));
                    case 4:
                        dataOutputStreamaux.writeUTF(this.handleElementsInRectangularArea(dataInputStreamaux.readUTF()));
                        break;
                    case 3:
                        dataOutputStreamaux.writeUTF(this.handleElementsInCircularArea(dataInputStreamaux.readUTF()));
                        break;
                    case 5:
                        break;
                }



            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleChangePos(String data){
        System.out.println("Has seleccionado ---> ***Cambiar de posicion un elemento*** ");
        //this.stringMySparceMatrixx.swapPos();
    }


    private String handleDistanceBetweenElements(String data){
        int[] dataInts;
        dataInts = MySparceMatrixx.splitter(data);
        return "La distancia entre los dos elementos es --> " + this.stringMySparceMatrixx.distanceBetween(dataInts[0], dataInts[1], dataInts[2], dataInts[3]);

    }

    private String handleElementsInRectangularArea(String data){
        return "Hay " + this.stringMySparceMatrixx.elementsRectangle(MySparceMatrixx.splitter(data))+ ", elementos en el area rectangular";
    }

    private String handleElementsInCircularArea(String data){
        return "Hay " + this.stringMySparceMatrixx.numberOfElementsIntoCircularArea( MySparceMatrixx.splitter(data))+", elementos en dicha area circular";
    }

    private String handleDeleteElement(String data){
        return this.stringMySparceMatrixx.remove(MySparceMatrixx.splitter(data))?"Elemento borrado satisfactoriamente": "Ups no se ha podido borrar el elemento";
    }

    public static void main(String[] args) throws IOException {
        MyServer server = new MyServer(23);

    }



}
