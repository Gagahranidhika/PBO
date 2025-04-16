package model;

public class Hewan {
    private String id;
    private String nama;
    private String jenis;

    public Hewan(String id, String nama, String jenis) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getJenis() { return jenis; }

    public void setNama(String nama) { this.nama = nama; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public void tampilkanInfo() {
        System.out.println("ID: " + id + ", Nama: " + nama + ", Jenis: " + jenis);
    }
}
