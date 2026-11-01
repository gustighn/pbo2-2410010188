/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gusti
 */
public class Perpustakaan {

    private final List<Koleksi> daftarKoleksi = new ArrayList<>();
    private final Map<String, Anggota> peminjam = new HashMap<>();

    public void tambah(Koleksi koleksi) {
        if (cari(koleksi.getKode()) != null) {
            throw new IllegalArgumentException(
                    "Kode koleksi sudah digunakan");
        }

        daftarKoleksi.add(koleksi);
    }

    public Koleksi cari(String kode) {
        for (Koleksi k : daftarKoleksi) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }

    public boolean ubah(String kodeLama, Buku bukuBaru) {
        for (int i = 0; i < daftarKoleksi.size(); i++) {
            Koleksi lama = daftarKoleksi.get(i);

            if (lama.getKode().equalsIgnoreCase(kodeLama)) {

                Koleksi duplikat = cari(bukuBaru.getKode());

                if (duplikat != null && duplikat != lama) {
                    return false;
                }

                daftarKoleksi.set(i, bukuBaru);
                return true;
            }
        }
        return false;
    }

    public boolean hapus(String kode) {
        Koleksi koleksi = cari(kode);

        if (koleksi == null) {
            return false;
        }

        daftarKoleksi.remove(koleksi);
        peminjam.remove(kode);
        return true;
    }

    public boolean adaKode(String kode) {
        return cari(kode) != null;
    }

    public boolean pinjam(String kode, Anggota anggota) {
        Koleksi koleksi = cari(kode);

        if (koleksi == null || !koleksi.pinjam()) {
            return false;
        }

        peminjam.put(kode, anggota);
        return true;
    }

    public long kembalikan(String kode, int hariTerlambat) {
        Koleksi koleksi = cari(kode);

        if (koleksi == null
                || koleksi.getStatus() == StatusKoleksi.TERSEDIA) {
            return 0;
        }

        koleksi.kembalikan();
        peminjam.remove(kode);
        return koleksi.hitungDenda(hariTerlambat);
    }

    public Anggota getPeminjam(String kode) {
        return peminjam.get(kode);
    }

    public int jumlahTersedia() {
        int jumlah = 0;

        for (Koleksi k : daftarKoleksi) {
            if (k.getStatus() == StatusKoleksi.TERSEDIA) {
                jumlah++;
            }
        }

        return jumlah;
    }

    public List<Koleksi> getDaftarKoleksi() {
        return List.copyOf(daftarKoleksi);
    }

    public List<Koleksi> cariJudul(String kataKunci) {
        List<Koleksi> hasil = new ArrayList<>();

        String kata = kataKunci.toLowerCase();

        for (Koleksi k : daftarKoleksi) {
            if (k.getJudul().toLowerCase().contains(kata)) {
                hasil.add(k);
            }
        }

        return hasil;
    }
}
