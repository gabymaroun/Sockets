/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeh;

import java.util.HashMap;

/**
 *
 * @author abdalwahab
 */
public class Data {

    static HashMap<Integer, ClientIntrface> Clients=new  HashMap<>();

    public static HashMap<Integer, ClientIntrface> getClients() {
        return Clients;
    }
}
