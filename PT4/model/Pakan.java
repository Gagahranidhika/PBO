package model;

public class Pakan {
    private String idPakan;
    private String jenisPakan;
    private int stokPakan;
    private String tanggalKadaluarsa;

    public Pakan(String idPakan, String jenisPakan, int stokPakan, String tanggalKadaluarsa) {
        this.idPakan = idPakan;
        this.jenisPakan = jenisPakan;
        this.stokPakan = stokPakan;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public String getIdPakan() { return idPakan; }
    public String getJenisPakan() { return jenisPakan; }
    public int getStokPakan() { return stokPakan; }
    public String getTanggalKadaluarsa() { return tanggalKadaluarsa; }
    public void setNama(String nama) { this.jenisPakan = nama; }
    public void setJumlah(int jumlah) { this.stokPakan = jumlah; }
    public void setTanggal(String tanggal) { this.tanggalKadaluarsa = tanggal; }


    public void kurangiStok(int jumlah) {
        if (stokPakan >= jumlah) stokPakan -= jumlah;
        else System.out.println("Stok tidak mencukupi!");
    }

    public void tampilkanInfo() {
        System.out.println("ID Pakan: " + idPakan + ", Jenis: " + jenisPakan);
        System.out.println("Stok: " + stokPakan + ", Kadaluarsa: " + tanggalKadaluarsa);
    }
}
