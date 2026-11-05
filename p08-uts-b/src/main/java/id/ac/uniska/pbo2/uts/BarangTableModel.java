/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.uts;

import java.util.List;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * Nama : Gusti Muhammad Abdul Ghani
 * NPM  : 2410010188
 */
public class BarangTableModel extends AbstractTableModel {

    private static final String[] KOLOM = {
        "Nama Barang",
        "Kategori",
        "Harga",
        "Jumlah",
        "Subtotal"
    };

    private final List<Barang> daftar = new ArrayList<>();

    private final NumberFormat rupiah =
            NumberFormat.getInstance(new Locale("id", "ID"));

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    @Override
    public Object getValueAt(int baris, int kolom) {

        Barang barang = daftar.get(baris);

        return switch (kolom) {
            case 0 -> barang.getNama();
            case 1 -> barang.getKategori();
            case 2 -> "Rp" + rupiah.format(barang.getHarga());
            case 3 -> barang.getJumlah();
            case 4 -> "Rp" + rupiah.format(barang.getSubtotal());
            default -> null;
        };
    }

    public Barang get(int baris) {
        return daftar.get(baris);
    }

    public void tambah(Barang barang) {

        daftar.add(barang);

        int baris = daftar.size() - 1;

        fireTableRowsInserted(baris, baris);
    }

    public boolean sudahAda(String nama) {

        for (Barang barang : daftar) {

            if (barang.getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }

        return false;
    }

    public long getTotal() {

        long total = 0;

        for (Barang barang : daftar) {
            total += barang.getSubtotal();
        }

        return total;
    }

    public long getDiskon() {

        if (getTotal() >= 100000) {
            return getTotal() / 10;
        }

        return 0;
    }

    public long getBayar() {
        return getTotal() - getDiskon();
    }
}
