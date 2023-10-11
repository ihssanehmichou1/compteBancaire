package compte;


import java.util.Date;

public class Operation {
    protected int numero;
    protected Date dateOperation;
    protected double montant;

    public Operation(Date dateOperation, double montant){
        this.dateOperation=dateOperation;
        this.montant=montant;
    }


    public int getNumero(){

        return numero;
    }
    public void setNumero(int numero){

        this.numero=numero;
    }
    public Date getDateOperation(){

        return dateOperation;
    }
    public void setDateOperation(Date dateOperation){

        this.dateOperation=dateOperation;
    }
    public double getMontant(){

        return montant;
    }
    public void setMontant(double montant){

        this.montant=montant;
    }
    public String toString() {
        return "Compte1{" + "code=" + numero + ", date=" + dateOperation  + ", montant =" + montant + '}';
    }

}

