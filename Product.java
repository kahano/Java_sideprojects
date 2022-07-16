import java.util.HashMap;

class Product{

    private HashMap<String,Kunde> kunder = new HashMap<>();
    private String productId ;

    public Product(String Id){
        this.productId = Id;

    }

    public String toString(){
        return productId;
    }

    public boolean product_erkjoptAv_thiskunde(Kunde id){
        if(kunder.containsValue(id)){
            return true;
        }
        else{
            return false;
        }
    }

    public void leggTilkunde(Kunde id){

        if(product_erkjoptAv_thiskunde(id)){
            System.out.println( productId + "har kjoopt allerede produktet " + id.toString());

        }
        else{
            kunder.put(id.toString(),id);

        }
    }

    public void fjern_kunden(Kunde kundeId){
        if(product_erkjoptAv_thiskunde(kundeId)){
            kunder.remove(kundeId);
        }
        else{
            System.out.println(kundeId.toString() + " er fjernet fra produktet");
        }
    }

    public void fjern_kunden_fraProduktet(){
        for(Kunde kundeId_kjoperProduktet: kunder.values()){
            kundeId_kjoperProduktet.fjernprodukt_FraKunden(this);
        }
    }


    public HashMap<String,Kunde> listeAvKunder(){
        return this.kunder;
    }

    public void SkrivUtKunder(){
        for(Kunde kunde : kunder.values()){
            System.out.println(kunde.toString());
        }
    }

    public int total_kunder(){

        return kunder.size();

    }

}
