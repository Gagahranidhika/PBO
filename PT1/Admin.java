import java.util.ArrayList;

// Entitas Admin
class Admin {
    String id_admin;
    String nama;
    String password;
    String no_telp;

    public Admin(String id_admin, String nama, String password, String no_telp) {
        this.id_admin = id_admin;
        this.nama = nama;
        this.password = password;
        this.no_telp = no_telp;
    }
}

// Manager untuk Admin
class AdminManager {
    private ArrayList<Admin> admins = new ArrayList<>();

    public void addAdmin(Admin admin) {

        for (Admin a : admins) {
            if (a.id_admin.equals(admin.id_admin)) {
                System.out.println("Error: ID Admin " + admin.id_admin + " sudah ada. Data tidak ditambahkan.");
                return; 
            }
        }

        admins.add(admin);
        System.out.println("Admin berhasil ditambahkan.");
    }

    public void viewAdmins() {
        for (Admin admin : admins) {
            System.out.println("ID Admin: " + admin.id_admin + ", Nama: " + admin.nama + ", No. Telp: " + admin.no_telp);
        }
    }

    public void updateAdmin(String id_admin, String nama, String password, String no_telp) {
        for (Admin admin : admins) {
            if (admin.id_admin.equals(id_admin)) {
                admin.nama = nama;
                admin.password = password;
                admin.no_telp = no_telp;
                return;
            }
        }
    }

    public void deleteAdmin(String id_admin) {
        admins.removeIf(admin -> admin.id_admin.equals(id_admin));
    }
}