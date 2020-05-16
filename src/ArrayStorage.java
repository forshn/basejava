import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    static int countOfArrays = 0;

    void clear() {
        Arrays.fill(storage, 0, 9999, null);
    }

    void save(Resume r) {
        if (countOfArrays < storage.length) {
            storage[countOfArrays] = r;
            countOfArrays++;
        } else System.out.println("Сохранение резюме невозможно, база переполнена.");
    }

    Resume get(String uuid) {
        for (int i = 0; i < countOfArrays; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int bin = 0;
        for (int i = 0; i < countOfArrays; i++) {
            if (uuid.equals(storage[i].toString())) {
                bin = i;
            }
        }
        storage[bin] = null;

        for (int i = 0; i < countOfArrays; i++) {
            if (i > bin) {
                storage[i - 1] = storage[i];
            }
        }
        countOfArrays--;
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, countOfArrays);
    }

    int size() {
        return countOfArrays;
    }
}


