/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeh;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author abdalwahab
 */
public class ClientImp extends UnicastRemoteObject implements ClientIntrface {

    int id;
    String name;
    private HashMap<Integer, ArrayList<String>> msgList;
    private DefaultListModel<String> model;
    private JList clientList;
    private User userFram;

    public ClientImp(int id, String name, DefaultListModel model, HashMap<Integer, ArrayList<String>> msgList, JList clientList, User userFram) throws RemoteException {
        this.id = id;
        this.name = name;
        this.model = model;
        this.msgList = msgList;
        this.clientList = clientList;
        this.userFram = userFram;
    }

    @Override
    public void ReceiveMessage(String message, int from) throws RemoteException {
        msgList.get(from).add(message + "\n");
        if (from == userFram.getSelectedId()) {
            userFram.update();
            return;
        }
        for (int i = 0; i < model.getSize(); i++) {
            String client = model.get(i);
            String[] id = client.split("[ :]");
            if (from == Integer.parseInt(id[0])) {
                model.setElementAt(model.get(i) + "  (!)", i);
            }
        }
    }

    @Override
    public void ReceiveClient(int id, String name) throws RemoteException {
        model.addElement(id + " : " + name);
        msgList.put(id, new ArrayList());
    }

    @Override
    public void RemoveClient() throws RemoteException {
    }

    @Override
    public int getId() throws RemoteException {
        return id;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

}
