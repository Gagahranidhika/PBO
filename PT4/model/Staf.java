package model;

// INHERITANCE: Child dari Akun
public class Staf extends Akun {
    private String jabatan; 

    public Staf(String id, String nama, String password, String noTelp, String jabatan) {
        super(id, nama, password, noTelp);
        this.jabatan = jabatan;
    }

    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    // POLYMORPHISM OVERRIDE
    @Override
    public void tampilkanInfo() {
        System.out.println("=== Staf ===");
        super.tampilkanInfo();
        System.out.println("Jabatan: " + jabatan);
    }
}
