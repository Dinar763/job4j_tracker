package ru.job4j.search;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.ConsoleOutput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, ru.job4j.tracker.Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.length) {
                output.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        output.println("Меню:");
        for (int index = 0; index < actions.length; index++) {
            output.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        ru.job4j.tracker.Tracker tracker = new Tracker();
        UserAction[] actions = {
            new CreateAction(output),
            new FindAllAction(output),
            new ReplaceAction(output),
            new DeleteAction(output),
            new FindByIdAction(output),
            new FindByNameAction(output),
            new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}