package src;

import src.model.Service;
import src.presenter.Presenter;
import src.ui.Console;
import src.ui.View;

import java.io.IOException;

public class Program {
    public static void main (String[] args) throws IOException {
        View view = new Console();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);

        view.start();

    }
}
