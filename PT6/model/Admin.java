package model;

import java.util.ArrayList;

public class Admin extends Akun {
    private static ArrayList<Admin> daftarAdmin = new ArrayList<>();

    public Admin(String id, String nama, String password, String noTelp) {
        super(id, nama, password, noTelp);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Admin ===");
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("No. Telp: " + noTelp);
    }

    @Override
    public void tambah(Akun akun) {
        try {
            if (akun == null) {
                System.out.println("Error: Data admin tidak boleh null.");
                return;
            }

            if (!(akun instanceof Admin)) {
                System.out.println("Error: Objek bukan tipe Admin.");
                return;
            }

            for (Admin a : daftarAdmin) {
                if (a.getId().equals(akun.getId())) {
                    System.out.println("Error: ID admin sudah ada.");
                    return;
                }
            }

            daftarAdmin.add((Admin) akun);
            System.out.println("Admin berhasil ditambahkan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan admin: " + e.getMessage());
        }
    }

    public static void tampilkanSemua() {
        if (daftarAdmin.isEmpty()) {
            System.out.println("Tidak ada data admin.");
            return;
        }

        for (Admin admin : daftarAdmin) {
            admin.tampilkanInfo();
            System.out.println("----------------------");
        }
    }

    @Override
    public void update(String id, String namaBaru, String noTelpBaru) {
        try {
            Admin target = null;
            for (Admin admin : daftarAdmin) {
                if (admin.getId().equals(id)) {
                    target = admin;
                    break;
                }
            }

            if (target == null) {
                System.out.println("Error: Admin dengan ID tersebut tidak ditemukan.");
                return;
            }

            if (namaBaru == null || namaBaru.isEmpty() || noTelpBaru == null || noTelpBaru.isEmpty()) {
                System.out.println("Error: Nama dan no. telp tidak boleh kosong.");
                return;
            }

            target.setNama(namaBaru);
            target.setNoTelp(noTelpBaru);
            System.out.println("Admin berhasil diperbarui.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mengupdate admin: " + e.getMessage());
        }
    }

    @Override
    public void hapus(String id) {
        try {
            boolean berhasil = daftarAdmin.removeIf(admin -> admin.getId().equals(id));
            if (berhasil) {
                System.out.println("Admin berhasil dihapus.");
            } else {
                System.out.println("ID tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus admin: " + e.getMessage());
        }
    }

    public static ArrayList<Admin> getDaftarAdmin() {
        return daftarAdmin;
    }
}
