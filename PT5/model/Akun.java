package model;

public abstract class Akun {
    protected String id;  
    protected String nama; 
    private String password;
    protected String noTelp;

    public Akun(String id, String nama, String password, String noTelp) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.noTelp = noTelp;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getNoTelp() { return noTelp; }
    public String getPassword() { return password; }
    public void setNama(String nama) { this.nama = nama; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }

    // Metode abstrak untuk tampilkan info
    public abstract void tampilkanInfo();

    // CRUD Abstract Methods
    public abstract void tambah(Akun akun);
    public abstract void update(String id, String namaBaru, String noTelpBaru);
    public abstract void hapus(String id);
}
