package src.model.fileManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable<E> {
    void save(E e, String fileName) throws IOException;
    E read(String fileName) throws IOException, ClassNotFoundException;
}
