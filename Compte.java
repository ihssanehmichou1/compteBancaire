package compte;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import  java.util.Date;

import Exceptions.SoldeInsuffisantException;

public abstract class Compte implements iCompte {
    private int code;
    protected double solde;
    protected String Statut;
    protected double montant;
    private List<Operation> operations;

    public Compte(int code, double solde, String statut) {
        this.code = code;
        this.solde = solde;
        this.Statut = statut;
        this.operations = new ArrayList<>();
    }

    private double getSolde() {
        return solde;
    }
    private void setSolde(double solde) {
        this.solde = solde;
    }

    public void verser(float montant) {
        if (montant > 0) {
            solde += montant;
            operations.add(new Operation(new Date(), montant));
        }
    }

    public boolean retirer(double montant) throws SoldeInsuffisantException {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
//            operations.add(new Operation(new Date(), montant));
            return true;
        } else {
            throw new SoldeInsuffisantException("Solde insuffisant pour le Retrait.java.");
        }
    }

    public double consulterSolde() {
        return solde;
    }

    public List<Operation> consulterOperations() {
        return operations;
    }

    public double totalVersement() {
        double total = 0.0;
        for (Operation operation : operations) {
            if (operation instanceof Versement) {
                total += operation.getMontant();
            }
        }
        return total;
    }

    public double totalRetrait() {
        double total = 0.0;
        for (Operation operation : operations) {
            if (operation instanceof Retrait) {
                total += operation.getMontant();
            }
        }
        return total;
    }


    public void Envoyer(Compte c, float montant) throws SoldeInsuffisantException {
        if (montant <= getSolde()) {
            this.retirer(montant);
            c.verser(montant);
        } else {
            throw new SoldeInsuffisantException("Solde n'est pas verser.");
        }
    }

    public void operationFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ihssa\\AndroidStudioProjects\\compteBancaire\\app\\src\\main\\java\\compte\\compte1.txt",true))){
            for (Operation operat : operations){
                String OperationType = operat instanceof Retrait ? "Retrait.java": "versement";
                String message = "operation de" + OperationType + "" +operat.getDateOperation() + "" + operat.getMontant()+ "compte" +this.getClass().getSimpleName();
                writer.write(message);
                writer.newLine();
            }
            System.out.println("fichiers  created");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
