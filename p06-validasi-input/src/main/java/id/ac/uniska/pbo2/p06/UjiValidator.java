/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p06;

/**
 *
 * @author gusti
 */
public class UjiValidator {

    private static int gagal = 0;

    private static void cek(
            String namaPengujian,
            String hasil,
            boolean harusValid) {

        boolean valid = (hasil == null);

        if (valid != harusValid) {
            gagal++;
        }

        String status = (valid == harusValid)
                ? "SESUAI"
                : "SALAH";

        System.out.println(
                status + " | " + namaPengujian
                + " | " + (valid ? "Valid" : hasil)
        );
    }

    public static void main(String[] args) {

        System.out.println("=== PENGUJIAN VALIDATOR ===");

        // Pengujian NPM
        cek("NPM kosong",
                Validator.npm(""), false);

        cek("NPM kurang dari 10 digit",
                Validator.npm("12345"), false);

        cek("NPM mengandung huruf",
                Validator.npm("24100101ab"), false);

        cek("NPM benar",
                Validator.npm("2410010123"), true);

        // Pengujian Nama
        cek("Nama kosong",
                Validator.nama(""), false);

        cek("Nama kurang dari 3 karakter",
                Validator.nama("Al"), false);

        cek("Nama mengandung angka",
                Validator.nama("Gusti123"), false);

        cek("Nama benar",
                Validator.nama("Gusti Ghani"), true);

        // Pengujian Email
        cek("Email kosong",
                Validator.email(""), false);

        cek("Email tidak lengkap",
                Validator.email("siti@"), false);

        cek("Email benar",
                Validator.email("siti@gmail.com"), true);

        // Pengujian Nomor HP
        cek("Nomor HP kosong",
                Validator.nomorHp(""), false);

        cek("Nomor HP terlalu pendek",
                Validator.nomorHp("0812"), false);

        cek("Nomor HP diawali 62",
                Validator.nomorHp("6281234567890"), false);

        cek("Nomor HP benar",
                Validator.nomorHp("081234567890"), true);

        System.out.println();
        System.out.println("Jumlah pengujian gagal: " + gagal);

        if (gagal == 0) {
            System.out.println(
                    "Semua pengujian berhasil!"
            );
        } else {
            System.out.println(
                    "Masih terdapat pengujian yang gagal."
            );
        }
    }
}