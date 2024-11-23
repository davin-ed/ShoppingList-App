// NAMA  : EDGAR DAVIN DANUARTA
// NIM   : 235150701111039
// KELAS : TI-C
// MK    : ALGORITMA & STRUKTUR DATA

package ASDPROJECT;
import java.util.ArrayList;

class MetodeSort {
    // METODE SELECTION SORT SECARA ASCENDING (KECIL KE BESAR)
    public static void selectionSortASC(ArrayList<Barang> daftarBelanja, String key) {
        for (int i = 0; i < daftarBelanja.size(); i++) {
            int minIdx = i;

            for (int j = i + 1; j < daftarBelanja.size(); j++) {
                switch (key) {
                    case "nama":
                        if (daftarBelanja.get(j).getNama().compareToIgnoreCase(daftarBelanja.get(minIdx).getNama()) < 0) {
                            minIdx = j;
                        }
                        break;
                    case "harga":
                        if (daftarBelanja.get(j).getHarga() < daftarBelanja.get(minIdx).getHarga()) {
                            minIdx = j;
                        }
                        break;
                    case "jumlah":
                        if (daftarBelanja.get(j).getJumlah() < daftarBelanja.get(minIdx).getJumlah()) {
                            minIdx = j;
                        }
                        break;
                    case "total":
                        if (daftarBelanja.get(j).getTotal() < daftarBelanja.get(minIdx).getTotal()) {
                            minIdx = j;
                        }
                        break;
                }
            }

            Barang temp = daftarBelanja.get(i);
            daftarBelanja.set(i, daftarBelanja.get(minIdx));
            daftarBelanja.set(minIdx, temp);
        }
    }

    // METODE SELECTION SORT SECARA DESCENDING (BESAR KE KECIL)
    public static void selectionSortDESC(ArrayList<Barang> daftarBelanja, String key) {
        for (int i = 0; i < daftarBelanja.size(); i++) {
            int maxIdx = i;

            for (int j = i + 1; j < daftarBelanja.size(); j++) {
                switch (key) {
                    case "nama":
                        if (daftarBelanja.get(j).getNama().compareToIgnoreCase(daftarBelanja.get(maxIdx).getNama()) > 0) {
                            maxIdx = j;
                        }
                        break;
                    case "harga":
                        if (daftarBelanja.get(j).getHarga() > daftarBelanja.get(maxIdx).getHarga()) {
                            maxIdx = j;
                        }
                        break;
                    case "jumlah":
                        if (daftarBelanja.get(j).getJumlah() > daftarBelanja.get(maxIdx).getJumlah()) {
                            maxIdx = j;
                        }
                        break;
                    case "total":
                        if (daftarBelanja.get(j).getTotal() > daftarBelanja.get(maxIdx).getTotal()) {
                            maxIdx = j;
                        }
                        break;
                }
            }

            Barang temp = daftarBelanja.get(i);
            daftarBelanja.set(i, daftarBelanja.get(maxIdx));
            daftarBelanja.set(maxIdx, temp);
        }
    }

    // METODE INSERTION SORT SECARA ASCENDING (KECIL KE BESAR)
    public static void insertionSortASC(ArrayList<Barang> daftarBelanja, String key) {
        for (int i = 1; i < daftarBelanja.size(); i++) {
            Barang current = daftarBelanja.get(i);
            int j = i - 1;

            while (j >= 0 && (
            (key.equals("nama") && daftarBelanja.get(j).getNama().compareTo(current.getNama()) > 0) ||
            (key.equals("harga") && daftarBelanja.get(j).getHarga() > current.getHarga()) ||
            (key.equals("jumlah") && daftarBelanja.get(j).getJumlah() > current.getJumlah()) ||
            (key.equals("total") && daftarBelanja.get(j).getTotal() > current.getTotal())
            )) {
                daftarBelanja.set(j + 1, daftarBelanja.get(j));
                j--;
            }

            daftarBelanja.set(j + 1, current);
        }
    }

    // METODE INSERTION SORT SECARA DESCENDING (BESAR KE KECIL)
    public static void insertionSortDESC(ArrayList<Barang> daftarBelanja, String key) {
        for (int i = 1; i < daftarBelanja.size(); i++) {
            Barang current = daftarBelanja.get(i);
            int j = i - 1;

            while (j >= 0 && (
            (key.equals("nama") && daftarBelanja.get(j).getNama().compareTo(current.getNama()) < 0) ||
            (key.equals("harga") && daftarBelanja.get(j).getHarga() < current.getHarga()) ||
            (key.equals("jumlah") && daftarBelanja.get(j).getJumlah() < current.getJumlah()) ||
            (key.equals("total") && daftarBelanja.get(j).getTotal() < current.getTotal())
            )) {
                daftarBelanja.set(j + 1, daftarBelanja.get(j));
                j--;
            }

            daftarBelanja.set(j + 1, current);
        }
    }
}