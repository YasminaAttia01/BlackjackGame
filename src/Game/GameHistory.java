package Game;

import java.util.Stack;

public class GameHistory {
    private final Stack<GameMemento> mementoStack = new Stack<>();

    public void saveState(GameMemento memento) {
        mementoStack.push(memento);
    }

    public GameMemento restoreState() {
        if (mementoStack.isEmpty()) {
            return null;
        }
        return mementoStack.pop();
    }
}
