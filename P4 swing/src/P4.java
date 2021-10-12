import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class P4 extends JDialog {
    //Attribut
    int t=1;
    private JPanel contentPane;
    private JButton buttonRestart;
    private JButton buttonQuit;
    private JButton button01;
    private JButton button11;
    private JButton button21;
    private JButton button00;
    private JButton button02;
    private JButton button12;
    private JButton button22;
    private JButton button10;
    private JButton button20;
    private JButton button30;
    private JButton button31;
    private JButton button32;
    private JButton button33;
    private JButton button34;
    private JButton button35;
    private JButton button36;
    private JButton button40;
    private JButton button41;
    private JButton button42;
    private JButton button43;
    private JButton button44;
    private JButton button45;
    private JButton button46;
    private JButton button50;
    private JButton button51;
    private JButton button52;
    private JButton button53;
    private JButton button54;
    private JButton button55;
    private JButton button56;
    private JButton button03;
    private JButton button04;
    private JButton button05;
    private JButton button06;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton button23;
    private JButton button24;
    private JButton button25;
    private JButton button26;
    private JButton buttontxt;
    private JButton button60;
    private JButton button61;
    private JButton button62;
    private JButton button63;
    private JButton button64;
    private JButton button65;
    private JButton button66;
    private ArrayList<JButton> listeBtn;
    private ArrayList<JButton> listeBtncol;

    //Constructeur
    public P4() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonRestart);
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onQuit();
            }
        });
        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        //Mon dev
        init();
    }

    // Fonction d'initialisation (appelé dans le contructeur)
    private void init(){
        initListeBtn();
        initEcouteurBtn();
        buttontxt.setText("Resultat");
        for (JButton button: listeBtn){
            button.setBackground(Color.white);
        }
    }

    // Fonction qui initialise la collection de Jbutton
    private void initListeBtn(){
        listeBtn = new ArrayList<>();
        listeBtn.add(button00);
        listeBtn.add(button01);
        listeBtn.add(button02);
        listeBtn.add(button03);
        listeBtn.add(button04);
        listeBtn.add(button05);
        listeBtn.add(button06);

        listeBtn.add(button10);
        listeBtn.add(button11);
        listeBtn.add(button12);
        listeBtn.add(button13);
        listeBtn.add(button14);
        listeBtn.add(button15);
        listeBtn.add(button16);

        listeBtn.add(button20);
        listeBtn.add(button21);
        listeBtn.add(button22);
        listeBtn.add(button23);
        listeBtn.add(button24);
        listeBtn.add(button25);
        listeBtn.add(button26);

        listeBtn.add(button30);
        listeBtn.add(button31);
        listeBtn.add(button32);
        listeBtn.add(button33);
        listeBtn.add(button34);
        listeBtn.add(button35);
        listeBtn.add(button36);

        listeBtn.add(button40);
        listeBtn.add(button41);
        listeBtn.add(button42);
        listeBtn.add(button43);
        listeBtn.add(button44);
        listeBtn.add(button45);
        listeBtn.add(button46);

        listeBtn.add(button50);
        listeBtn.add(button51);
        listeBtn.add(button52);
        listeBtn.add(button53);
        listeBtn.add(button54);
        listeBtn.add(button55);
        listeBtn.add(button56);

        listeBtncol = new ArrayList<>();
        listeBtncol.add(button60);
        listeBtncol.add(button61);
        listeBtncol.add(button62);
        listeBtncol.add(button63);
        listeBtncol.add(button64);
        listeBtncol.add(button65);
        listeBtncol.add(button66);
    }

    // Fonction qui initialise les écouteurs ("click") des boutons
    private void initEcouteurBtn(){
        for (JButton unBouton: listeBtncol  ) {
            unBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClick(unBouton);
                }
            });
        }

        buttonRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRestart();
            }
        });

        buttonQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        });
    }

    // Fonction qui définie la méthode de clic pour les 9 boutons centraux
    private void onClick(JButton s) {

        if (buttontxt.getText().equals("Victoire") || buttontxt.getText().equals("égalité") ){
            clean();
            buttontxt.setText("Resultat");
        }else {

            buttontxt.setText("joueur suivant");
            int nbcase = 43;
            JButton Lebtn;
            int col = 0;

            if (s.getName().equals("col1")) {
                col = 1;
            }
            if (s.getName().equals("col2")) {
                col = 2;
            }
            if (s.getName().equals("col3")) {
                col = 3;
            }
            if (s.getName().equals("col4")) {
                col = 4;
            }
            if (s.getName().equals("col5")) {
                col = 5;
            }
            if (s.getName().equals("col6")) {
                col = 6;
            }

            for (int i = col; i < 42; i = i + 7) {
                Lebtn = listeBtn.get(i);
                if (Lebtn.getBackground()==Color.white) {
                    nbcase = i;
                }
            }


            if (nbcase == 43) {
                buttontxt.setText("colone pleine");
            } else {
                ++this.t;
                Lebtn = listeBtn.get(nbcase);
                if (this.t % 2 == 1) {
                    Lebtn.setBackground(Color.red);
                } else {
                    Lebtn.setBackground(Color.blue);
                }
                win(col,nbcase);
            }


        }

    }

    public void win(int col,int nbcase) {
        JButton Lebtn;
        int j2 = 0;
        int j1 = 0;
        boolean w = false;
        // vertical
        for (int i = col; i < 42; i = i + 7) {
            Lebtn = listeBtn.get(i);
            if (Lebtn.getBackground() == Color.white) {
                j1 = 0;
                j2 = 0;
            }
            if (Lebtn.getBackground() == Color.red) {
                j1 = j1 + 1;
                j2 = 0;
            }
            if (Lebtn.getBackground() == Color.blue) {
                j2 = j2 + 1;
                j1 = 0;
            }
            if (j1 == 4 || j2 == 4) {
                buttontxt.setText("Victoire");
                w = true;
            }
        }
        // horizontal

        j1 = 0;
        j2 = 0;
        for (int y = 0; y < 42; y = y + 7) {
            j1 = 0;
            j2 = 0;
            for (int i = y; i < y + 7; i++) {
                Lebtn = listeBtn.get(i);
                if (Lebtn.getBackground() == Color.white) {
                    j1 = 0;
                    j2 = 0;
                }
                if (Lebtn.getBackground() == Color.red) {
                    j1 = j1 + 1;
                    j2 = 0;
                }
                if (Lebtn.getBackground() == Color.blue) {
                    j2 = j2 + 1;
                    j1 = 0;
                }
                if (j1 == 4 || j2 == 4) {
                    buttontxt.setText("Victoire");
                    w = true;
                }
            }

        }
        //fin


        // diagonal hg a bd

        j1 = 0;
        j2 = 0;
        for (int j = nbcase; j < 42; j = j + 8) {
            if (listeBtn.get(j).getBackground() != Color.white) {
                if (listeBtn.get(j).getBackground() == Color.red) {
                    j1 = j1 + 1;
                    j2 = 0;
                }
                if (listeBtn.get(j).getBackground() == Color.blue) {
                    j2 = j2 + 1;
                    j1 = 0;
                }
                if (j1 == 4 || j2 == 4) {
                    buttontxt.setText("Victoire");
                    w = true;
                }
            } else {

                break;
            }
        }
        for (int j = nbcase; j > -1; j = j - 8) {
            if (listeBtn.get(j).getBackground() != Color.white) {
                if (listeBtn.get(j).getBackground() == Color.red) {
                    j1 = j1 + 1;
                    j2 = 0;
                }
                if (listeBtn.get(j).getBackground() == Color.blue) {
                    j2 = j2 + 1;
                    j1 = 0;
                }
                if (j1 == 5 || j2 == 5) {
                    buttontxt.setText("Victoire");
                    w = true;
                }
            } else {
                break;
            }
        }
       //fin

        //diagonales hd a bg
        j1 = 0;
        j2 = 0;
        for (int j = nbcase; j < 42; j = j + 6) {
            if (listeBtn.get(j).getBackground() != Color.white) {
                if (listeBtn.get(j).getBackground() == Color.red) {
                    j1 = j1 + 1;
                    j2 = 0;
                }
                if (listeBtn.get(j).getBackground() == Color.blue) {
                    j2 = j2 + 1;
                    j1 = 0;
                }
                if (j1 == 4 || j2 == 4) {
                    buttontxt.setText("Victoire");
                    w = true;
                }
            } else {

                break;
            }
        }
        for (int j = nbcase; j > -1; j = j - 6) {
            if (listeBtn.get(j).getBackground() != Color.white) {
                if (listeBtn.get(j).getBackground() == Color.red) {
                    j1 = j1 + 1;
                    j2 = 0;
                }
                if (listeBtn.get(j).getBackground() == Color.blue) {
                    j2 = j2 + 1;
                    j1 = 0;
                }
                if (j1 == 5 || j2 == 5) {
                    buttontxt.setText("Victoire");
                    w = true;
                }
            } else {
                break;
            }
        }




//egalité
        if (t == 43 && !w) {
            buttontxt.setText("égalité");
        }
    }

    // Fonction qui définie la méthode de clic pour le bouton restart
    private void onRestart() {
       clean();
        buttontxt.setText("Resultat");
        t=1;
    }

    private void clean(){
        for (JButton button: listeBtn){
            button.setText(" ");
            button.setBackground(Color.white);
            t=1;
        }
    }

    // Fonction qui définie la méthode de clic pour le bouton quitter
    private void onQuit() {
        // add your code here if necessary
        dispose();
    }

    // méthode principale
    public static void main(String[] args) {
        P4 dialog = new P4();
        dialog.setTitle("Puissance-4");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
