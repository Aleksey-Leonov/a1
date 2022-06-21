package com.company.company.homework3;

public class PingPongThread extends Thread {
    private String msg;
    private static String turn;

    public PingPongThread(String msg){
        this.msg = msg;
    }
    @Override
    public void run() {
        while(true) {
            playTurn();
        }

    }
    public synchronized void playTurn(){
        if (!msg.equals(turn)){
            turn=msg;
            System.out.println(msg);
        }
    }
}