package model;

public class Toy {
    private static int serialNumber = 1111;
    private String name;
    private int weightWin;
    private TypeOfToy type;

    public Toy(TypeOfToy type ,String name, int weightWin) {
        this.type = type;
        this.name = name;
        if(weightWin >=0 && weightWin <=100) {
            this.weightWin = weightWin;
        }
        else this.weightWin = 50;
        serialNumber += 1;
    }

    public static int getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public int getWeightWin() {
        return weightWin;
    }

    public TypeOfToy getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Тип игрушки: " + this.getType()  + "Имя игрушки: " + this.getName() + "Шанс выиграть игрушку :" + this.getWeightWin() + "Серийный номер: " + this.getSerialNumber();
    }
}
