package compte;

public class main{
    public static void main(String[] args) throws Exception {
        compteEpargne c1 =new compteEpargne(5000,2);
        Compte c2 =new compteEpargne(5000,2);
        c1.verser(4000);

        c1.consulterOperations();
        System.out.println(c1.totalVersement());
        System.out.println(c2.totalRetrait());
    }
}
