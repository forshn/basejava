import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private static int countOfArrays = 0;

    public void saveResume(Resume resume){
        storage[countOfArrays] = resume;
        countOfArrays++;
    }

    public Resume getResume(int index){
        return storage[index];
    }

    public void deleteResume(int index){
        storage[index] = null;
        countOfArrays--;
    }

    public int sizeOfStorage(){
        return countOfArrays;
    }

    public String clearStorage(){
        Arrays.fill(storage, 0, 10000, 0);
        return "База данных резюме очищена";
    }

    public String getAllResumes(){
        return Arrays.toString(Arrays.copyOf(storage,countOfArrays));
    }
}
