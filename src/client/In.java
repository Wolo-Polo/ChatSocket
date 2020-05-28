/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Computer;
import object.Messenger;
import view.ClientView;

/**
 *
 * @author Truong
 */
public class In extends Thread {

    Computer computer;
    ClientView clientView;

    @Override
    public void run() {

        try {

            ObjectInputStream is = computer.getIs();

            Messenger messenger;
            while (true) {
                messenger = (Messenger) is.readObject();

                /*
                System.out.println(messenger.getNguoiGui() + ": " + messenger.getMessenger());
                */
                
                clientView.getjTextArea1().append(messenger.getNguoiGui() + ": " + messenger.getMessenger()+"\n");
            }

        } catch (IOException | ClassNotFoundException ex) {

            Logger.getLogger(In.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public In() {
    }

    public In(Computer computer, ClientView clientView) {
        this.computer = computer;
        this.clientView = clientView;
    }

}
