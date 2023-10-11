package compte;
public class compteEpargne extends Compte{
    private double taux;
    public compteEpargne(double solde, double taux){
        super(0, 0, "ihssane");
        this.taux=taux;
    }
    public void calculInteret(){

        solde = solde*(1+taux/100);
    }
    @Override
    public void Retirer(float mt){
        solde-=mt;
    }

    @Override
    public void versement(float montant) {

    }

    @Override
    public void updatSolde(){

    }
    public String toString(){
        return ("compte Epargne "+this.solde+ "taux="+taux);
    }

}
