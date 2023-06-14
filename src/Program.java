package src;

import src.model.Service;
import src.presenter.Presenter;
import src.ui.Console;
import src.ui.View;

public class Program {
    public static void main (String[] args){
        View view = new Console();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);

        view.start();

    }
}
