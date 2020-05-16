import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    static int counterOfResumes = 0;

    void clear() {
        Arrays.fill(storage, 0, 9999, null);
    }

    void save(Resume r) {
        if (counterOfResumes < storage.length) {
            storage[counterOfResumes] = r;
            counterOfResumes++;
        } else System.out.println("Сохранение резюме невозможно, база переполнена.");
    }

    Resume get(String uuid) {
        for (int i = 0; i < counterOfResumes; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int bin = 0;
        for (int i = 0; i < counterOfResumes; i++) {
            if (uuid.equals(storage[i].toString())) {
                bin = i;
            }
        }
        storage[bin] = null;

        for (int i = 0; i < counterOfResumes; i++) {
            if (i > bin) {
                storage[i - 1] = storage[i];
            }
        }
        counterOfResumes--;
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, counterOfResumes);
    }

    int size() {
        return counterOfResumes;
    }
}


