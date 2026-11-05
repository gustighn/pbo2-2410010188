/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.uts;

/**
 *
 * Nama : Gusti Muhammad Abdul Ghani
 * NPM  : 2410010188
 */
public enum Kategori {

    ALAT_TULIS("Alat Tulis"),
    MAKANAN("Makanan"),
    MINUMAN("Minuman"),
    LAINNYA("Lainnya");

    private final String label;

    Kategori(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static Kategori dariLabel(String label) {
        for (Kategori kategori : values()) {
            if (kategori.label.equals(label)) {
                return kategori;
            }
        }

        return LAINNYA;
    }
}