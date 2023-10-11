package compte;
import java.sql.Date;
class Versement extends Operation {
    public Versement(int numero,Date dateOperation,double montant) {
        super(numero, montant);
    }

   // public Versement(double montant) {
       // super(montant);
   // }
}
