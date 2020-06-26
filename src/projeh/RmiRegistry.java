/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeh;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salah
 */
public class RmiRegistry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            int port;

            Scanner key = new Scanner(System.in);
            System.out.println("port");
            port = key.nextInt();

            LocateRegistry.createRegistry(port);
            System.out.println("java RMI registry created.");
            key.nextLine();
            key.nextLine();
        } catch (RemoteException ex) {
            Logger.getLogger(RmiRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
