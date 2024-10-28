import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas yang merepresentasikan sebuah lagu.
 */
class Lagu {
    private String judul;
    private String penyanyi;
    private int durasi;

    /**
     * Konstruktor untuk objek Lagu.
     *
     * @param judul   Judul lagu.
     * @param penyanyi Penyanyi lagu.
     * @param durasi  Durasi lagu dalam detik.
     */
    public Lagu(String judul, String penyanyi, int durasi) {
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.durasi = durasi;
    }

    /**
     * Mengambil judul lagu.
     *
     * @return Judul lagu.
     */
    public String getJudul() {
        return judul;
    }

    /**
     * Mengambil penyanyi lagu.
     *
     * @return Penyanyi lagu.
     */
    public String getPenyanyi() {
        return penyanyi;
    }

    /**
     * Mengambil durasi lagu.
     *
     * @return Durasi lagu dalam detik.
     */
    public int getDurasi() {
        return durasi;
    }

    @Override
    public String toString() {
        return String.format("Lagu: %s, Penyanyi: %s, Durasi: %d detik", judul, penyanyi, durasi);
    }
}

/**
 * Kelas yang merepresentasikan sebuah playlist dari lagu-lagu.
 */
class Playlist {
    private List<Lagu> laguList;

    /**
     * Konstruktor untuk objek Playlist.
     */
    public Playlist() {
        laguList = new ArrayList<>();
    }

    /**
     * Menambahkan lagu ke dalam playlist.
     *
     * @param lagu Lagu yang akan ditambahkan.
     */
    public void tambahLagu(Lagu lagu) {
        laguList.add(lagu);
    }

    /**
     * Menghapus lagu dari playlist berdasarkan indeks.
     *
     * @param index Indeks lagu yang akan dihapus.
     */
    public void hapusLagu(int index) {
        if (index >= 0 && index < laguList.size()) {
            laguList.remove(index);
            System.out.println("Lagu berhasil dihapus.");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    /**
     * Menampilkan semua lagu dalam playlist.
     */
    public void tampilkanPlaylist() {
        if (laguList.isEmpty()) {
            System.out.println("1.Radio-Lanadelrey");
            System.out.println("2.Nice Dream-Radiohead");
            System.out.println("3.All I want-Kodaline");
            System.out.println("4.No Guidance-Chris Brown");
            System.out.println("5.Almost never enough-Ariana Grande");
        } else {
            System.out.println("Playlist:");
            for (int i = 0; i < laguList.size(); i++) {
                System.out.println(i + 1 + ". " + laguList.get(i));
            }
        }
    }

    /**
     * Menghitung total durasi semua lagu dalam playlist.
     *
     * @return Total durasi dalam detik.
     */
    public int totalDurasi() {
        return laguList.stream().mapToInt(Lagu::getDurasi).sum();
    }
}

/**
 * Kelas utama untuk menjalankan program.
 */
public class Main {
    /**
     * Metode utama untuk menjalankan program.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Lihat Playlist Lagu");
            System.out.println("2. Tambahkan Lagu ke dalam Playlist");
            System.out.println("3. Hapus Lagu dalam Playlist");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi (1-4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1:
                    playlist.tampilkanPlaylist();
                    System.out.println("Total Durasi Playlist: " + playlist.totalDurasi() + " detik");
                    break;
                case 2:
                    tambahLaguKePlaylist(playlist, scanner);
                    break;
                case 3:
                    hapusLaguDariPlaylist(playlist, scanner);
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }

    /**
     * Menambahkan lagu ke dalam playlist berdasarkan input pengguna.
     *
     * @param playlist Playlist tempat lagu akan ditambahkan.
     * @param scanner  Scanner untuk membaca input pengguna.
     */
    private static void tambahLaguKePlaylist(Playlist playlist, Scanner scanner) {
        System.out.print("Masukkan judul lagu: ");
        String judul = scanner.nextLine();

        System.out.print("Masukkan penyanyi: ");
        String penyanyi = scanner.nextLine();

        System.out.print("Masukkan durasi (dalam detik): ");
        int durasi = scanner.nextInt();
        scanner.nextLine(); // membersihkan newline

        playlist.tambahLagu(new Lagu(judul, penyanyi, durasi));
        System.out.println("Lagu berhasil ditambahkan.");
    }

    /**
     * Menghapus lagu dari playlist berdasarkan input pengguna.
     *
     * @param playlist Playlist tempat lagu akan dihapus.
     * @param scanner  Scanner untuk membaca input pengguna.
     */
    private static void hapusLaguDariPlaylist(Playlist playlist, Scanner scanner) {
        playlist.tampilkanPlaylist();
        System.out.print("Masukkan nomor lagu yang ingin dihapus: ");
        int index = scanner.nextInt() - 1; // mengurangi 1 untuk indeks array
        playlist.hapusLagu(index);
    }
}