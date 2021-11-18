package Game.Strategy_Template;

import Game.Chat;

public abstract class SquareSkippingTemplate {

    public final double[] skippingProcess(double currentHealth, int currentPosition) {
        if (isSkippingSquare()) {
            currentPosition += skipSquares();
            Chat.AddMessage("You skipped " + skipSquares() + " squares");
            if (ifTakeDamage()) {
                currentHealth = takeDamage(currentHealth);
                Chat.AddMessage("And taken 15 damage. " + currentHealth + " is left.");
            } else {
                Chat.AddMessage("You took no damage.");
            }
        }

        return new double[]{currentHealth, currentPosition};
    }

    public double takeDamage(double currentHealth) {
        if (currentHealth - 15 < 0) {
            return 0;
        }
        return currentHealth - 15;
    }

    public abstract boolean ifTakeDamage();

    public abstract boolean isSkippingSquare();

    public abstract int skipSquares();
}
