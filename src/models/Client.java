package models;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client{

    Scanner input = new Scanner(System.in);

    public Client(String[] args) {
        String ip = "localhost";
        int port = 12314;
        System.out.println("Cliente");
        try {
            Socket socket;
            if (args.length == 2) {
                ip = args[0];
                port = Integer.parseInt(args[1]);
                socket = new Socket(ip, port);
            } else socket = new Socket(ip, port);
            System.out.println("Se conecto a " + ip + ", en el puerto " + port);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataOutputStream dataOutputStream1 = new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream dataOutputStream2 = new ObjectOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Opciones:\n 1.Cambiar de posicion un elemento \n 2.Determinar distancia entre 2 elementos \n " +
                    "3.Determinar elementos en un area circular \n 4.Determinar elementos en un area rectangular \n 5.Eliminar elemento");
            Integer opcion = (input.nextInt());
            dataOutputStream.writeInt(opcion);
            switch (opcion){
                case 1:
                    dataOutputStream1.writeUTF(case12());
                break;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public String case12(){
        int x,y,x1,y1;
            System.out.println("Ingrese la primer posicion:");
            System.out.println("x");
            x = input.nextInt();
            System.out.println("y");
            y= input.nextInt();
            System.out.println("");
            System.out.println("x1");
            x1 = input.nextInt();
            System.out.println("1");
            y1= input.nextInt();
            return x+","+y+","+x1+","+y1;
        }

    public static void main(String[] args) {
        new Client(args);
    }


    }


