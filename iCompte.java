package compte;

import android.media.VolumeShaper;

import java.util.List;

public interface iCompte {
    void Retirer(float montant);
    void verser(float montant);
    double consulterSolde();
    void updatSolde();
    double totalVersement();
    double totalRetrait();
    public void operationFile();

}

