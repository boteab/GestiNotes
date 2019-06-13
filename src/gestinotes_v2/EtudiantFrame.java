package gestinotes_v2;

/**
 * @(#)EtudiantFrame1.java
 *
 *
 * @author
 * @version 1.00 2019/5/29
 */
import gestinotes_v2.Etudiant;
import gestinotes_v2.Groupe;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class  EtudiantFrame  extends JFrame implements ActionListener {
    Groupe unGroupe = new Groupe(1);
    String unCodePermanent,unNom,unPrenom,unHistoriqueIncident,unTroubleDiag;
    int uneAnneeNaissance,choix = 0,choixEtudiant = 0, uneCoteS,uneCoteT ;
    double uneNote;
    JPanel panel;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, textCodePermanent;   // les étiquettes
    JTextField textNomEnfant, textPrenomEnfant,textAnneeNaissance;      // les 2 champs de saisie pour le montant et le taux
    JRadioButton radio1, radio2, radio3;         // les 3 boutons radios pour le nombre d'années
    JButton bouton1, bouton2, bouton3, bouton4, bouton5, bouton6;         // les boutons pour calculer et annuler
    ButtonGroup group ;

    // méthode de démarrage de l'application: affiche une fenêtre
    public static void main(String[] args){
        try{
            EtudiantFrame frame=new EtudiantFrame();
            frame.setVisible(true);
            //actionPerformed(event.getSource());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public EtudiantFrame() {
        setTitle("                                     GestiEtudiant                     ");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
//L'endroit ou il faut ecrire les informations concernant l'enfant
        GridLayout gl = new GridLayout(5,2);
        panel.setLayout(gl);

        label1 = new JLabel("Nom de l'enfant: ");
        panel.add(label1);
        textNomEnfant = new JTextField(10);
        panel.add(textNomEnfant);

//Etiquette espace pour aligner
        label6 = new JLabel(" ");
        panel.add(label6);
//Etiquette espace pour aligner
        label7 = new JLabel(" ");
        panel.add(label7);
//Etiquette espace pour aligner
        label13 = new JLabel(" ");
        panel.add(label13);

//Bouton prenom de l'enfant
        label2 = new JLabel("Prenom de l'enfant: ");
        panel.add(label2);
        textPrenomEnfant = new JTextField(10);
        panel.add(textPrenomEnfant);
        group = new ButtonGroup();

//Etiquette espace pour aligner
        label8 = new JLabel(" ");
        panel.add(label8);
//Etiquette espace pour aligner
        label9 = new JLabel(" ");
        panel.add(label9);
//Etiquette espace pour aligner
        label10 = new JLabel(" ");
        panel.add(label10);

//Bouton annee de naissance
        label3 = new JLabel("Année de naissance: ");
        panel.add(label3);
        textAnneeNaissance = new JTextField(10);
        panel.add(textAnneeNaissance);
        //Etiquette espace pour aligner
        label8 = new JLabel(" ");
        panel.add(label8);
//Etiquette espace pour aligner
        label9 = new JLabel(" ");
        panel.add(label9);
//Etiquette espace pour aligner
        label10 = new JLabel(" ");
        panel.add(label10);
        textCodePermanent = new JLabel("Code permanent: ");
        panel.add(label4);
        textPrenomEnfant = new JTextField(10);
        panel.add(textCodePermanent);


//Bouton pour cocher le cas de l'enfant a inscrire
        radio1 = new JRadioButton("Etudiant regulier", true);
        group.add(radio1);
        panel.add(radio1);

        radio2 = new JRadioButton("Etudiant déficient", true);
        group.add(radio2);
        panel.add(radio2);

        radio3 = new JRadioButton("Etudiant adaptation", true);
        group.add(radio3);
        panel.add(radio3);

//Bouton pour les actions a realiser
        bouton1 = new JButton("Inscrire");
        panel.add(bouton1);
        bouton1.addActionListener(this);

//Boutton Noter
        bouton2 = new JButton("Noter");
        panel.add(bouton2);
        bouton1.addActionListener(this);

//Bouton afficher
        bouton3 = new JButton("Afficher");
        panel.add(bouton3);
        bouton1.addActionListener(this);

//Bouton Statistique
        bouton4 = new JButton("Statistiques");
        panel.add(bouton4);
        bouton1.addActionListener(this);

//Bouton pour réinitialiser
        bouton5 = new JButton("Réinitialiser");
        panel.add(bouton5);
        bouton1.addActionListener(this);

//Bouton pour quitter
        bouton6 = new JButton("Quitter");
        panel.add(bouton6);
        bouton1.addActionListener(this);

        add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent event ) {
        try{
            String unNom = (textNomEnfant.getText());
            String unPrenom =  (textNomEnfant.getText());
            int uneAnneeNaissance = Integer.parseInt(textNomEnfant.getText());
            String unCodePermanent = (textCodePermanent.getText());
            switch( Integer.parseInt(JOptionPane.showInputDialog(textAnneeNaissance))){

                case 1:
                    if((event.getSource()==bouton1)){// event.getSource() indique le bouton qui a été actionné
                        radio1.setSelected(true);
                        Etudiant unEtudiant;
                        unEtudiant = new Etudiant (unCodePermanent,unNom, unPrenom, uneAnneeNaissance, uneNote);
                        unGroupe.ajouterEtudiant(unEtudiant);
                        if (radio2.isSelected()){  // pour la durée, c'est la sélection sur un bouton radio qui va déterminer la valeur
                            Etudiant unEtuDiff = new Etudiant(unCodePermanent,unNom,unPrenom,uneAnneeNaissance,uneNote);
                            unGroupe.ajouterEtudiant(unEtuDiff);
                            uneCoteS= Integer.parseInt(JOptionPane.showInputDialog("Entrer la coteS pour l'enfant deficient"));  // on récupère le cas de l'etudiant
                            //JOptionPane.showMessageDialog(null,"Etudiant de type: "+ radio2.isSelected() + "Nom de l'étudiant: " + unNom + "Prenom de l'étudiant: : " + unPrenom + "Année de naissance: " + uneAnneeNaissance);
                            JOptionPane.showMessageDialog(null, "Les infos" + unEtuDiff.toString()) ;//JESSAYE D'APPELER LA METHODE toString() DE LA CLASSE ETUDIANT
                        }
                        else if (radio3.isSelected()){
                            Etudiant unEtuAdap = new Etudiant(unCodePermanent,unNom,unPrenom,uneAnneeNaissance,uneNote);
                            unGroupe.ajouterEtudiant(unEtuAdap);
                            uneCoteT= Integer.parseInt(JOptionPane.showInputDialog("Entrer la coteT pour l'enfant en réadaptation"));
                            JOptionPane.showMessageDialog(null,"Etudiant de type: "+ unEtuAdap.toString());
                        }
                        JOptionPane.showMessageDialog(null,"Confirmation enregistrement de l'enfant avec les données:" + "\n Nom de l'enfant: "+ unNom + "\n Prenom de l'enfant: " + unPrenom + "\n Annee de naissance de l'enfant: " + uneAnneeNaissance +"\n Code permanent: " + unCodePermanent );
                        break;
                    }

                case 2:
                    if((event.getSource()==bouton2)){  //Si boutton noter
                        uneNote=Double.parseDouble(JOptionPane.showInputDialog("Entrer la note de l'étudiant: "));
                        ArrayList<Double> note= new ArrayList<Double>();
                        note.add(uneNote);
                        break;
                    }
                case 3:
                    if (event.getSource()==bouton3){ //Si boutton afficher
                        ArrayList<Double> note= new ArrayList<Double>();
                        for ( int i=0;  i< note.size()  ;  i++)
                            JOptionPane.showMessageDialog(null, "Les informations des étudiants: " + unGroupe.toString());

                        break;
                    }
                case 4:
                    if (event.getSource()==bouton4){ //Si bouton statistiques
                        JOptionPane.showMessageDialog(null, "La moyenne du groupe: " + unGroupe.moyenne() + "Le taux de succes: " + unGroupe.tauxSucces() + "La variance: " + unGroupe.variance() + "L'écart type: " + unGroupe.ecartType()) ;
                        break;
                    }
                case 5:
                    if (event.getSource()==bouton5){  // Si bouton reinitialiser
                        textNomEnfant.setText("");
                        textPrenomEnfant.setText("");
                        textAnneeNaissance.setText("");
                        radio1.setSelected(true);
                        break;
                    }
                case 6:
                    if (event.getSource()==bouton6){  // Si boutton quitter
                        JOptionPane.showMessageDialog(null, "Au revoir!");
                        System.exit(0);
                        break;

                    }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());

        }

    }
}
