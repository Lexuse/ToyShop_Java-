package src.model.fileManager;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileManager<E> implements Writable<E>{

    String filePath = "src/model/fileManager/saves/";

    @Override

    public void save(E e, String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath + fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(e);
    }

    @Override
    public E read(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath + fileName);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        E result = (E) ois.readObject();
            ois.close();
            return result;
        }

    public String getShopsList(){
        File dir = new File(filePath);
        File[] arrFiles = dir.listFiles();
        List<File> list = Arrays.asList(arrFiles);
        StringBuilder str = new StringBuilder();
        if(list.size() != 0){
            str.append("Количество сохраненных магазинов: ").append(list.size()).append("\n");
            for (File file : list){
                str.append(file.getName()).append("\n");
            }return str.toString();
        }else return "Пока не сохранено ни одного магазина \n";
    }
}
