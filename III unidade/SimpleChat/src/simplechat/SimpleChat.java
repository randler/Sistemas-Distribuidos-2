/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechat;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

/**
 *
 * @author randler
 */
public class SimpleChat extends ReceiverAdapter {

    private JChannel channel;
    private MouseEvent e = null;
    private final List<String> state = new LinkedList<String>();

    String user_name = System.getProperty("user.name", "n/a"); 

    public void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("ChatCluster");
        channel.getState(null, 10000);
        //eventLoop();
        //channel.close();
    }
    
    public byte[] getState(){
        synchronized(state){
            try{
                return Util.objectToByteBuffer(state);
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }
    
    public void setState(byte[] new_state){
        try{
            List<String> list = (List<String>) Util.objectFromByteBuffer(new_state);
            synchronized(state){
                state.clear();
                state.addAll(list);
            }            
            System.out.println("received state(" + list.size() + "message in chat history):");
            for (String str : list) {
                System.out.println(str);
            }
        }catch(Exception e){
        }
    }

    @Override
    public void viewAccepted(View new_view){
        System.out.println("**view: " + new_view);
    }
    
    @Override
    public void receive(Message msg){           
        e = (MouseEvent) msg.getObject();
        System.out.print("x: " + e.getX() + " / ");
        System.out.println("y: " + e.getY());
    }
    
    public void send(MouseEvent e){

        try {
            Message msg = new Message(null,null,e);
            channel.send(msg);
        } catch (Exception ex) {
            Logger.getLogger(SimpleChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MouseEvent getE() {
        return e;
    }
    
}
