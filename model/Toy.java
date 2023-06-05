package model;

enum TypeOfToy {Car, Doll, Robot, Animal}

public class Toy {
    private static int SerialNumber = 1111;
    private String Name;
    private int WeightWin;
    private TypeOfToy Type;

    public Toy(TypeOfToy type ,String name, int weightWin) {
        Type = type;
        Name = name;
        if(weightWin >=0 && weightWin <=100) {
            WeightWin = weightWin;
        }
        else WeightWin = 50;
        SerialNumber += 1;
    }

    public static int getSerialNumber() {
        return SerialNumber;
    }

    public String getName() {
        return Name;
    }

    public int getWeightWin() {
        return WeightWin;
    }

    public TypeOfToy getType() {
        return Type;
    }

    @Override
    public String toString() {
        return "Тип игрушки: " + this.getType()  + "Имя игрушки: " + this.getName() + "Шанс выиграть игрушку :" + this.getWeightWin() + "Серийный номер: " + getSerialNumber();
    }
}
