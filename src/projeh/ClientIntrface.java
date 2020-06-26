/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeh;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author abdalwahab
 */
public interface ClientIntrface extends Remote {

    public void ReceiveMessage(String message,int id) throws RemoteException;

    public void ReceiveClient(int id,String name) throws RemoteException;

    public void RemoveClient() throws RemoteException;
    
    public int getId() throws RemoteException;
    
    public String getName() throws RemoteException;
}
