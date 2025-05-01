
import model.*;

import java.util.*;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static List<Hewan> daftarHewan = new ArrayList<>();
    static List<Kandang> daftarKandang = new ArrayList<>();
    static List<Pakan> daftarPakan = new ArrayList<>();
    static List<KesehatanHewan> daftarKesehatan = new ArrayList<>();
    static List<JadwalPakan> daftarJadwal = new ArrayList<>();
    static String getIdStaf;

    public static void main(String[] args) {
        dummyData();
        menuUtama();
    }

    
    static void dummyData() {
        Admin admin1 = new Admin("A1", "Admin1", "admin123", "081234567890");
        admin1.tambah(admin1); 
        Staf staf1 = new Staf("S1", "Staf1", "staf123", "081234567891", "OB");
        staf1.tambah(staf1); 
        daftarHewan.add(new Hewan("H1", "Harimau", "Mamalia"));
        daftarKandang.add(new Kandang("K1", "Kandang Harimau", "Blok A", 2));
        daftarPakan.add(new Pakan("P1", "Daging", 100, "2027-06-30"));
        daftarKesehatan.add(new KesehatanHewan("KH1", "H1", "2025-04-15", "Sehat", "Tidak ada masalah"));
        daftarJadwal.add(new JadwalPakan("J1", "K1", "S1", "P1", "2025-04-16", "08:00"));
    }

    static void menuUtama() {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== MENU UTAMA =====");
                System.out.println("1. Login");
                System.out.println("2. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1:
                        login();
                        break;
                    case 2:
                        System.out.println("Keluar dari sistem.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih 1 atau 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
            }
        } while (pilihan != 2);
    }
    

    static void login() {
        System.out.println("\n===== LOGIN SISTEM =====");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (Admin admin : Admin.getDaftarAdmin()) {
            if (admin.getId().equals(id) && admin.getPassword().equals(password)) {
                menuAdmin(admin);
                return;
            }
        }

        for (Staf staf : Staf.getDaftarStaf()) {
            if (staf.getId().equals(id) && staf.getPassword().equals(password)) {
                getIdStaf = id;
                menuStaf(staf);
                return;
            }
        }

        System.out.println("Login gagal. Coba lagi.");
        login();
    }

    static void menuAdmin(final Admin admin) {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== SISTEM PENGELOLAAN KEBUN BINATANG LESTARI ZOO =====");
                System.out.println("1. Kelola Data Admin");
                System.out.println("2. Kelola Data Staf");
                System.out.println("3. Kelola Data Hewan");
                System.out.println("4. Kelola Data Kandang");
                System.out.println("5. Kelola Data Pakan");
                System.out.println("6. Kelola Riwayat Kesehatan Hewan");
                System.out.println("7. Kelola Jadwal Pemberian Pakan");
                System.out.println("8. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1: kelolaAdmin(); break;
                    case 2: kelolaStaf(); break;
                    case 3: kelolaHewan(); break;
                    case 4: kelolaKandang(); break;
                    case 5: kelolaPakan(); break;
                    case 6: kelolaKesehatan(); break;
                    case 7: kelolaJadwal(); break;
                    case 8: System.out.println("Keluar dari sistem."); break;
                    default: System.out.println("Pilihan tidak valid. Masukkan angka 1 - 8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka antara 1 - 8.");
            }
        } while (pilihan != 8);
    }
    

    static void kelolaAdmin() {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== Kelola Data Admin =====");
                System.out.println("1. Tambah Admin");
                System.out.println("2. Edit Admin");
                System.out.println("3. Hapus Admin");
                System.out.println("4. Lihat Admin");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1: tambahAdmin(); break;
                    case 2: editAdmin(); break;
                    case 3: hapusAdmin(); break;
                    case 4: lihatAdmin(); break;
                    default: System.out.println("Pilihan tidak valid. Silakan pilih antara 1 - 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka antara 1 - 4.");
            }
        } while (pilihan < 1 || pilihan > 4); 
    }
    

    static void tambahAdmin() {
        try {
            System.out.print("ID Admin: ");
            String id = scanner.nextLine();
            if (id.isEmpty()) {
                throw new IllegalArgumentException("ID Admin tidak boleh kosong.");
            }
    
            System.out.print("Nama Admin: ");
            String nama = scanner.nextLine();
            if (nama.isEmpty()) {
                throw new IllegalArgumentException("Nama Admin tidak boleh kosong.");
            }
    
            System.out.print("Password: ");
            String password = scanner.nextLine();
            if (password.isEmpty()) {
                throw new IllegalArgumentException("Password tidak boleh kosong.");
            }
    
            System.out.print("No Telp: ");
            String noTelp = scanner.nextLine();
            if (noTelp.isEmpty()) {
                throw new IllegalArgumentException("No Telp tidak boleh kosong.");
            }
    
            Admin adminBaru = new Admin(id, nama, password, noTelp);
            adminBaru.tambah(adminBaru);
            System.out.println("Admin baru telah berhasil ditambahkan.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan admin: " + e.getMessage());
        }
    }
    
    static void editAdmin() {
        try {
            System.out.print("Masukkan ID Admin yang ingin diedit: ");
            String id = scanner.nextLine();
        
            boolean adminDitemukan = false;
            for (Admin admin : Admin.getDaftarAdmin()) {
                if (admin.getId().equals(id)) {
                    adminDitemukan = true;
                    System.out.print("Nama Baru: ");
                    String namaBaru = scanner.nextLine();
                    if (namaBaru.isEmpty()) {
                        throw new IllegalArgumentException("Nama baru tidak boleh kosong.");
                    }
    
                    System.out.print("No Telp Baru: ");
                    String noTelpBaru = scanner.nextLine();
                    if (noTelpBaru.isEmpty()) {
                        throw new IllegalArgumentException("No Telp baru tidak boleh kosong.");
                    }
    
                    admin.update(id, namaBaru, noTelpBaru);
                    System.out.println("Data Admin telah berhasil diperbarui.");
                    break;
                }
            }
    
            if (!adminDitemukan) {
                System.out.println("Admin dengan ID " + id + " tidak ditemukan.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mengedit admin: " + e.getMessage());
        }
    }
    
    static void hapusAdmin() {
        try {
            System.out.print("Masukkan ID Admin yang ingin dihapus: ");
            String id = scanner.nextLine();
    
            Admin admin = null;
            for (Admin a : Admin.getDaftarAdmin()) {
                if (a.getId().equals(id)) {
                    admin = a;
                    break;
                }
            }
    
            if (admin != null) {
                admin.hapus(id);
                System.out.println("Admin dengan ID " + id + " telah berhasil dihapus.");
            } else {
                System.out.println("Admin dengan ID " + id + " tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus admin: " + e.getMessage());
        }
    }
    
    

    static void lihatAdmin() {
        Admin.tampilkanSemua(); 
    }
    

    static void kelolaStaf() {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== Kelola Data Staf =====");
                System.out.println("1. Tambah Staf");
                System.out.println("2. Edit Staf");
                System.out.println("3. Hapus Staf");
                System.out.println("4. Lihat Staf");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1: tambahStaf(); break;
                    case 2: editStaf(); break;
                    case 3: hapusStaf(); break;
                    case 4: lihatStaf(); break;
                    default: System.out.println("Pilihan tidak valid. Silakan pilih antara 1 - 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka antara 1 - 4.");
            }
        } while (pilihan < 1 || pilihan > 4); 
    }
    
    static void tambahStaf() {
        try {
            System.out.print("ID Staf: ");
            String id = scanner.nextLine();
            if (id.isEmpty()) {
                throw new IllegalArgumentException("ID Staf tidak boleh kosong.");
            }
    
            System.out.print("Nama Staf: ");
            String nama = scanner.nextLine();
            if (nama.isEmpty()) {
                throw new IllegalArgumentException("Nama Staf tidak boleh kosong.");
            }
    
            System.out.print("Password: ");
            String password = scanner.nextLine();
            if (password.isEmpty()) {
                throw new IllegalArgumentException("Password tidak boleh kosong.");
            }
    
            System.out.print("No Telp: ");
            String noTelp = scanner.nextLine();
            if (noTelp.isEmpty()) {
                throw new IllegalArgumentException("No Telp tidak boleh kosong.");
            }
    
            System.out.print("Jabatan: ");
            String jabatan = scanner.nextLine();
            if (jabatan.isEmpty()) {
                throw new IllegalArgumentException("Jabatan tidak boleh kosong.");
            }
    
            Staf staf = new Staf(id, nama, password, noTelp, jabatan);
            staf.tambah(staf);  
            System.out.println("Staf berhasil ditambahkan.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan staf: " + e.getMessage());
        }
    }
    
    static void editStaf() {
        try {
            System.out.print("Masukkan ID Staf yang ingin diedit: ");
            String id = scanner.nextLine();
        
            boolean stafDitemukan = false;
            for (Staf staf : Staf.getDaftarStaf()) {
                if (staf.getId().equals(id)) {
                    stafDitemukan = true;
                    System.out.print("Nama Baru: ");
                    String namaBaru = scanner.nextLine();
                    if (namaBaru.isEmpty()) {
                        throw new IllegalArgumentException("Nama baru tidak boleh kosong.");
                    }
    
                    System.out.print("No Telp Baru: ");
                    String noTelpBaru = scanner.nextLine();
                    if (noTelpBaru.isEmpty()) {
                        throw new IllegalArgumentException("No Telp baru tidak boleh kosong.");
                    }
    
                    System.out.print("Jabatan Baru: ");
                    String jabatanBaru = scanner.nextLine();
                    if (jabatanBaru.isEmpty()) {
                        throw new IllegalArgumentException("Jabatan baru tidak boleh kosong.");
                    }
    
                    staf.update(id, namaBaru, noTelpBaru, jabatanBaru);  
                    System.out.println("Data Staf berhasil diperbarui.");
                    break;
                }
            }
    
            if (!stafDitemukan) {
                System.out.println("Staf dengan ID " + id + " tidak ditemukan.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mengedit staf: " + e.getMessage());
        }
    }
    
    static void hapusStaf() {
        try {
            System.out.print("Masukkan ID Staf yang ingin dihapus: ");
            String id = scanner.nextLine();
    
            Staf staf = null;
            for (Staf a : Staf.getDaftarStaf()) {
                if (a.getId().equals(id)) {
                    staf = a;
                    break;
                }
            }
    
            if (staf != null) {
                staf.hapus(id); 
                System.out.println("Staf dengan ID " + id + " berhasil dihapus.");
            } else {
                System.out.println("Staf dengan ID " + id + " tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus staf: " + e.getMessage());
        }
    }
    
    
    static void lihatStaf() {
        Staf.tampilkanSemua();
    }
    
    
    
    static void kelolaHewan() {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== Kelola Data Hewan =====");
                System.out.println("1. Tambah Hewan");
                System.out.println("2. Edit Hewan");
                System.out.println("3. Hapus Hewan");
                System.out.println("4. Lihat Hewan");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1: tambahHewan(); break;
                    case 2: editHewan(); break;
                    case 3: hapusHewan(); break;
                    case 4: lihatHewan(); break;
                    default: System.out.println("Pilihan tidak valid. Silakan pilih antara 1 - 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka antara 1 - 4.");
            }
        } while (pilihan < 1 || pilihan > 4); 
    }
    

    static void tambahHewan() {
        try {
            System.out.print("ID Hewan: ");
            String id = scanner.nextLine();
            if (id.isEmpty()) {
                throw new IllegalArgumentException("ID Hewan tidak boleh kosong.");
            }
    
            System.out.print("Nama Hewan: ");
            String nama = scanner.nextLine();
            if (nama.isEmpty()) {
                throw new IllegalArgumentException("Nama Hewan tidak boleh kosong.");
            }
    
            System.out.print("Jenis Hewan: ");
            String jenis = scanner.nextLine();
            if (jenis.isEmpty()) {
                throw new IllegalArgumentException("Jenis Hewan tidak boleh kosong.");
            }
    
            daftarHewan.add(new Hewan(id, nama, jenis));
            System.out.println("Hewan berhasil ditambahkan.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan hewan: " + e.getMessage());
        }
    }
    
    static void editHewan() {
        try {
            System.out.print("Masukkan ID Hewan yang ingin diedit: ");
            String id = scanner.nextLine();
            Hewan hewan = cariHewan(id);
            if (hewan != null) {
                System.out.print("Nama Hewan Baru: ");
                String namaBaru = scanner.nextLine();
                if (namaBaru.isEmpty()) {
                    throw new IllegalArgumentException("Nama Hewan tidak boleh kosong.");
                }
                hewan.setNama(namaBaru);
                System.out.println("Data Hewan berhasil diperbarui.");
            } else {
                System.out.println("Hewan dengan ID " + id + " tidak ditemukan.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mengedit hewan: " + e.getMessage());
        }
    }
    
    static void hapusHewan() {
        try {
            System.out.print("Masukkan ID Hewan yang ingin dihapus: ");
            String id = scanner.nextLine();
            Hewan hewan = cariHewan(id);
            if (hewan != null) {
                daftarHewan.remove(hewan);
                System.out.println("Hewan dengan ID " + id + " berhasil dihapus.");
            } else {
                System.out.println("Hewan dengan ID " + id + " tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus hewan: " + e.getMessage());
        }
    }
    
    static Hewan cariHewan(String id) {
        for (Hewan hewan : daftarHewan) {
            if (hewan.getId().equals(id)) return hewan;
        }
        return null;
    }
    

    static void lihatHewan() {
        for (Hewan hewan : daftarHewan) {
            hewan.tampilkanInfo();
        }
    }

        
    static void kelolaKandang() {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== Kelola Data Kandang =====");
                System.out.println("1. Tambah Kandang");
                System.out.println("2. Edit Kandang");
                System.out.println("3. Hapus Kandang");
                System.out.println("4. Lihat Kandang");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1: tambahKandang(); break;
                    case 2: editKandang(); break;
                    case 3: hapusKandang(); break;
                    case 4: lihatKandang(); break;
                    default: System.out.println("Pilihan tidak valid. Silakan pilih antara 1 - 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka antara 1 - 4.");
            }
        } while (pilihan < 1 || pilihan > 4); 
    }
    

    static void tambahKandang() {
        try {
            System.out.print("ID Kandang: ");
            String id = scanner.nextLine();
            if (id.isEmpty()) {
                throw new IllegalArgumentException("ID Kandang tidak boleh kosong.");
            }
    
            System.out.print("Nama Kandang: ");
            String nama = scanner.nextLine();
            if (nama.isEmpty()) {
                throw new IllegalArgumentException("Nama Kandang tidak boleh kosong.");
            }
    
            System.out.print("Lokasi Kandang: ");
            String lokasi = scanner.nextLine();
            if (lokasi.isEmpty()) {
                throw new IllegalArgumentException("Lokasi Kandang tidak boleh kosong.");
            }
    
            System.out.print("Kapasitas Kandang: ");
            int kapasitas = Integer.parseInt(scanner.nextLine());  
            if (kapasitas <= 0) {
                throw new IllegalArgumentException("Kapasitas Kandang harus lebih besar dari 0.");
            }
    
            daftarKandang.add(new Kandang(id, nama, lokasi, kapasitas));
            System.out.println("Kandang berhasil ditambahkan.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    static void editKandang() {
        try {
            System.out.print("Masukkan ID Kandang yang ingin diedit: ");
            String id = scanner.nextLine();
            Kandang kandang = cariKandang(id);
            if (kandang != null) {
                System.out.print("Nama Kandang Baru: ");
                String namaBaru = scanner.nextLine();
                if (namaBaru.isEmpty()) {
                    throw new IllegalArgumentException("Nama Kandang tidak boleh kosong.");
                }
                kandang.setNamaKandang(namaBaru);
    
                System.out.print("Lokasi Kandang Baru: ");
                String lokasiBaru = scanner.nextLine();
                if (lokasiBaru.isEmpty()) {
                    throw new IllegalArgumentException("Lokasi Kandang tidak boleh kosong.");
                }
                kandang.setLokasi(lokasiBaru);
    
                System.out.print("Kapasitas Kandang Baru: ");
                int kapasitasBaru = Integer.parseInt(scanner.nextLine());  
                if (kapasitasBaru <= 0) {
                    throw new IllegalArgumentException("Kapasitas Kandang harus lebih besar dari 0.");
                }
                kandang.setKapasitas(kapasitasBaru);
    
                System.out.println("Data Kandang berhasil diperbarui.");
            } else {
                System.out.println("Kandang tidak ditemukan.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    static void hapusKandang() {
        try {
            System.out.print("Masukkan ID Kandang yang ingin dihapus: ");
            String id = scanner.nextLine();
            Kandang kandang = cariKandang(id);
            if (kandang != null) {
                daftarKandang.remove(kandang);
                System.out.println("Kandang berhasil dihapus.");
            } else {
                System.out.println("Kandang tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus kandang: " + e.getMessage());
        }
    }
    
    
    static Kandang cariKandang(String id) {
        for (Kandang kandang : daftarKandang) {
            if (kandang.getIdKandang().equals(id)) return kandang;
        }
        return null;
    }
    

    static void lihatKandang() {
        for (Kandang kandang : daftarKandang) {
            kandang.tampilkanInfo();
        }
    }

        
    static void kelolaPakan() {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== Kelola Data Pakan =====");
                System.out.println("1. Tambah Pakan");
                System.out.println("2. Edit Pakan");
                System.out.println("3. Hapus Pakan");
                System.out.println("4. Lihat Pakan");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1: tambahPakan(); break;
                    case 2: editPakan(); break;
                    case 3: hapusPakan(); break;
                    case 4: lihatPakan(); break;
                    default: System.out.println("Pilihan tidak valid. Silakan pilih antara 1 - 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka antara 1 - 4.");
            }
        } while (pilihan < 1 || pilihan > 4); 
    }
    
    static void tambahPakan() {
        System.out.print("ID Pakan: ");
        String id = scanner.nextLine();
        System.out.print("Nama Pakan: ");
        String nama = scanner.nextLine();
        System.out.print("Jumlah Pakan: ");
        int jumlah = Integer.parseInt(scanner.nextLine());
        System.out.print("Tanggal Kedaluarsa: ");
        String tanggal = scanner.nextLine();
        daftarPakan.add(new Pakan(id, nama, jumlah, tanggal));
        System.out.println("Pakan berhasil ditambahkan.");
    }

    static void editPakan() {
        System.out.print("Masukkan ID Pakan yang ingin diedit: ");
        String id = scanner.nextLine();
        Pakan pakan = cariPakan(id);
        if (pakan != null) {
            System.out.print("Nama Pakan Baru: ");
            pakan.setNama(scanner.nextLine());
            System.out.print("Jumlah Pakan Baru: ");
            pakan.setJumlah(Integer.parseInt(scanner.nextLine()));
            System.out.print("Tanggal Kedaluarsa Baru: ");
            pakan.setTanggal(scanner.nextLine());
            System.out.println("Data Pakan berhasil diperbarui.");
        } else {
            System.out.println("Pakan tidak ditemukan.");
        }
    }

    static void hapusPakan() {
        System.out.print("Masukkan ID Pakan yang ingin dihapus: ");
        String id = scanner.nextLine();
        Pakan pakan = cariPakan(id);
        if (pakan != null) {
            daftarPakan.remove(pakan);
            System.out.println("Pakan berhasil dihapus.");
        } else {
            System.out.println("Pakan tidak ditemukan.");
        }
    }

    static Pakan cariPakan(String id) {
        for (Pakan pakan : daftarPakan) {
            if (pakan.getIdPakan().equals(id)) return pakan;
        }
        return null;
    }

    static void lihatPakan() {
        for (Pakan pakan : daftarPakan) {
            pakan.tampilkanInfo();
        }
    }

    
    static void kelolaKesehatan() {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== Kelola Riwayat Kesehatan Hewan =====");
                System.out.println("1. Tambah Riwayat Kesehatan");
                System.out.println("2. Edit Riwayat Kesehatan");
                System.out.println("3. Hapus Riwayat Kesehatan");
                System.out.println("4. Lihat Riwayat Kesehatan");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1: tambahKesehatan(); break;
                    case 2: editKesehatan(); break;
                    case 3: hapusKesehatan(); break;
                    case 4: lihatKesehatan(); break;
                    default: System.out.println("Pilihan tidak valid. Silakan pilih antara 1 - 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka antara 1 - 4.");
            }
        } while (pilihan < 1 || pilihan > 4); 
    }
    

    static void tambahKesehatan() {
        System.out.print("ID Kesehatan: ");
        String id = scanner.nextLine();
        System.out.print("ID Hewan: ");
        String idHewan = scanner.nextLine();
        System.out.print("Tanggal Periksa: ");
        String tgl = scanner.nextLine();
        System.out.print("Status Kesehatan: ");
        String status = scanner.nextLine();
        System.out.print("Catatan Kesehatan: ");
        String catatan = scanner.nextLine();
        daftarKesehatan.add(new KesehatanHewan(id, idHewan, tgl, status, catatan));
        System.out.println("Riwayat Kesehatan berhasil ditambahkan.");
    }

    static void editKesehatan() {
        System.out.print("Masukkan ID Kesehatan yang ingin diedit: ");
        String id = scanner.nextLine();
        KesehatanHewan kesehatan = cariKesehatan(id);
        if (kesehatan != null) {
            System.out.print("Tanggal Periksa Baru: ");
            kesehatan.setTanggal(scanner.nextLine());
            System.out.print("Status Kesehatan Baru: ");
            kesehatan.setStatus(scanner.nextLine());
            System.out.print("Catatan Kesehatan Baru: ");
            kesehatan.setCatatan(scanner.nextLine());
            System.out.println("Riwayat Kesehatan berhasil diperbarui.");
        } else {
            System.out.println("Riwayat Kesehatan tidak ditemukan.");
        }
    }

    static void hapusKesehatan() {
        System.out.print("Masukkan ID Kesehatan yang ingin dihapus: ");
        String id = scanner.nextLine();
        KesehatanHewan kesehatan = cariKesehatan(id);
        if (kesehatan != null) {
            daftarKesehatan.remove(kesehatan);
            System.out.println("Riwayat Kesehatan berhasil dihapus.");
        } else {
            System.out.println("Riwayat Kesehatan tidak ditemukan.");
        }
    }

    static KesehatanHewan cariKesehatan(String id) {
        for (KesehatanHewan kesehatan : daftarKesehatan) {
            if (kesehatan.getIdKesehatan().equals(id)) return kesehatan;
        }
        return null;
    }

    static void lihatKesehatan() {
        for (KesehatanHewan kesehatan : daftarKesehatan) {
            kesehatan.tampilkanInfo();
        }
    }

        
    static void kelolaJadwal() {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== Kelola Jadwal Pemberian Pakan =====");
                System.out.println("1. Tambah Jadwal Pakan");
                System.out.println("2. Edit Jadwal Pakan");
                System.out.println("3. Hapus Jadwal Pakan");
                System.out.println("4. Lihat Jadwal Pakan");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1: tambahJadwal(); break;
                    case 2: editJadwal(); break;
                    case 3: hapusJadwal(); break;
                    case 4: lihatJadwal(); break;
                    default: 
                        System.out.println("Pilihan tidak valid. Silakan pilih antara 1 - 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka antara 1 - 4.");
            }
        } while (pilihan < 1 || pilihan > 4);
    }
    

    static void tambahJadwal() {
        System.out.print("ID Jadwal: ");
        String id = scanner.nextLine();
        System.out.print("ID Kandang: ");
        String idKandang = scanner.nextLine();
        System.out.print("ID Staf: ");
        String idStaf = scanner.nextLine();
        System.out.print("ID Pakan: ");
        String idPakan = scanner.nextLine();
        System.out.print("Tanggal Pemberian Pakan: ");
        String tanggal = scanner.nextLine();
        System.out.print("Waktu Pemberian Pakan: ");
        String waktu = scanner.nextLine();
        daftarJadwal.add(new JadwalPakan(id, idKandang, idStaf, idPakan, tanggal, waktu));
        System.out.println("Jadwal Pakan berhasil ditambahkan.");
    }

    static void editJadwal() {
        System.out.print("Masukkan ID Jadwal yang ingin diedit: ");
        String id = scanner.nextLine();
        JadwalPakan jadwal = cariJadwal(id);
        if (jadwal != null) {
            System.out.print("ID Kandang Baru: ");
            jadwal.setIdKandang(scanner.nextLine());
            System.out.print("ID Staf Baru: ");
            jadwal.setIdStaf(scanner.nextLine());
            System.out.print("ID Pakan Baru: ");
            jadwal.setIdPakan(scanner.nextLine());
            System.out.print("Tanggal Pemberian Pakan Baru: ");
            jadwal.setTanggal(scanner.nextLine());
            System.out.print("Waktu Pemberian Pakan Baru: ");
            jadwal.setWaktu(scanner.nextLine());
            System.out.println("Jadwal Pakan berhasil diperbarui.");
        } else {
            System.out.println("Jadwal Pakan tidak ditemukan.");
        }
    }

    static void hapusJadwal() {
        System.out.print("Masukkan ID Jadwal yang ingin dihapus: ");
        String id = scanner.nextLine();
        JadwalPakan jadwal = cariJadwal(id);
        if (jadwal != null) {
            daftarJadwal.remove(jadwal);
            System.out.println("Jadwal Pakan berhasil dihapus.");
        } else {
            System.out.println("Jadwal Pakan tidak ditemukan.");
        }
    }

    static JadwalPakan cariJadwal(String id) {
        for (JadwalPakan jadwal : daftarJadwal) {
            if (jadwal.getIdJadwal().equals(id)) return jadwal;
        }
        return null;
    }

    static void lihatJadwal() {
        for (JadwalPakan jadwal : daftarJadwal) {
            jadwal.tampilkanInfo();
        }
    }

    static void menuStaf(Staf staf) {
        int pilihan = 0;
        do {
            try {
                System.out.println("\n===== MENU STAF =====");
                System.out.println("1. Lihat Tugas");
                System.out.println("2. Konfirmasi Tugas");
                System.out.println("3. Lihat Informasi Hewan");
                System.out.println("4. Tambah Riwayat Kesehatan Hewan");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
    
                switch (pilihan) {
                    case 1:
                        staf.lihatJadwal(daftarJadwal);
                        break;
    
                    case 2:
                        System.out.print("Masukkan ID Jadwal yang dikonfirmasi: ");
                        String id = scanner.nextLine();
                        if (!idValid(id)) {
                            System.out.println("ID Jadwal tidak ditemukan.");
                        } else {
                            staf.konfirmasiPakan(daftarJadwal, id);
                        }
                        break;
    
                    case 3:
                        for (Hewan h : daftarHewan) h.tampilkanInfo();
                        break;
    
                    case 4:
                        System.out.print("ID Kesehatan: ");
                        String idKes = scanner.nextLine();
                        System.out.print("ID Hewan: ");
                        String idHewan = scanner.nextLine();
                        if (!idHewanValid(idHewan)) {
                            System.out.println("ID Hewan tidak ditemukan.");
                        } else {
                            System.out.print("Tanggal Periksa: ");
                            String tgl = scanner.nextLine();
                            System.out.print("Status: ");
                            String status = scanner.nextLine();
                            System.out.print("Catatan: ");
                            String catatan = scanner.nextLine();
                            daftarKesehatan.add(new KesehatanHewan(idKes, idHewan, tgl, status, catatan));
                            System.out.println("Data kesehatan ditambahkan.");
                        }
                        break;
    
                    case 5:
                        System.out.println("Keluar dari menu staf.");
                        break;
    
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih antara 1 - 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harap masukkan angka antara 1 - 5.");
            }
        } while (pilihan != 5);
    }
    
    private static boolean idValid(String id) {
        for (JadwalPakan jp : daftarJadwal) {
            if (jp.getIdJadwal().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean idHewanValid(String idHewan) {
        for (Hewan h : daftarHewan) {
            if (h.getId().equals(idHewan)) {
                return true;
            }
        }
        return false;
    }
    
}
