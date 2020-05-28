/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Computer;
import object.Messenger;
import view.ClientView;

/**
 *
 * @author Truong
 */
public class Out implements ActionListener{
    
    Computer computer;
    ClientView clientView;
    Messenger messenger=null;
    
    public Out() {
    }

    public Out(Computer computer, ClientView clientView) {
        this.computer = computer;
        this.clientView = clientView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ngNhan= clientView.getjTextField1().getText();
        String[] arrNgNhan= ngNhan.split(";");
        List<String> listNgNhan= new ArrayList<>();
        listNgNhan.addAll(Arrays.asList(arrNgNhan));
        
        messenger=new Messenger(computer.getComputerName(), listNgNhan, clientView.getjTextArea2().getText());
        
        ObjectOutputStream os = computer.getOs();
        
        
        clientView.getjTextField1().setText("");
        clientView.getjTextArea2().setText("");
        clientView.getjTextArea1().append("Bạn: "+messenger.getMessenger()+"\n");
        try {
            os.writeObject(messenger);
        } catch (IOException ex) {
            Logger.getLogger(Out.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
