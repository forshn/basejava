import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    static int countOfArrays = 0;

    public void saveResume(Resume resume) {
        if (countOfArrays < 10000) {
            storage[countOfArrays] = resume;
            countOfArrays++;
        } else System.out.println("Сохранение резюме невозможно, база переполнена.");
    }

    public Resume getResume(int index) {
        return storage[index];
    }

    public void deleteResume(int index) {
        storage[index] = null;
        countOfArrays--;
    }

    public int sizeOfStorage() {
        return storage.length;
    }

    public void clearStorage() {
        Arrays.fill(storage, 0, 9999, null);
        System.out.println("База данных резюме очищена");
    }

    public String getAllResumes() {
        return Arrays.toString(Arrays.copyOf(storage, countOfArrays));
    }
}
