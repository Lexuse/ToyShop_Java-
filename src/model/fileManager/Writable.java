package src.model.fileManager;

public interface Writable<E> {
    void save(E e, String fileName);
    E read(String fileName);
}
