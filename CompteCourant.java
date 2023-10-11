package compte;

import Exceptions.SoldeInsuffisantException;

public abstract class CompteCourant extends Compte {
    private double decouvert ;
    public CompteCourant(int code,double solde,double decouvert,String c){
        super(code, solde,c);
        this.decouvert=decouvert;
    }
    @Override
    public boolean retirer(double montant) throws SoldeInsuffisantException {
        if (montant > 0 && (solde - montant) >= -decouvert) {
            solde -= montant;
            // Operations.add(new Retrait(montant));
            return true;
        } else {
            throw new SoldeInsuffisantException("Solde insuffisant pour le retrait.");
        }
    }

    @Override
    public void Retirer(float montant) {

    }

    @Override
    public void updatSolde(){

    }
    public String toString(){
        return("compte courant:"+this.solde+ "decouvert="+decouvert);
    }

}