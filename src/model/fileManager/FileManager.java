package src.model.fileManager;

import java.io.*;

public class FileManager<E> implements Writable<E>{


    @Override
    public void save(E e, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(e);
            saveShopName(fileName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public E read(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            E result = (E)ois.readObject();
            ois.close();
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private void saveShopName(String name){
        try (FileWriter writer = new FileWriter("src/model/shops/Shops.txt", true))
        {
         writer.write(name);
         writer.append('\n');
         writer.flush();
            System.out.println("Сохранение");
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }

    public String getShopsList(){
        StringBuilder result = new StringBuilder();
        try(FileReader reader = new FileReader("src/model/shops/Shops.txt"))
            {
                int c;
                while ((c = reader.read())!=-1){
                    result.append((char) c);
                }
                return result.toString();
        } catch (FileNotFoundException e) {
            return "Файл со списком магазинов пока отсутствует, сохраните магазин. \n";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
