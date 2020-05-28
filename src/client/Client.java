/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Computer;
import object.Messenger;
import view.ClientView;
import view.LoginView;

/**
 *
 * @author Truong
 */
public class Client {

    private static final String SERVER = "localhost";
    private static final int PORT_OF_SERVER = 999;

    public static void main(String[] args) {

        try {

            LoginView loginView = new LoginView();
            Login login = new Login(loginView);
            loginView.getjButton1().addActionListener(login);
            loginView.setVisible(true);

            String name = null;
            while (name==null) {
                name = login.getUsername();
                Thread.sleep(200);
            }

            Socket socket = new Socket(SERVER, PORT_OF_SERVER);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            Messenger msgTenPC = new Messenger();
            msgTenPC.setNguoiGui(name);
            os.writeObject(msgTenPC);

            Computer computer = new Computer(socket, name);

            ClientView clientView = new ClientView();
            clientView.getjLabel5().setText("Username: " + name);
            clientView.getButtonGui().addActionListener(new Out(computer, clientView));
            clientView.setVisible(true);

            (new In(computer, clientView)).start();

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
