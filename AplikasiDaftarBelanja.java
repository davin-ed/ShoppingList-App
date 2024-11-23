// NAMA  : EDGAR DAVIN DANUARTA
// NIM   : 235150701111039
// KELAS : TI-C
// MK    : ALGORITMA & STRUKTUR DATA

package ASDPROJECT;
import java.util.Scanner;

class AplikasiDaftarBelanja {
    private Scanner input;
    private DaftarBelanja daftarBelanja;
    
    public AplikasiDaftarBelanja() {
        input = new Scanner(System.in);
        daftarBelanja = new DaftarBelanja();
    }

    public void pesan() {
        System.out.println("Selamat datang di Aplikasi Pengurutan Daftar Belanja!");
    }

    public void perintah() {
        System.out.println("\nKetik nama barang Anda untuk menambah barang pada daftar.");
        System.out.println("Ketik '0hapus' untuk menghapus barang pada daftar.");
        System.out.println("Ketik '0urutkan' untuk melanjutkan ke metode pengurutan.");
        System.out.println("Ketik '0ulangi' kapan saja untuk mengulangi program.");
        System.out.println("Ketik '0keluar' kapan saja untuk menghentikan program.");
    }

    public void run() {
        inputBarang();
        pilihSort();
        showDaftarBelanja();
        actionMenu();
    }

    public void ubah() {
        pilihSort();
        showDaftarBelanja();
        actionMenu();
    }

    private void restart() {
        daftarBelanja = new DaftarBelanja();
        System.out.println("\nAplikasi diulang. Semua data daftar belanja telah dihapus.\n");
        System.out.println("----------------------------------------------------------\n");
        pesan();
        perintah();
        run();
    }

    private void inputBarang() {
        while (true) {
            System.out.print("\nMasukkan nama barang   : ");
            String namaInput = input.nextLine();

            if (namaInput.trim().isEmpty()) {
                System.out.println("Nama barang tidak boleh kosong. Silakan masukkan nama yang valid.");
                continue;
            }
            else if (namaInput.equalsIgnoreCase("0hapus")) {
                System.out.print("Masukkan nama barang yang ingin dihapus: ");
                String namaHapus = input.nextLine();
            
                if (daftarBelanja.hapusBarang(namaHapus)) {
                    System.out.println("Barang \"" + namaHapus + "\" berhasil dihapus dari daftar belanja.");
                }
                else {
                    System.out.println("Barang \"" + namaHapus + "\" tidak ditemukan di daftar belanja.");
                }

                continue;
            }
            else if (namaInput.equalsIgnoreCase("0urutkan")) {
                if (daftarBelanja.getDaftarBelanja().size() < 2) {
                    System.out.println("Anda harus memasukkan setidaknya 2 barang untuk melanjutkan.");
                    continue;
                }
                
                break;
            }
            else if (namaInput.equalsIgnoreCase("0ulangi")) {
                restart();
                return;
            }                
            else if (namaInput.equalsIgnoreCase("0keluar")) {
                System.out.println("\nTerima kasih telah menggunakan aplikasi ini!");
                System.exit(0);
            }

            if (daftarBelanja.isNamaBarangExist(namaInput)) {
                System.out.println("Barang \"" + namaInput + "\" sudah ada di daftar belanja.");
                continue;
            }

            int harga = inputHarga();
            int jumlah = inputJumlah();

            daftarBelanja.tambahBarang(new Barang(namaInput, harga, jumlah));
        }
    }
    
    private int inputHarga() {
        int harga = 0;

        while (true) {
            System.out.print("Masukkan harga barang  : Rp");
            String hargaInput = input.nextLine();

            if (hargaInput.trim().isEmpty()) {
                System.out.println("Harga barang tidak boleh kosong. Silakan masukkan harga yang valid.");
                continue;
            }
            else if (hargaInput.equalsIgnoreCase("0urutkan") || hargaInput.equalsIgnoreCase("0hapus")) {
                System.out.println("Anda harus memasukkan harga barang terlebih dahulu untuk melanjutkan.");
                continue;
            }
            else if (hargaInput.equalsIgnoreCase("0ulangi")) {
                restart();
                return 0;
            }                
            else if (hargaInput.equalsIgnoreCase("0keluar")) {
                System.out.println("\nTerima kasih telah menggunakan aplikasi ini!");
                System.exit(0);
            }

            try {
                harga = Integer.parseInt(hargaInput);
                if (harga < 1) {
                    System.out.println("Harga barang setidaknya Rp1. Silakan masukkan harga yang valid.");
                }
                else {
                    break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Harga barang harus berupa angka bulat. Silakan masukkan harga yang valid.");
            }
        }

        return harga;
    }
    
    private int inputJumlah() {
        int jumlah = 0;

        while (true) {
            System.out.print("Masukkan jumlah barang : ");
            String jumlahInput = input.nextLine();

            if (jumlahInput.trim().isEmpty()) {
                System.out.println("Jumlah barang tidak boleh kosong. Silakan masukkan jumlah yang valid.");
                continue;
            }
            else if (jumlahInput.equalsIgnoreCase("0urutkan") || jumlahInput.equalsIgnoreCase("0hapus")) {
                System.out.println("Anda harus memasukkan jumlah barang terlebih dahulu untuk melanjutkan.");
                continue;
            }
            else if (jumlahInput.equalsIgnoreCase("0ulangi")) {
                restart();
                return 0;
            }                
            else if (jumlahInput.equalsIgnoreCase("0keluar")) {
                System.out.println("\nTerima kasih telah menggunakan aplikasi ini!");
                System.exit(0);
            }

            try {
                jumlah = Integer.parseInt(jumlahInput);
                if (jumlah < 1) {
                    System.out.println("Jumlah barang setidaknya ada 1. Silakan masukkan jumlah yang valid.");
                }
                else {
                    break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Jumlah barang harus berupa angka bulat. Silakan masukkan jumlah yang valid.");
            }
        }
        
        return jumlah;
    }

    private void pilihSort() {
        int metode = pilihMetode();
        String key = pilihKey();
    
        switch (metode) {
            case 1:
                MetodeSort.selectionSortASC(daftarBelanja.getDaftarBelanja(), key);
                break;
            case 2:
                MetodeSort.selectionSortDESC(daftarBelanja.getDaftarBelanja(), key);
                break;
            case 3:
                MetodeSort.insertionSortASC(daftarBelanja.getDaftarBelanja(), key);
                break;
            case 4:
                MetodeSort.insertionSortDESC(daftarBelanja.getDaftarBelanja(), key);
                break;
            default:
                System.out.println("Pilihan metode tidak valid.");
                break;
        }
    }

    private int pilihMetode() {
        while (true) {
            System.out.println("\nPilih metode pengurutan:");
            System.out.println("1. Selection Sort, Ascending ");
            System.out.println("2. Selection Sort, Descending ");
            System.out.println("3. Insertion Sort, Ascending ");
            System.out.println("4. Insertion Sort, Descending ");
            System.out.print("Masukkan pilihan (1-4): ");

            String metodeInput = input.nextLine();

            if (metodeInput.trim().isEmpty()) {
                System.out.println("Pilihan tidak boleh kosong. Silakan masukkan angka 1-4");
                continue;
            }
            else if (metodeInput.equalsIgnoreCase("0ulangi")) {
                restart();
                return 0;
            }
            else if (metodeInput.equalsIgnoreCase("0keluar")) {
                System.out.print("\nTerima kasih telah menggunakan aplikasi ini!");
                System.exit(0);
            }

            try {
                int metode = Integer.parseInt(metodeInput);
                if (
                    metode == 1 ||
                    metode == 2 ||
                    metode == 3 ||
                    metode == 4
                    ) {
                    return metode;
                }
                else {
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
            }
        }
    }

    private String pilihKey() {
        while (true) {
            System.out.println("\nPilih pengurutan berdasarkan:");
            System.out.println("1. Nama barang");
            System.out.println("2. Harga barang");
            System.out.println("3. Jumlah barang");
            System.out.println("4. Total harga barang");
            System.out.print("Masukkan pilihan (1-4): ");

            String urutkanInput = input.nextLine();

            if (urutkanInput.trim().isEmpty()) {
                System.out.println("Pilihan tidak boleh kosong. Silakan masukkan angka 1-4");
                continue;
            }
            else if (urutkanInput.equalsIgnoreCase("0ulangi")) {
                restart();
                return "";
            }
            else if (urutkanInput.equalsIgnoreCase("0keluar")) {
                System.out.print("\nTerima kasih telah menggunakan aplikasi ini!");
                System.exit(0);
            }

            switch (urutkanInput) {
                case "1":
                    return "nama";
                case "2":
                    return "harga";
                case "3":
                    return "jumlah";
                case "4":
                    return "total";
                default :
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
            }
        }
    }

    private void showDaftarBelanja() {
        System.out.println("\nDaftar belanja setelah diurutkan:");

        for (Barang barang : daftarBelanja.getDaftarBelanja()) {
            System.out.println(
            "Barang : " + barang.getNama() +
            "\nHarga  : Rp" + barang.getHarga() +
            "\nJumlah : " + barang.getJumlah() +
            "\nTotal Harga : Rp" + barang.getHarga() * barang.getJumlah() +
            "\n"
            );
        }

        System.out.println("Total harga seluruh barang: " + daftarBelanja.hitungTotalSeluruh());
    }

    private void actionMenu() {
        while (true) {
            System.out.println("\nPilih menu:");
            System.out.println("1. Ubah daftar barang");
            System.out.println("2. Ubah metode urutan");
            System.out.println("3. Ulangi aplikasi");
            System.out.println("4. Keluar aplikasi");
            System.out.print("Masukkan pilihan (1-4): ");

            String menuInput = input.nextLine();

            if (menuInput.equals("1")) {
                perintah();
                run();
                break;
            }
            else if (menuInput.equals("2")) {
                ubah();
                break;
            }
            else if (menuInput.equals("3")) {
                restart();
                break;
            }
            else if (menuInput.equals("4")) {
                System.out.println("\nTerima kasih telah menggunakan aplikasi ini!");
                System.exit(0);
            }
            else {
                System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
            }
        }
    }
}