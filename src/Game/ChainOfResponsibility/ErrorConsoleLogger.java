package Game.ChainOfResponsibility;

public class ErrorConsoleLogger extends AbstractLogger {
    public ErrorConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error: " + message);
    }
}
