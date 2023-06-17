package src.ui;

import src.presenter.Presenter;

import java.io.IOException;

public interface View {

    void setPresenter(Presenter presenter);
    void start() throws IOException;
    void print(String text);
}
