import java.util.ArrayList;

public class Admin {
    // Private fields 
    private String idAdmin;
    private String nama;
    private String password;
    // Protected field untuk no telpon
    protected String noTelp;

    // Public constructor
    public Admin(String idAdmin, String nama, String password, String noTelp) {
        this.idAdmin = idAdmin;
        this.nama = nama;
        this.password = password;
        this.noTelp = noTelp;
    }

    // Public getters
    public String getIdAdmin() {
        return idAdmin;
    }

    public String getNama() {
        return nama;
    }

    // Protected getter untuk no telpon
    protected String getNoTelp() {
        return noTelp;
    }

    // Private getter untuk password (hanya untuk internal class)
    private String getPassword() {
        return password;
    }

    // Public setters dengan validasi
    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        }
    }

    public void setNoTelp(String noTelp) {
        if (noTelp != null && noTelp.matches("\\d+")) {
            this.noTelp = noTelp;
        }
    }

    // Protected method untuk mengubah password
    protected void setPassword(String password) {
        if (password != null && password.length() >= 4) {
            this.password = password;
        }
    }

    // Public method untuk verifikasi password
    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Public method untuk menampilkan info admin (tanpa password)
    public void displayInfo() {
        System.out.println("ID Admin: " + idAdmin);
        System.out.println("Nama: " + nama);
        System.out.println("No. Telp: " + noTelp);
    }
}

class AdminManager {
    private ArrayList<Admin> admins = new ArrayList<>();

    // Constructor untuk membuat akun default
    public AdminManager() {
        // Akun default
        addAdmin(new Admin("admin", "Administrator", "admin", "08123"));
    }

    // Public method untuk menambah admin
    public void addAdmin(Admin admin) {
        if (admin == null) {
            System.out.println("Error: Admin tidak valid");
            return;
        }

        for (Admin a : admins) {
            if (a.getIdAdmin().equals(admin.getIdAdmin())) {
                System.out.println("Error: ID Admin " + admin.getIdAdmin() + " sudah ada");
                return;
            }
        }

        admins.add(admin);
        System.out.println("Admin berhasil ditambahkan");
    }

    // Public method untuk melihat daftar admin
    public void viewAdmins() {
        if (admins.isEmpty()) {
            System.out.println("Belum ada admin terdaftar");
            return;
        }

        for (Admin admin : admins) {
            admin.displayInfo();
            System.out.println("-------------------");
        }
    }

    // Protected method untuk update admin
    protected void updateAdmin(String idAdmin, String nama, String password, String noTelp) {
        for (Admin admin : admins) {
            if (admin.getIdAdmin().equals(idAdmin)) {
                admin.setNama(nama);
                admin.setPassword(password);
                admin.setNoTelp(noTelp);
                System.out.println("Admin berhasil diupdate");
                return;
            }
        }
        System.out.println("Admin dengan ID " + idAdmin + " tidak ditemukan");
    }

    // Public method untuk menghapus admin
    public void deleteAdmin(String idAdmin) {
        if (idAdmin.equals("admin")) {
            System.out.println("Error: Tidak dapat menghapus akun default admin");
            return;
        }

        boolean removed = admins.removeIf(admin -> admin.getIdAdmin().equals(idAdmin));
        System.out.println(removed ? "Admin berhasil dihapus" : "Admin tidak ditemukan");
    }

    // untuk login
    public boolean login(String idAdmin, String password) {
        for (Admin admin : admins) {
            if (admin.getIdAdmin().equals(idAdmin) && admin.verifyPassword(password)) {
                return true;
            }
        }
        return false;
    }
    
    public Admin findAdminById(String idAdmin) {
        for (Admin admin : admins) {
            if (admin.getIdAdmin().equals(idAdmin)) {
                return admin;
            }
        }
        return null;
    }
}