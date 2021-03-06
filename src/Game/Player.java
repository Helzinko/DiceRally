package Game;

import Game.Mediator.ChatRoom;

public class Player{

    private String name;

    public boolean connected = false;

    private int id;



    public Player(int id, String name){
        this.name = name;
        this.id = id;
    }

    public String GetName(){
        return name;
    }

    public void SetId(int id){
        this.id = id;
    }

    public int GetId(){
        return id;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}