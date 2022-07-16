import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.io.PrintWriter;

class Kunde{

    private HashMap<String,Product> products = new HashMap<>();
    private String kundeId ;
    public int antall = 0;

    public Kunde(String Id){
        this.kundeId = Id;

    }

    public String toString(){
        return kundeId;
    }

    public boolean kjoper_kunden_thisprodukt(Product vare){
        if(products.containsValue(vare)){
            return true;
        }
        else{
            return false;
        }
    }

    public void leggTilproduct(Product item){

        if(kjoper_kunden_thisprodukt(item)){
            System.out.println(kundeId + "har kjoopt allerede produktet " + item.toString());
            //antall++;
        }
        else{
            products.put(item.toString(),item);
            //antall = 1;
        }
    }



    // public int total_amount_Ofproduct(){
    //     for(Product item : products.values()){
    //         return item.antall();
    //     }
    // }



    public void fjernprodukt_FraKunden(Product v){
        if(!kjoper_kunden_thisprodukt(v)){
            System.out.println(kundeId + " ikke lenger kjoper dette produktet: " + v.toString());
            return;
        }
        else{
            products.remove(v);
        }
    }

    public void meldKundenAv(){
        for(Product item : products.values()){
            item.fjern_kunden(this);
        }
    }
    public HashMap<String,Product> listeAvproductsr(){
        return this.products;
    }

    public void SkrivUtproducts(){
        for(Product item : products.values()){
            System.out.println(item.toString());
        }
    }

    public int total_products(){

        return products.size();

    }

}
