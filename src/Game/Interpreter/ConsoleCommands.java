package Game.Interpreter;

public class ConsoleCommands {

    public static Expression getCorrectCommand(){
        Expression roll = new TerminalExpression("/roll");
        Expression pause = new TerminalExpression("/pause");
        Expression exit = new TerminalExpression("/exit");

        return new CommandExpression(roll, pause, exit);
    }


}
