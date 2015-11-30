/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpsocketlistener;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ongun
 */
public class TCPSocketListener {

    static ServerSocket socket;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Server başlıyo");
        try {
            socket = new ServerSocket(7575);
        } catch (IOException exc) {
            System.out.println("Zıçtı cafer bez getirin!\n");
            exc.printStackTrace();
            System.exit(1);
        }

        while (true) {
            try {
                Socket kabul = socket.accept();
                double angle, power;
                int js;
                DataInputStream dis = new DataInputStream(kabul.getInputStream());
                while (!kabul.isClosed()) {
                    try {
                        angle = dis.readDouble();
                        power = dis.readDouble();
                        js = dis.readInt();
                        System.out.println("From Joystick(" + js + ") Angle : " + angle + " Power : " + power);
                    } catch (IOException exc) {
                        break;
                    }
                }
            } catch (IOException exc) {
                System.out.println("Portların gümbürtüsü başıma vurur!\n");
                exc.printStackTrace();
                System.exit(2);
            }
        }
    }

}
