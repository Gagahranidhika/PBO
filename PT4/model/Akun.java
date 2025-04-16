package model;

// INHERITANCE: Superclass dari Admin & Staf
public class Akun {
    // ENCAPSULATION
    protected String id;  
    private String nama; 
    private String password;
    private String noTelp;

    public Akun(String id, String nama, String password, String noTelp) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.noTelp = noTelp;
    }

    // SETTER & GETTER
    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getNoTelp() { return noTelp; }
    public String getPassword() { return password; }

    public void setNama(String nama) { this.nama = nama; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }

    // POLYMORPHISM OVERRIDE 
    public void tampilkanInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("No. Telp: " + noTelp);
    }
    // Method overloading - mengubah hanya noTelp
    public void ubahKontak(String noTelpBaru) {
        this.noTelp = noTelpBaru;
    }

    // Method overloading mengubah noTelp dan nama sekaligus
    public void ubahKontak(String noTelpBaru, String namaBaru) {
        this.noTelp = noTelpBaru;
        this.nama = namaBaru;
    }

}
