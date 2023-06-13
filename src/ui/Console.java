package src.ui;

import src.presenter.Presenter;

import java.util.Scanner;

public class Console implements  View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean isWork;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        isWork =true;
        menu = new Menu(this);
    }

    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void start(){
        while (isWork){
            mainRequest();
        }
    }

    public String scan(){return  scanner.nextLine();}
    private boolean isCanBeInt(String text) {
        return text.matches("[0-9]+");
    }
    public void quit() {isWork = false;}

    public String requestNameOfNewWarehouse(){
        print();
        return
    }

    private void mainRequest() {
        print(menu.printMainCommands());
        String nMenuStr = scan();
        if (isCanBeInt(nMenuStr)) {
            int nMenu = Integer.parseInt(nMenuStr);
            if (0 < nMenu && nMenu <= menu.getSizeMainCommands()) {
                menu.executeMainCommands(nMenu);
            } else {
                print("Некорректный ввод");
            }
        } else {
            print("вводите цифры обозначающие пункты меню");
        }
    }

    public void createWarehouse() {
        String fTreeName = requestNameFTree();
        if (presenter.addFamilyTree(fTreeName)) {
            while (editTree()) ;
        }
    }
}
