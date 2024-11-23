// NAMA  : EDGAR DAVIN DANUARTA
// NIM   : 235150701111039
// KELAS : TI-C
// MK    : ALGORITMA & STRUKTUR DATA

package ASDPROJECT;
import java.util.ArrayList;

class DaftarBelanja {
    private ArrayList<Barang> daftarBelanja;

    public DaftarBelanja() {
        this.daftarBelanja = new ArrayList<>();
    }

    public ArrayList<Barang> getDaftarBelanja() {
        return this.daftarBelanja;
    }

    public void tambahBarang(Barang barang) {
        this.daftarBelanja.add(barang);
    }

    public boolean hapusBarang(String namaBarang) {
        for (int i = 0; i < daftarBelanja.size(); i++) {
            
            if (daftarBelanja.get(i).getNama().equalsIgnoreCase(namaBarang)) {
                daftarBelanja.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean isNamaBarangExist(String namaBarang) {
        for (Barang barang : this.getDaftarBelanja()) {

            if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                return true;
            }
        }

        return false;
    }

    public int hitungTotalSeluruh() {
        int totalSeluruh = 0;

        for (Barang barang : daftarBelanja) {
            totalSeluruh += barang.getHarga() * barang.getJumlah();
        }

        return totalSeluruh;
    }
}