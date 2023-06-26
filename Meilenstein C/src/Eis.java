public class Eis {
    
private String sorte;
private double preisEis;


    public Eis(String sorte, double preisEis){
        this.sorte = sorte;
        this.preisEis = preisEis;
    }

    public String getSorte() {
        return this.sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
    }

    public double getPreisEis() {
        return this.preisEis;
    }

    public void setPreisEis(double preisEis) {
        this.preisEis = preisEis;
    }
}
