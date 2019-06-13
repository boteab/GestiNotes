package gestinotes_v2;


/**
 *
 * @authors :  Apostu Robert et Mario Huaracha
 */
public class Groupe{
    //Constante
    final static int MAX = 30;

    //Attributs
    int numeroGroupe;
    int nbreEtudiants;
    Etudiant etudiants[];

    //Constructeur
    public Groupe (int unNumeroGroupe){
        numeroGroupe = unNumeroGroupe;
        etudiants = new Etudiant[MAX];
        nbreEtudiants = 0;
    }

    //Methodes

    //Ajoute un Etudiant
    public void ajouterEtudiant(Etudiant unEtudiant)throws Exception{
        etudiants[nbreEtudiants] = unEtudiant;
        if(nbreEtudiants>30)
            throw new Exception("Attention! Le maximum d'élèves a été atteint.");
        nbreEtudiants += 1;
    }

    //Retourne la moyenne du groupe
    public double moyenne() throws Exception{
        double totalNotes = 0;
        if (nbreEtudiants<0)
            throw new Exception("Attention! Il n'y a aucun élève.");
        for (int i =0; i<nbreEtudiants; i++)

            totalNotes += etudiants[i].getNote();
        return totalNotes/nbreEtudiants;
    }

    //Retourne le taux de succes du groupe
    public double tauxSucces(){
        int nombreSucces = 0;
        for (int i =0; i<nbreEtudiants; i++)
            if(etudiants[i].isSucces())
                nombreSucces++ ;
        return (double)nombreSucces/nbreEtudiants;
    }

    //Retourne la meilleire note
    public double meilleur(){
        double meilleureNote = etudiants[0].getNote();
        for (int i =1; i<nbreEtudiants; i++)
            if (etudiants[i].getNote() > meilleureNote)
                meilleureNote = etudiants[i].getNote();
        return meilleureNote;
    }

    //Retourne la variance
    public double variance() throws Exception{
        double ecartMoyenne = 0;
        if (nbreEtudiants<0)
            throw new Exception("Attention! Il n'y a aucun élève.");
        for (int i =0; i<nbreEtudiants; i++)
            ecartMoyenne += Math.pow(etudiants[i].getNote() - moyenne() , 2);
        return ecartMoyenne/nbreEtudiants;
    }

    //Retourne l'écart type
    public double ecartType()throws Exception{
        if (nbreEtudiants<0)
            throw new Exception("Attention! Il n'y a aucun élève.");
        return Math.sqrt(variance());
    }

    //Retourne les informations du groupe
    public String toString(){
        String informations = "";
        for (int i =0; i<nbreEtudiants; i++)
            informations += etudiants[i].toString();
        return informations;
    }
    public String toFacture(){

        String infoFact = "";
        for(int i=0; i<nbreEtudiants; i++)
            infoFact += etudiants[i].toString() + " - Montant de la facture: " + etudiants[i].facturer() + "$";
        return infoFact;
    }

    //Test avec un main
    public static void main (String[] args){
        Groupe unGroupe = new Groupe (22);
        try{
            unGroupe.ajouterEtudiant(new Etudiant ("AA","aa", "aa", 9999, 80));
            unGroupe.ajouterEtudiant(new Etudiant ("BB","bb", "bb", 9999, 90));
            unGroupe.ajouterEtudiant(new Etudiant ("CC","cc", "cc", 9999, 50));
            unGroupe.ajouterEtudiant(new Etudiant ("DD","dd", "dd", 9999, 60));
            System.out.println("Moyenne: " + unGroupe.moyenne());
            System.out.println("Taux de succes: " + unGroupe.tauxSucces());
            System.out.println("Meilleure note: " + unGroupe.meilleur());
            System.out.println("Ecart type: " + unGroupe.ecartType());
            System.out.println("Variance: " + unGroupe.variance());
            System.out.println("Informations: " + unGroupe.toString());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}