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
public interface ServerInterface extends Remote {

    public void sendMessage(int id,String message,int from) throws RemoteException;

    public void AddClient(ClientIntrface CI) throws RemoteException;

    public void RemoveClient(ClientIntrface CI) throws RemoteException;

}
