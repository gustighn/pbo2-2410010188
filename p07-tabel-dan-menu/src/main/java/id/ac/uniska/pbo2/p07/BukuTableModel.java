/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gusti
 */
public class BukuTableModel extends AbstractTableModel {

    private final Perpustakaan perpustakaan;

    private final String[] kolom = {
        "Kode", "Judul", "Penulis",
        "Tahun Terbit", "Status"
    };

    public BukuTableModel(Perpustakaan perpustakaan) {
        this.perpustakaan = perpustakaan;
    }

    @Override
    public int getRowCount() {
        return perpustakaan.getDaftarKoleksi().size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolom[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Buku buku = (Buku) perpustakaan
                .getDaftarKoleksi().get(row);

        return switch (column) {
            case 0 ->
                buku.getKode();
            case 1 ->
                buku.getJudul();
            case 2 ->
                buku.getPenulis();
            case 3 ->
                buku.getTahunTerbit();
            case 4 ->
                buku.getStatus();
            default ->
                null;
        };
    }

    public Buku getBuku(int row) {
        return (Buku) perpustakaan
                .getDaftarKoleksi().get(row);
    }

    public void tambah(Buku buku) {
        int row = getRowCount();

        perpustakaan.tambah(buku);

        fireTableRowsInserted(row, row);
    }

    public boolean ubah(String kodeLama, Buku bukuBaru) {
        int row = -1;

        for (int i = 0; i < getRowCount(); i++) {
            if (getBuku(i).getKode().equalsIgnoreCase(kodeLama)) {
                row = i;
                break;
            }
        }

        if (row < 0 || !perpustakaan.ubah(kodeLama, bukuBaru)) {
            return false;
        }

        fireTableRowsUpdated(row, row);
        return true;
    }

    public void hapus(int row) {
        String kode = getBuku(row).getKode();

        if (perpustakaan.hapus(kode)) {
            fireTableRowsDeleted(row, row);
        }
    }

    public int jumlahTersedia() {
        return perpustakaan.jumlahTersedia();
    }
}
