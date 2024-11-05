import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas Product merepresentasikan produk dengan nama dan harga.
 */
class Product {
    private String name;
    private double price;

    /**
     * Konstruktor untuk membuat objek Product.
     *
     * @param name  Nama produk
     * @param price Harga produk
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Mendapatkan nama produk.
     *
     * @return Nama produk
     */
    public String getName() {
        return name;
    }

    /**
     * Mendapatkan harga produk.
     *
     * @return Harga produk
     */
    public double getPrice() {
        return price;
    }

    /**
     * Mengubah harga produk.
     *
     * @param price Harga baru untuk produk
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Nama: " + name + ", Harga: " + price;
    }
}

/**
 * Kelas Inventory mengelola daftar produk dalam inventaris.
 */
public class Inventory {
    private List<Product> products;

    /**
     * Konstruktor untuk membuat objek Inventory.
     * Menginisialisasi daftar produk.
     */
    public Inventory() {
        products = new ArrayList<>();
    }

    /**
     * Menambahkan produk baru ke dalam inventaris.
     *
     * @param product Produk yang akan ditambahkan
     */
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Produk ditambahkan: " + product.getName());
    }

    /**
     * Menghapus produk dari inventaris berdasarkan indeks.
     *
     * @param index Indeks produk yang akan dihapus
     * @throws IndexOutOfBoundsException jika indeks tidak valid
     */
    public void removeProduct(int index) {
        if (index < 0 || index >= products.size()) {
            throw new IndexOutOfBoundsException("Indeks tidak valid: " + index);
        }
        Product removedProduct = products.remove(index);
        System.out.println("Produk dihapus: " + removedProduct.getName());
    }

    /**
     * Menampilkan semua produk dalam inventaris.
     */
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventaris kosong.");
        } else {
            System.out.println("Daftar Produk:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
        }
    }

    /**
     * Program utama untuk menjalankan manajemen inventaris.
     * Program ini memberikan opsi kepada pengguna untuk
     * menambahkan, menghapus, dan menampilkan produk.
     *
     * @param args Argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Hapus Produk");
            System.out.println("3. Tampilkan Produk");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi newline setelah nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama produk: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan harga produk: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(name, price);
                    inventory.addProduct(product);
                    break;
                case 2:
                    inventory.displayProducts();
                    System.out.print("Masukkan indeks produk yang ingin dihapus: ");
                    int index = scanner.nextInt();
                    try {
                        inventory.removeProduct(index - 1); // Mengurangi 1 untuk mengonversi ke indeks 0
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Kesalahan: " + e.getMessage());
                    }
                    break;
                case 3:
                    inventory.displayProducts();
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
