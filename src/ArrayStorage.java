import sun.security.util.ArrayUtil;

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    static int countOfArrays = 0;

    void clear() {
        Arrays.fill(storage, 0, 9999, null);
        System.out.println("База данных резюме очищена");
    }

    void save(Resume r) {
        if (countOfArrays < 10000) {
            storage[countOfArrays] = r;
            countOfArrays++;
        } else System.out.println("Сохранение резюме невозможно, база переполнена.");
    }

    Resume get(String uuid) {
        for (Resume s : storage) {
            if (uuid.equals(s.toString())) {
                return s;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (Resume s : storage) {
            if (uuid.equals(s.toString())) {
                s = null;
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


