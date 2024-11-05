import java.util.Scanner;

/**
 * Kelas Rectangle merepresentasikan persegi panjang
 * dan menyediakan metode untuk menghitung luas dan keliling.
 */
public class Rectangle {
    private double length;
    private double width;

    /**
     * Konstruktor untuk membuat objek Rectangle.
     *
     * @param length Panjang persegi panjang
     * @param width  Lebar persegi panjang
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Menghitung luas persegi panjang.
     *
     * @return Luas persegi panjang
     */
    public double calculateArea() {
        return length * width;
    }

    /**
     * Menghitung keliling persegi panjang.
     *
     * @return Keliling persegi panjang
     */
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    /**
     * Mendapatkan panjang persegi panjang.
     *
     * @return Panjang persegi panjang
     */
    public double getLength() {
        return length;
    }

    /**
     * Mendapatkan lebar persegi panjang.
     *
     * @return Lebar persegi panjang
     */
    public double getWidth() {
        return width;
    }

    /**
     * Menentukan panjang persegi panjang.
     *
     * @param length Panjang baru untuk persegi panjang
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Menentukan lebar persegi panjang.
     *
     * @param width Lebar baru untuk persegi panjang
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Program utama untuk menguji kelas Rectangle dengan input dari pengguna.
     * Program ini meminta pengguna memasukkan panjang dan lebar persegi panjang,
     * lalu menampilkan luas dan keliling yang dihitung.
     *
     * @param args Argumen baris perintah
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta pengguna memasukkan panjang
        System.out.print("Masukkan panjang persegi panjang: ");
        double length = scanner.nextDouble();

        // Meminta pengguna memasukkan lebar
        System.out.print("Masukkan lebar persegi panjang: ");
        double width = scanner.nextDouble();

        // Membuat objek Rectangle dengan panjang dan lebar yang dimasukkan pengguna
        Rectangle rect = new Rectangle(length, width);

        // Menampilkan hasil perhitungan
        System.out.println("Panjang: " + rect.getLength());
        System.out.println("Lebar: " + rect.getWidth());
        System.out.println("Luas: " + rect.calculateArea());
        System.out.println("Keliling: " + rect.calculatePerimeter());

        scanner.close();
    }
}
