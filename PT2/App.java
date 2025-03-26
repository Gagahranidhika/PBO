import java.util.Scanner;

public class App {
    private static AdminManager adminManager = new AdminManager();
    private static StafManager stafManager = new StafManager();
    private static HewanManager hewanManager = new HewanManager();
    private static KandangManager kandangManager = new KandangManager();
    private static PakanManager pakanManager = new PakanManager();
    private static KesehatanHewanManager kesehatanHewanManager = new KesehatanHewanManager();
    private static JadwalPakanManager jadwalPakanManager = new JadwalPakanManager();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== SISTEM PENGELOLAAN KEBUN BINATANG LESTARI ZOO ===");
            System.out.println("1. Kelola Data Admin");
            System.out.println("2. Kelola Data Staf");
            System.out.println("3. Kelola Data Hewan");
            System.out.println("4. Kelola Data Kandang");
            System.out.println("5. Kelola Data Pakan");
            System.out.println("6. Kelola Riwayat Kesehatan Hewan");
            System.out.println("7. Kelola Jadwal Pemberian Pakan");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    manageAdmin(scanner);
                    break;
                case 2:
                    manageStaf(scanner);
                    break;
                case 3:
                    manageHewan(scanner);
                    break;
                case 4:
                    manageKandang(scanner);
                    break;
                case 5:
                    managePakan(scanner);
                    break;
                case 6:
                    manageKesehatanHewan(scanner);
                    break;
                case 7:
                    manageJadwalPakan(scanner);
                    break;
                case 8:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void manageAdmin(Scanner scanner) {
        while (true) {
            System.out.println("\n=== KELOLA DATA ADMIN ===");
            System.out.println("1. Tambah Admin");
            System.out.println("2. Lihat Admin");
            System.out.println("3. Update Admin");
            System.out.println("4. Hapus Admin");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
    
            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Admin: ");
                    String id_admin = scanner.nextLine();
                    System.out.print("Masukkan Nama Admin: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Password Admin: ");
                    String password = scanner.nextLine();
                    System.out.print("Masukkan No. Telp Admin: ");
                    String no_telp = scanner.nextLine();
                    adminManager.addAdmin(new Admin(id_admin, nama, password, no_telp));
                    break;
                case 2:
                    adminManager.viewAdmins();
                    break;
                case 3:
                    System.out.print("Masukkan ID Admin yang akan diupdate: ");
                    String update_id_admin = scanner.nextLine();
                    System.out.print("Masukkan Nama Baru: ");
                    String new_nama = scanner.nextLine();
                    System.out.print("Masukkan Password Baru: ");
                    String new_password = scanner.nextLine();
                    System.out.print("Masukkan No. Telp Baru: ");
                    String new_no_telp = scanner.nextLine();
                    adminManager.updateAdmin(update_id_admin, new_nama, new_password, new_no_telp);
                    System.out.println("Admin berhasil diupdate.");
                    break;
                case 4:
                    System.out.print("Masukkan ID Admin yang akan dihapus: ");
                    String delete_id_admin = scanner.nextLine();
                    adminManager.deleteAdmin(delete_id_admin);
                    System.out.println("Admin berhasil dihapus.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void manageStaf(Scanner scanner) {
        while (true) {
            System.out.println("\n=== KELOLA DATA STAF ===");
            System.out.println("1. Tambah Staf");
            System.out.println("2. Lihat Staf");
            System.out.println("3. Update Staf");
            System.out.println("4. Hapus Staf");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
    
            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Staf: ");
                    String id_staf = scanner.nextLine();
                    System.out.print("Masukkan Nama Staf: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jabatan Staf: ");
                    String jabatan = scanner.nextLine();
                    System.out.print("Masukkan No. Telp Staf: ");
                    String no_telp = scanner.nextLine();
                    System.out.print("Masukkan Alamat Staf: ");
                    String alamat = scanner.nextLine();
                    stafManager.addStaf(new Staf(id_staf, nama, jabatan, no_telp, alamat));
                    System.out.println("Staf berhasil ditambahkan.");
                    break;
                case 2:
                    stafManager.viewStafs();
                    break;
                case 3:
                    System.out.print("Masukkan ID Staf yang akan diupdate: ");
                    String update_id_staf = scanner.nextLine();
                    System.out.print("Masukkan Nama Baru: ");
                    String new_nama = scanner.nextLine();
                    System.out.print("Masukkan Jabatan Baru: ");
                    String new_jabatan = scanner.nextLine();
                    System.out.print("Masukkan No. Telp Baru: ");
                    String new_no_telp = scanner.nextLine();
                    System.out.print("Masukkan Alamat Baru: ");
                    String new_alamat = scanner.nextLine();
                    stafManager.updateStaf(update_id_staf, new_nama, new_jabatan, new_no_telp, new_alamat);
                    System.out.println("Staf berhasil diupdate.");
                    break;
                case 4:
                    System.out.print("Masukkan ID Staf yang akan dihapus: ");
                    String delete_id_staf = scanner.nextLine();
                    stafManager.deleteStaf(delete_id_staf);
                    System.out.println("Staf berhasil dihapus.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void manageHewan(Scanner scanner) {
        while (true) {
            System.out.println("\n=== KELOLA DATA HEWAN ===");
            System.out.println("1. Tambah Hewan");
            System.out.println("2. Lihat Hewan");
            System.out.println("3. Update Hewan");
            System.out.println("4. Hapus Hewan");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
    
            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Hewan: ");
                    String id_hewan = scanner.nextLine();
                    System.out.print("Masukkan Nama Hewan: ");
                    String nama_hewan = scanner.nextLine();
                    System.out.print("Masukkan Jenis Hewan: ");
                    String jenis_hewan = scanner.nextLine();
                    System.out.print("Masukkan ID Kandang: ");
                    String id_kandang = scanner.nextLine();
                    hewanManager.addHewan(new Hewan(id_hewan, nama_hewan, jenis_hewan, id_kandang));
                    System.out.println("Hewan berhasil ditambahkan.");
                    break;
                case 2:
                    hewanManager.viewHewan();
                    break;
                case 3:
                    System.out.print("Masukkan ID Hewan yang akan diupdate: ");
                    String update_id_hewan = scanner.nextLine();
                    System.out.print("Masukkan Nama Baru: ");
                    String new_nama_hewan = scanner.nextLine();
                    System.out.print("Masukkan Jenis Baru: ");
                    String new_jenis_hewan = scanner.nextLine();
                    System.out.print("Masukkan ID Kandang Baru: ");
                    String new_id_kandang = scanner.nextLine();
                    hewanManager.updateHewan(update_id_hewan, new_nama_hewan, new_jenis_hewan, new_id_kandang);
                    System.out.println("Hewan berhasil diupdate.");
                    break;
                case 4:
                    System.out.print("Masukkan ID Hewan yang akan dihapus: ");
                    String delete_id_hewan = scanner.nextLine();
                    hewanManager.deleteHewan(delete_id_hewan);
                    System.out.println("Hewan berhasil dihapus.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void manageKandang(Scanner scanner) {
        while (true) {
            System.out.println("\n=== KELOLA DATA KANDANG ===");
            System.out.println("1. Tambah Kandang");
            System.out.println("2. Lihat Kandang");
            System.out.println("3. Update Kandang");
            System.out.println("4. Hapus Kandang");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
    
            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Kandang: ");
                    String id_kandang = scanner.nextLine();
                    System.out.print("Masukkan Nama Kandang: ");
                    String nama_kandang = scanner.nextLine();
                    System.out.print("Masukkan Lokasi Kandang: ");
                    String lokasi = scanner.nextLine();
                    System.out.print("Masukkan Kapasitas Kandang: ");
                    int kapasitas = scanner.nextInt();
                    scanner.nextLine();  
                    kandangManager.addKandang(new Kandang(id_kandang, nama_kandang, lokasi, kapasitas));
                    System.out.println("Kandang berhasil ditambahkan.");
                    break;
                case 2:
                    kandangManager.viewKandang();
                    break;
                case 3:
                    System.out.print("Masukkan ID Kandang yang akan diupdate: ");
                    String update_id_kandang = scanner.nextLine();
                    System.out.print("Masukkan Nama Baru: ");
                    String new_nama_kandang = scanner.nextLine();
                    System.out.print("Masukkan Lokasi Baru: ");
                    String new_lokasi = scanner.nextLine();
                    System.out.print("Masukkan Kapasitas Baru: ");
                    int new_kapasitas = scanner.nextInt();
                    scanner.nextLine();  
                    kandangManager.updateKandang(update_id_kandang, new_nama_kandang, new_lokasi, new_kapasitas);
                    System.out.println("Kandang berhasil diupdate.");
                    break;
                case 4:
                    System.out.print("Masukkan ID Kandang yang akan dihapus: ");
                    String delete_id_kandang = scanner.nextLine();
                    kandangManager.deleteKandang(delete_id_kandang);
                    System.out.println("Kandang berhasil dihapus.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void managePakan(Scanner scanner) {
        while (true) {
            System.out.println("\n=== KELOLA DATA PAKAN ===");
            System.out.println("1. Tambah Pakan");
            System.out.println("2. Lihat Pakan");
            System.out.println("3. Update Pakan");
            System.out.println("4. Hapus Pakan");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
    
            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Pakan: ");
                    String id_pakan = scanner.nextLine();
                    System.out.print("Masukkan Jenis Pakan: ");
                    String jenis_pakan = scanner.nextLine();
                    System.out.print("Masukkan Stok Pakan: ");
                    int stok_pakan = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Masukkan Tanggal Kadaluarsa (YYYY-MM-DD): ");
                    String tanggal_kadaluarsa = scanner.nextLine();
                    pakanManager.addPakan(new Pakan(id_pakan, jenis_pakan, stok_pakan, tanggal_kadaluarsa));
                    System.out.println("Pakan berhasil ditambahkan.");
                    break;
                case 2:
                    pakanManager.viewPakan();
                    break;
                case 3:
                    System.out.print("Masukkan ID Pakan yang akan diupdate: ");
                    String update_id_pakan = scanner.nextLine();
                    System.out.print("Masukkan Jenis Pakan Baru: ");
                    String new_jenis_pakan = scanner.nextLine();
                    System.out.print("Masukkan Stok Pakan Baru: ");
                    int new_stok_pakan = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Masukkan Tanggal Kadaluarsa Baru (YYYY-MM-DD): ");
                    String new_tanggal_kadaluarsa = scanner.nextLine();
                    pakanManager.updatePakan(update_id_pakan, new_jenis_pakan, new_stok_pakan, new_tanggal_kadaluarsa);
                    System.out.println("Pakan berhasil diupdate.");
                    break;
                case 4:
                    System.out.print("Masukkan ID Pakan yang akan dihapus: ");
                    String delete_id_pakan = scanner.nextLine();
                    pakanManager.deletePakan(delete_id_pakan);
                    System.out.println("Pakan berhasil dihapus.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void manageKesehatanHewan(Scanner scanner) {
        while (true) {
            System.out.println("\n=== KELOLA DATA KESEHATAN HEWAN ===");
            System.out.println("1. Tambah Data Kesehatan Hewan");
            System.out.println("2. Lihat Data Kesehatan Hewan");
            System.out.println("3. Update Data Kesehatan Hewan");
            System.out.println("4. Hapus Data Kesehatan Hewan");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
    
            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Kesehatan: ");
                    String id_kesehatan = scanner.nextLine();
                    System.out.print("Masukkan ID Hewan: ");
                    String id_hewan = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Periksa (YYYY-MM-DD): ");
                    String tanggal_periksa = scanner.nextLine();
                    System.out.print("Masukkan Status Kesehatan: ");
                    String status = scanner.nextLine();
                    System.out.print("Masukkan Catatan: ");
                    String catatan = scanner.nextLine();
                    kesehatanHewanManager.addKesehatanHewan(new KesehatanHewan(id_kesehatan, id_hewan, tanggal_periksa, status, catatan));
                    System.out.println("Data kesehatan hewan berhasil ditambahkan.");
                    break;
                case 2:
                    kesehatanHewanManager.viewKesehatanHewan();
                    break;
                case 3:
                    System.out.print("Masukkan ID Kesehatan yang akan diupdate: ");
                    String update_id_kesehatan = scanner.nextLine();
                    System.out.print("Masukkan ID Hewan Baru: ");
                    String new_id_hewan = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Periksa Baru (YYYY-MM-DD): ");
                    String new_tanggal_periksa = scanner.nextLine();
                    System.out.print("Masukkan Status Baru: ");
                    String new_status = scanner.nextLine();
                    System.out.print("Masukkan Catatan Baru: ");
                    String new_catatan = scanner.nextLine();
                    kesehatanHewanManager.updateKesehatanHewan(update_id_kesehatan, new_id_hewan, new_tanggal_periksa, new_status, new_catatan);
                    System.out.println("Data kesehatan hewan berhasil diupdate.");
                    break;
                case 4:
                    System.out.print("Masukkan ID Kesehatan yang akan dihapus: ");
                    String delete_id_kesehatan = scanner.nextLine();
                    kesehatanHewanManager.deleteKesehatanHewan(delete_id_kesehatan);
                    System.out.println("Data kesehatan hewan berhasil dihapus.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void manageJadwalPakan(Scanner scanner) {
        while (true) {
            System.out.println("\n=== KELOLA DATA JADWAL PAKAN ===");
            System.out.println("1. Tambah Jadwal Pakan");
            System.out.println("2. Lihat Jadwal Pakan");
            System.out.println("3. Update Jadwal Pakan");
            System.out.println("4. Hapus Jadwal Pakan");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
    
            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Jadwal: ");
                    String id_jadwal = scanner.nextLine();
                    System.out.print("Masukkan ID Kandang: ");
                    String id_kandang = scanner.nextLine();
                    System.out.print("Masukkan ID Pakan: ");
                    String id_pakan = scanner.nextLine();
                    System.out.print("Masukkan ID Staf: ");
                    String id_staf = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Pemberian (YYYY-MM-DD): ");
                    String tanggal_pemberian = scanner.nextLine();
                    System.out.print("Masukkan Waktu Pemberian (HH:MM): ");
                    String waktu_pemberian = scanner.nextLine();
                    jadwalPakanManager.addJadwalPakan(new JadwalPakan(id_jadwal, id_kandang, id_pakan, id_staf, tanggal_pemberian, waktu_pemberian));
                    System.out.println("Jadwal pakan berhasil ditambahkan.");
                    break;
                case 2:
                    jadwalPakanManager.viewJadwalPakan();
                    break;
                case 3:
                    System.out.print("Masukkan ID Jadwal yang akan diupdate: ");
                    String update_id_jadwal = scanner.nextLine();
                    System.out.print("Masukkan ID Kandang Baru: ");
                    String new_id_kandang = scanner.nextLine();
                    System.out.print("Masukkan ID Pakan Baru: ");
                    String new_id_pakan = scanner.nextLine();
                    System.out.print("Masukkan ID Staf Baru: ");
                    String new_id_staf = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Pemberian Baru (YYYY-MM-DD): ");
                    String new_tanggal_pemberian = scanner.nextLine();
                    System.out.print("Masukkan Waktu Pemberian Baru (HH:MM): ");
                    String new_waktu_pemberian = scanner.nextLine();
                    jadwalPakanManager.updateJadwalPakan(update_id_jadwal, new_id_kandang, new_id_pakan, new_id_staf, new_tanggal_pemberian, new_waktu_pemberian);
                    System.out.println("Jadwal pakan berhasil diupdate.");
                    break;
                case 4:
                    System.out.print("Masukkan ID Jadwal yang akan dihapus: ");
                    String delete_id_jadwal = scanner.nextLine();
                    jadwalPakanManager.deleteJadwalPakan(delete_id_jadwal);
                    System.out.println("Jadwal pakan berhasil dihapus.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}