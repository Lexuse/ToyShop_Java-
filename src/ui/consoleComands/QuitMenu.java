package src.ui.consoleComands;

import src.ui.Console;

public class QuitMenu extends Command{
    public QuitMenu(Console console) {
        super(console);
        descriptionCommand = "Покинуть пункт меню";
    }

    @Override
    public boolean executeCommand() {
        return false;
    }
}
