import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int counterOfResumes = 0;

    void clear() {
        Arrays.fill(storage, 0, counterOfResumes, null);
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
        int index = 0;
        for (int i = index; i < counterOfResumes; i++) {
            if (uuid.equals(storage[i].toString())) {
                index = i;
                storage[index] = null;
                System.arraycopy(storage, index + 1, storage, index, counterOfResumes - index);
                counterOfResumes--;
            }
        }
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, counterOfResumes);
    }

    int size() {
        return counterOfResumes;
    }
}


