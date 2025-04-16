package model;

// INHERITANCE: Child dari Akun
public class Admin extends Akun {
    public Admin(String id, String nama, String password, String noTelp) {
        super(id, nama, password, noTelp);
    }

    // POLYMORPHISM OVERRIDE
    @Override
    public void tampilkanInfo() {
        System.out.println("=== Admin ===");
        super.tampilkanInfo();
    }
}
