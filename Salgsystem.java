import java.util.Scanner;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.File;

class Salgsystem {


    private HashMap<String,Kunde> kunde_liste = new HashMap<>();
    private HashMap<String,Product> product_liste = new HashMap<>();
    private Scanner tastatur = new Scanner(System.in);



    public void leseFrafil(String filnavn) throws Exception{

        Scanner fil = new Scanner(new File(filnavn));
        String linje ;
        Product item = null;
        while(fil.hasNextLine()){
            linje = fil.nextLine();
            if(linje.charAt(0) == '*'){
                item = new Product(linje.substring(1));
                product_liste.put(item.toString(),item);

            }
            else{
                Kunde kundeId;

                if(kunde_liste.containsValue(linje)){
                    kundeId = kunde_liste.get(linje);
                }
                else{
                    kundeId = new Kunde(linje);
                    kunde_liste.put(kundeId.toString(),kundeId);
                }
                kundeId.leggTilproduct(item);
                item.leggTilkunde((kundeId));

            }


        }

    }


    public void skrivUtAlleprodukter_MedTilhorende_Kunde(){
        for(Product product : product_liste.values()){
          System.out.println("produkt: " + product.toString());
          HashMap<String, Kunde> listeAvKunder_somkjooperProduktet = product.listeAvKunder();
          for(Kunde kunde_Som_kjooperProduktet : listeAvKunder_somkjooperProduktet.values()){
            System.out.println(kunde_Som_kjooperProduktet.toString());
          }
        }
    }

    public void skrivTilFil(String filnavn) throws Exception{
        PrintWriter skriver = new PrintWriter(filnavn);
        for(Product product : product_liste.values()){
          skriver.println("*" + product.toString());
          HashMap<String, Kunde> listeAvKunder_somkjooperProduktet = product.listeAvKunder();;
          for(Kunde kunde_Som_kjooperProduktet : listeAvKunder_somkjooperProduktet.values()){
            skriver.println(kunde_Som_kjooperProduktet.toString());
          }
        }
        skriver.close();
    }

      public void leggTilNyttKundeId(){
        System.out.println("Hva er kundeId?");
        String kundeId = tastatur.nextLine();
        kunde_liste.put(kundeId, new Kunde(kundeId));

      }

      public void leggTilNyttProdukt(){
        System.out.println("Hva er produktet ?");
        String product = tastatur.nextLine();
        product_liste.put(product, new Product(product));
      }

      public void skrivUtAlleKunder_somKjoperProduktet(){
        System.out.println("Hvilket produkt vil du se alle kunder til?");
        Product product = product_liste.get(tastatur.nextLine());
        product.SkrivUtKunder();
      }

      public void skrivUtAlleProdukter_Som_Kundenkjoper(){
        System.out.println("Hvilken KundeId vil du se alle produkter til?");
        Kunde kundeId = kunde_liste.get(tastatur.nextLine());
        kundeId.SkrivUtproducts();
      }

      public void meldOpp_KundeId(){
        System.out.println("Hvilken kundeId vil du melde opp?");
        Kunde kundeId = kunde_liste.get(tastatur.nextLine());

        System.out.println("Hvilket produkt vil du melde opp til?");
        Product product = product_liste.get(tastatur.nextLine());

        product.leggTilkunde(kundeId);
        kundeId.leggTilproduct(product);
      }

      public void meldAvKunde(){
        System.out.println("Hvilken KundeId vil du melde av?");
        Kunde kundeId = kunde_liste.get(tastatur.nextLine());

        System.out.println("Hvilket produkt vil du melde av til?");
        Product item = product_liste.get(tastatur.nextLine());

        item.fjern_kunden(kundeId);
        kundeId.fjernprodukt_FraKunden(item);

      }

      public void slettKunde(){
        System.out.println("Hvilken kunde vil du fjerne?");
        Kunde kundeId = kunde_liste.get(tastatur.nextLine());

        kundeId.meldKundenAv();
        if(!kunde_liste.containsValue(kundeId)){
            return;

        }
        kunde_liste.remove(kundeId);
      }

      public void slettproduktet(){
        System.out.println("Hvilket produkt er utsolgt ?");
        Product product = product_liste.get(tastatur.nextLine());

        product.fjern_kunden_fraProduktet();

        if(!product_liste.containsValue(product)){
            return;

        }
        product_liste.remove(product);
      }

      public void finnMestPopulaereProdukt(){
        Product productMedMestFlest_kunderHittil = null;

        for(Product produkt : product_liste.values()){
          if(productMedMestFlest_kunderHittil  == null){
            productMedMestFlest_kunderHittil  = produkt;
          } else {
            if(productMedMestFlest_kunderHittil .total_kunder() < produkt.total_kunder()){
              productMedMestFlest_kunderHittil  = produkt;
            }
          }
        }

        System.out.println("Mest populaere produkt er: " + productMedMestFlest_kunderHittil .toString());
      }

      public void finnMest_storhandlerKunder(){
        Kunde Kundesom_handlerMest = null;

        for(Kunde kundeId : kunde_liste.values()){
          if(Kundesom_handlerMest == null){
            Kundesom_handlerMest = kundeId;
          } else {
            if(Kundesom_handlerMest.total_products() < kundeId.total_products()){
             Kundesom_handlerMest = kundeId;
            }
          }
        }
        System.out.println("Kunden som handler mest hos oss: " + Kundesom_handlerMest.toString());
      }


      public void meny(){
          System.out.println("*************SALGSYSTEM***********");
          System.out.println("1: Legg til ny kunde i system.");
          System.out.println("2: Legg til nytt produkt i system.");
          System.out.println("3: Skriv ut alle kunder som kjooper et spesifikt produkt.");
          System.out.println("4: Skriv ut alle producter en spesifikk kunde tar");
          System.out.println("5: Meld opp en kunde som kjooper produktet.");
          System.out.println("6: Meld av en kunden som ikke lenger kjooper produktet.");
          System.out.println("7: Fjern et kunde fra systemet.");
          System.out.println("8: Fjern et produkt fra systemet.");
          System.out.println("9: Finne ut hvilket produkt som blir kjopt av flest kunder.");
          System.out.println("10: Finne ut hvilken kunde som handler og kjoper mest produkter hos oss.");
          System.out.println("11: Skriv ut alle produkter og hvilke kunder som kjooper dem.");
          System.out.println("0: Avslutt.");


      }
      public void ordre_lokke(){
          int inputFraBruker = -1;

          while(inputFraBruker != 0){
            if(inputFraBruker == 1){
              leggTilNyttKundeId();
            } else if(inputFraBruker == 2){
              leggTilNyttProdukt();
            } else if(inputFraBruker == 3){
              skrivUtAlleKunder_somKjoperProduktet();
            } else if(inputFraBruker == 4){
              skrivUtAlleProdukter_Som_Kundenkjoper();
            } else if(inputFraBruker == 5){
              meldOpp_KundeId();
            } else if(inputFraBruker == 6){
              meldAvKunde();
            } else if(inputFraBruker == 7){
              slettKunde();
            } else if(inputFraBruker == 8){
              slettproduktet();
            } else if(inputFraBruker == 9){
              finnMestPopulaereProdukt();
            } else if(inputFraBruker == 10){
              finnMest_storhandlerKunder();
            } else if(inputFraBruker == 11){
              skrivUtAlleprodukter_MedTilhorende_Kunde();
            }
            meny();
            inputFraBruker = Integer.parseInt(tastatur.nextLine());
          }
      }


}
