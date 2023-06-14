package src.model.fileManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileManager<E> implements Writable<E>{


    @Override
    public void save(E e, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(e);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public E read(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            E result = (E) objectInputStream.readObject();
            objectInputStream.close();
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
