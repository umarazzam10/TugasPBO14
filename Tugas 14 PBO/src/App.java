import java.sql.*;

public class App {
    public static void main(String[] args) {

        //polymorphisme
        DataPelanggan P01 = new Pelanggan();

        Kasir K01 = new Kasir();
        K01.login();
    
    //exception    
    try {
        //mengisi data pelanggan
        P01.isiDataPelanggan();
        //mencetak struk
        P01.Struk();
    } 
    catch (Exception e){
        System.out.println("Terjadi salah input");
    }


    }
}
