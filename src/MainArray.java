import java.util.Arrays;

public class MainArray {
    public static void main(String[] args) {
        ArrayStorage storage = new ArrayStorage();

        for (int i = 0; i < storage.sizeOfStorage()- 9990; i++) {
            storage.saveResume(new Resume(i, "kolya", 41));
        }
        System.out.println(storage.sizeOfStorage());
        storage.deleteResume(5);
        System.out.println(storage.getResume(6).toString());
        System.out.println(storage.getAllResumes());
        storage.clearStorage();
    }
}
