import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioheadCafe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> pesanan = new ArrayList<>();
        List<Integer> harga = new ArrayList<>();
        String lagi = null;

        System.out.println("===== Daftar Menu =====");
        System.out.println("1. Creep Burger   Rp 15.000");
        System.out.println("2. Karma Police Pasta  Rp 25.000");
        System.out.println("3. No Surprises Salad Rp 20.000");
        System.out.println("4. High and Dry Smoothie Rp 15.000");
        System.out.println("5. Pyramid Song Pizza Rp 50.000");
        System.out.println("6. Everything In Its Right Place Coffee Rp 10.000");

        do {
            System.out.print("Masukkan nomor pesanan (1-6): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    pesanan.add("Creep Burger");
                    harga.add(15000);
                    break;
                case 2:
                    pesanan.add("Karma Police Pasta");
                    harga.add(25000);
                    break;
                case 3:
                    pesanan.add("No Surprises Salad");
                    harga.add(20000);
                    break;
                case 4:
                    pesanan.add("High and Dry Smoothie");
                    harga.add(15000);
                    break;
                case 5:
                    pesanan.add("Pyramid Song Pizza");
                    harga.add(50000);
                    break;
                case 6:
                    pesanan.add("Everything In Its Right Place Coffee");
                    harga.add(10000);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    continue; // Kembali ke awal loop jika pilihan tidak valid
            }

            System.out.print("Apakah Anda ingin menambah pesanan? (ya/tidak): ");
            lagi = scanner.next();
        } while (lagi.equalsIgnoreCase("ya"));
        
        // Menampilkan pesanan dan total harga
        System.out.println("\n===== Pesanan Anda =====");
        int total = 0;
        for (int i = 0; i < pesanan.size(); i++) {
            System.out.printf("%s - Rp %d\n", pesanan.get(i), harga.get(i));
            total += harga.get(i);
        }
        System.out.printf("Total: Rp %d\n", total);
        System.out.println("=========================");

        scanner.close();
    }
}