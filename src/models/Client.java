package models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ip = "localhost";
        int port = 12314;
        System.out.println("Cliente");
        try {
            Socket socket;
            if (args.length==2){
                ip = args[0];
                port = Integer.parseInt(args[1]);
                socket = new Socket(ip,port);
            }else socket = new Socket(ip,port);
            System.out.println("Se conecto a "+ip+", en el puerto "+port);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataOutputStream dataOutputStream1 = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Opciones:\n 1.Cambiar de posicion un elemento \n 2.Determinar distancia entre 2 elementos \n " +
                    "3.Determinar elementos en un area circular \n 4.Determinar elementos en un area rectangular \n 5.Eliminar elemento");
            Integer opcion = (input.nextInt());
            dataOutputStream.writeInt(opcion);
            switch (opcion){
                case 1:
                    int x,y,x1,y1;
                    System.out.println("Ingrese la posicion actual:");
                    System.out.println("x");
                    x = input.nextInt();
                    System.out.println("y");
                    y= input.nextInt();
                    System.out.println("x1");
                    x1 = input.nextInt();
                    System.out.println("1");
                    y1= input.nextInt();
                    dataOutputStream1.writeUTF(x+","+y+","+x1+","+y1);
                break;
                case 2:
            }



        }catch (IOException e){
            System.out.println("Error");
        }
    }


}
