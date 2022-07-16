

public class Hovedprogram{
  public static void main(String [] args) throws Exception{
    Salgsystem salgSys = new Salgsystem();
    salgSys.leseFrafil("kunde_produkter.txt");
    salgSys.ordre_lokke();
    salgSys.skrivTilFil("kunde_produkter.txt");
  }
}
