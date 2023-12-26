import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

public class Pelanggan extends DataPelanggan{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/minimarket";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    //method untuk mengisi data pelanggan
    public void isiDataPelanggan() throws Exception{
        
        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        
        Scanner scanStr = new Scanner(System.in);
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Masukkan no faktur = ");
        faktur = scanStr.next();
        System.out.print("Masukkan nama pelanggan = ");
        nama = scanStr.next();
        System.out.print("Masukkan no HP = ");
        noHP = scanStr.next();
        System.out.print("Masukkan alamat = ");
        alamat = scanStr.next();
        System.out.print("Masukkan nama barang = ");
        namaBarang = scanStr.next();
        System.out.print("Masukkan harga barang = ");
        hargaBarang = scanIn.nextInt();
        System.out.print("Masukkan jumlah barang = ");
        jmlBarang = scanIn.nextInt();

        scanStr.close();
        scanIn.close();

        String sql = "INSERT INTO pelanggan (no_faktur, nama, no_hp, alamat) VALUE ('%s', '%s', '%s', '%s' )";
            sql = String.format(sql, faktur, nama, noHP, alamat);
            stmt.execute(sql);
    }

    //method untuk mencetak struk
    @Override
    public void Struk() {
        Integer totalBayar = hargaBarang*jmlBarang;
        this.totalBayar = totalBayar;

        //date
        Date date = new Date();
        SimpleDateFormat hari = new SimpleDateFormat("'Hari/Tanggal \t:' EEEEEEEEEE dd-mm-yy");
        SimpleDateFormat jam =  new SimpleDateFormat("'Waktu \t\t:' hh:mm:ss z");

        System.out.println("----------- Thelema Mart -----------");
        System.out.println(hari.format(date));
        System.out.println(jam.format(date));
        System.out.println("No Faktur \t: " + faktur);
        System.out.println("====================================");
        System.out.println("---------- DATA PELANGGAN ----------");
        System.out.println("Nama Pelanggan \t: " + nama);
        System.out.println("No HP \t\t: " + noHP);
        System.out.println("Alamat \t\t: " + alamat);
        System.out.println("------ DATA PEMBELIAN BARANG -------");
        System.out.println("Nama Barang \t: " + namaBarang);
        System.out.println("Harga \t\t: " + hargaBarang);
        System.out.println("Jumlah \t\t: " + jmlBarang);
        System.out.println("Total Bayar \t: " + this.totalBayar);
        System.out.println("------------------------------------");
        System.out.println("Kasir \t\t: Umar Abdullah A\n");

        //method string
        System.out.println("toUperrcase\t: " + nama.toUpperCase() );
        System.out.println("length\t\t: " + nama.length() );

    }
    

}