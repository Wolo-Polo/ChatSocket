/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Computer;
import object.Messenger;

/**
 *
 * @author Truong
 */
public class Service extends Thread {

    private Computer computer;

    public Service() {
    }

    public Service(Computer computer) {
        this.computer = computer;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void run() {
        try {
            //kết nối và phục vụ socket được truyền vào
            //...
            String computerName=computer.getComputerName();
            System.out.println("Đang xử lý với máy tính: " + computerName);
            try {
                ObjectOutputStream os = computer.getOs();
                ObjectInputStream is = computer.getIs();
                
                while (true) {
                    Messenger messenger = (Messenger) is.readObject();
                    messenger.setNguoiGui(computerName);
                    for (String j : messenger.getNguoiNhan()) {
                        boolean kt = false;
                        for (Computer i : Server.LIST_COMPUTERS) {
                            if (j.equals(i.getComputerName())) {

                                System.out.println("đã tìm thấy đối tác onl");
                                System.out.println("Tin nhắn: " + messenger.getMessenger());
                                i.getOs().writeObject(messenger);
                                System.out.println("đã gửi tin đến đối tác " + i.getComputerName());
                                kt = true;
                            }
                        }
                        if (kt == false) {
                            System.out.println("Nguoi nhan "+j+" k onl");
                            ArrayList<String> temp = new ArrayList<>();
                            temp.add(messenger.getNguoiGui());
                            os.writeObject(new Messenger("System", temp, "Người nhận không onl"));
                            
                        }

                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hoàn tất xử lý với: " + computer.getComputerName());
        try {
            computer.getSocket().close();
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
