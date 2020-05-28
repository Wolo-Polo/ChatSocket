/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Computer;
import object.Messenger;

/**
 *
 * @author Truong
 */
public class Server{
    private static final int PORT=999;
    public static final  List<Computer> LIST_COMPUTERS= new ArrayList<Computer>();
    
    public static void main(String[] args){
        //new ServerView().setVisible(true);
        
        try {
            
            
            ServerSocket serverSocket= null;
            System.out.println("Đang mở cổng "+PORT+" trên Server. Vui lòng chờ!");
            serverSocket= new ServerSocket(PORT);
            System.out.println("Mở cổng hoàn tất!");
            
            while(true){
                System.out.println("Số máy đang onl:"+LIST_COMPUTERS.size());
                for(Computer i: LIST_COMPUTERS){
                    if(i.getSocket().isClosed()){
                        LIST_COMPUTERS.remove(i);
                    }
                }
                System.out.print("Danh sách các client đang online: ");
                for(Computer i: LIST_COMPUTERS){
                    System.out.print(i.getComputerName()+" ");
                }
                System.out.print("\n");
                
                Socket socket=serverSocket.accept();
                ObjectInputStream is= new ObjectInputStream(socket.getInputStream());
                Messenger msgTenPC=(Messenger) is.readObject();
                
                Computer temp= new Computer(socket, msgTenPC.getNguoiGui());
               
                LIST_COMPUTERS.add(temp);
                (new Service(temp)).start();
                
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    
    
}
