// NAMA  : EDGAR DAVIN DANUARTA
// NIM   : 235150701111039
// KELAS : TI-C
// MK    : ALGORITMA & STRUKTUR DATA

package ASDPROJECT;

class Barang {
    private String nama;
    private int harga;
    private int jumlah;

    public Barang(String nama, int harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getTotal() {
        return harga * jumlah;
    }
}