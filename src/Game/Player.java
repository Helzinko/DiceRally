package Game;

class Player{

    private String name;

    public boolean connected = false;

    //private int id;

    public Player(/*int id,*/ String name){
        this.name = name;
        //this.id = id;
    }

    public String GetName(){
        return name;
    }
}