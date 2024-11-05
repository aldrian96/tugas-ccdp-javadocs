import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas ToDoList mengelola daftar tugas yang dapat ditambahkan,
 * dihapus, dan ditampilkan kepada pengguna.
 */
public class ToDoList {
    private List<String> tasks;

    /**
     * Konstruktor untuk membuat objek ToDoList.
     * Menginisialisasi daftar tugas.
     */
    public ToDoList() {
        tasks = new ArrayList<>();
    }

    /**
     * Menambahkan tugas baru ke dalam daftar.
     *
     * @param task Tugas yang akan ditambahkan
     */
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Tugas ditambahkan: " + task);
    }

    /**
     * Menghapus tugas dari daftar berdasarkan indeks.
     *
     * @param index Indeks tugas yang akan dihapus
     * @throws IndexOutOfBoundsException jika indeks tidak valid
     */
    public void removeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Indeks tidak valid: " + index);
        }
        String removedTask = tasks.remove(index);
        System.out.println("Tugas dihapus: " + removedTask);
    }

    /**
     * Menampilkan semua tugas yang ada dalam daftar.
     */
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Daftar tugas kosong.");
        } else {
            System.out.println("Daftar Tugas:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    /**
     * Program utama untuk menjalankan To-Do List.
     * Program ini memberikan opsi kepada pengguna untuk
     * menambahkan, menghapus, dan menampilkan tugas.
     *
     * @param args Argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Hapus Tugas");
            System.out.println("3. Tampilkan Tugas");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi newline setelah nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Masukkan tugas baru: ");
                    String task = scanner.nextLine();
                    toDoList.addTask(task);
                    break;
                case 2:
                    toDoList.displayTasks();
                    System.out.print("Masukkan indeks tugas yang ingin dihapus: ");
                    int index = scanner.nextInt();
                    try {
                        toDoList.removeTask(index - 1); // Mengurangi 1 untuk mengonversi ke indeks 0
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Kesalahan: " + e.getMessage());
                    }
                    break;
                case 3:
                    toDoList.displayTasks();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
