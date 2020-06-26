/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeh;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author abdalwahab
 */
public class ServerImp extends UnicastRemoteObject implements ServerInterface {

    public ServerImp() throws RemoteException {
    }

    @Override
    public void sendMessage(int id, String message, int from) throws RemoteException {
        Data.getClients().get(id).ReceiveMessage(message, from);
    }

    @Override
    public void AddClient(ClientIntrface CI) throws RemoteException {
        ClientIntrface e;
        for (int i : Data.getClients().keySet()) {
            e = Data.getClients().get(i);
            e.ReceiveClient(CI.getId(), CI.getName());
            CI.ReceiveClient(e.getId(), e.getName());
        }
        Data.getClients().put(CI.getId(), CI);
    }

    @Override
    public void RemoveClient(ClientIntrface CI) throws RemoteException {
        Data.getClients().remove(CI.getId());
    }

}
