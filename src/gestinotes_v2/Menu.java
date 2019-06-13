package gestinotes_v2;


import javax.swing.*;

//*
//* @authors :  Apostu Robert et Mario Huaracha

public class Menu {

    public static void demarrer() {

        String unCodePermanent,unNom,unPrenom,unHistoriqueIncident,unTroubleDiag;
        int uneAnneeNaissance,choix = 0,choixEtudiant = 0, uneCoteS,uneCoteT ;
        double uneNote;

        Groupe unGroupe = new Groupe(1);

        //Choix et affichage du menu

        while (choix != 5){
            choix = Integer.parseInt(JOptionPane.showInputDialog("Entrez le numero de votre choix \n1-Inscrire \n2-Lister \n3-Statistiques \n4-Facturer \n5-Quitter"));
            switch(choix){

                case 1://Ajoute un Etudiant
                    choixEtudiant = Integer.parseInt(JOptionPane.showInputDialog("Entrez le numéro de votre choix "
                            + "\n1-Régulier "
                            + "\n2-Réadaptation "
                            + "\n3-En difficulté"));
                    unCodePermanent = JOptionPane.showInputDialog("Entrez le code permanent: ");
                    unNom = JOptionPane.showInputDialog("Entrez le nom: ");
                    unPrenom = JOptionPane.showInputDialog("Entrez le prénom: ");
                    uneAnneeNaissance = Integer.parseInt(JOptionPane.showInputDialog("Entrez l'année de naissance: "));
                    uneNote = Double.parseDouble(JOptionPane.showInputDialog("Entrez la note: "));

                    if(choixEtudiant==1){ //Regulier
                        try{
                            Etudiant unEtudiant = new Etudiant(unCodePermanent,unNom,unPrenom,uneAnneeNaissance,uneNote);
                            unGroupe.ajouterEtudiant(unEtudiant);

                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else if(choixEtudiant==2){
                        try{
                            unHistoriqueIncident = JOptionPane.showInputDialog("Entrez l'incident");
                            uneCoteS = Integer.parseInt(JOptionPane.showInputDialog("Entrez la Cote S"));
                            EtudiantAdaptation unEtudiant = new EtudiantAdaptation(unCodePermanent,unNom,unPrenom,uneAnneeNaissance,uneNote,uneCoteS,unHistoriqueIncident);
                            unGroupe.ajouterEtudiant(unEtudiant);

                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else {
                        try{
                            unTroubleDiag = JOptionPane.showInputDialog("Entrez le trouble diagnostiqué");
                            uneCoteT = Integer.parseInt(JOptionPane.showInputDialog("Entrez la Cote T"));
                            EtudiantDifficulte unEtudiant = new EtudiantDifficulte(unCodePermanent,unNom,unPrenom,uneAnneeNaissance,uneNote,uneCoteT,unTroubleDiag);
                            unGroupe.ajouterEtudiant(unEtudiant);


                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 2 ://Affiche les informations
                    JOptionPane.showMessageDialog(null, unGroupe.toString());
                    break;

                case 3://Affiche les statistiques
                    try{
                        JOptionPane.showMessageDialog(null, "Moyenne: " + unGroupe.moyenne() +
                                "\nTaux de succes: " + unGroupe.tauxSucces() +
                                "\nMeilleure note: " + unGroupe.meilleur() +
                                "\necart type: " + unGroupe.ecartType() +
                                "\nVariance: " + unGroupe.variance()) ;
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;


                case 4: //facturation
                    JOptionPane.showMessageDialog(null,unGroupe.toFacture());
                    break;

                case 5://quitter l'application
                    JOptionPane.showMessageDialog(null, "Au revoir :) ");
                    break;

                default : JOptionPane.showMessageDialog(null, "Choix invalide, réessayez entre 1 et 5 .. ");
            }
        }
    }
}