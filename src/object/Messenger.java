/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Truong
 */
public class Messenger implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nguoiGui;
    private List<String> nguoiNhan;
    private String messenger;

    public Messenger() {
    }

    public Messenger(String nguoiGui, List<String> nguoiNhan, String messenger) {
        this.nguoiGui = nguoiGui;
        this.nguoiNhan = nguoiNhan;
        this.messenger = messenger;
    }

    public String getNguoiGui() {
        return nguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        this.nguoiGui = nguoiGui;
    }

    public List<String> getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(List<String> nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }
    
}
