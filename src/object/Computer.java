/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Truong
 */
public class Computer {
    Socket socket;
    String computerName;
    ObjectOutputStream os;
    ObjectInputStream is;
    
    public Computer() {
    }

    public Computer(Socket socket, String computerName) {
        try {
            this.socket = socket;
            this.computerName = computerName;
            os=new ObjectOutputStream(socket.getOutputStream());
            is=new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Computer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public ObjectOutputStream getOs() {
        return os;
    }

    public void setOs(ObjectOutputStream os) {
        this.os = os;
    }

    public ObjectInputStream getIs() {
        return is;
    }

    public void setIs(ObjectInputStream is) {
        this.is = is;
    }
    
    
}
