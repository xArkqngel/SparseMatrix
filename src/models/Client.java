package models;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    Scanner input = new Scanner(System.in);

    public Client(String[] args) {
        String ip = "localhost";
        int port = 12314;
        //System.out.println("[*]Listening on " + ip);
        try {
            Socket socket;
            if (args.length == 2) {
                ip = args[0];
                port = Integer.parseInt(args[1]);
                socket = new Socket(ip, port);
            } else socket = new Socket(ip, 23);
            System.out.println("[*]Connected on " + ip + ", port: " + port);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataOutputStream dataOutputStream1 = new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream dataOutputStream2 = new ObjectOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Opciones:\n 1.Cambiar de posicion un elemento \n 2.Determinar distancia entre 2 elementos \n " +
                    "3.Determinar elementos en un area circular \n 4.Determinar elementos en un area rectangular \n 5.Eliminar elemento");

            int opcion = (input.nextInt());

            dataOutputStream1.writeInt(opcion);
            switch (opcion){
                case 1:
                    System.out.println("Has seleccionado --> Cambiar de posicion un elemento");
                    dataOutputStream1.writeUTF(case12());
                    System.out.println(dataInputStream.readUTF());
                    break;
                case 2:
                    System.out.println("Has seleccionado --> Determinar distancia entre 2 elementos");
                case 4:
                    dataOutputStream1.writeUTF(case12());
                    System.out.println(dataInputStream.readUTF());

                    break;
                case 3:
                    System.out.println("Has seleccionado --> Determinar elementos en un area circular");
                    dataOutputStream1.writeUTF(case3());
                    System.out.println(dataInputStream.readUTF());
                    break;
                case 5:
                    System.out.println("Has seleccionado -->  Eliminar elemento ");
                    dataOutputStream1.writeUTF(caseDef());
                    System.out.println(dataInputStream.readUTF());
                break;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            }
        }

        public String caseDef(){
            int x,y;
            System.out.println("Ingrese la coordenada X:");
            x = input.nextInt();
            System.out.println("Ingrese la coordenada Y:");
            y = input.nextInt();
            return x+","+y;
        }


        public String case3(){
            int x,y,ratio;
            System.out.println("Ingrese la posición: X");
            x = input.nextInt();
            System.out.println("Ingrese la posicion: Y");
            y = input.nextInt();
            System.out.println("Ingrese el radio del circulo (entero)");
            ratio = input.nextInt();
            return x+","+y+","+ratio;
        }

        public String case12(){
        int x,y,x1,y1;
            System.out.println("Ingrese las coordenadas de la primer posicion:");
            System.out.println("X --> ");
            x = input.nextInt();
            System.out.println("Y --> ");
            y= input.nextInt();
            System.out.println("Ingrese las coordenadas de la segunda posicion:");
            System.out.println("X --> ");
            x1 = input.nextInt();
            System.out.println("Y --> ");
            y1= input.nextInt();
            return x+","+y+","+x1+","+y1;
        }

    public static void main(String[] args) {
        System.out.println("Ingrese primero la IP destino y luego el puerto");
        new Client(args);
    }


    }


