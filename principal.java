/*
 * Feito por Mauro.
 *
 * FPCT PI 0919
 * Java
 */

package mypackage;

import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.border.*;
import javax.swing.*;

public class principal extends JFrame implements ActionListener{

    //dados
    private static final long serialVersionUID = 1L;

    JFrame gameover;
    JTextField tf;
    JMenuBar mnb;
    JMenu mn, mn2;
    JMenuItem quit;
    JMenuItem regras, acerca;
    JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14, lb15, lb16, lb17, lb18, lb19;
    JLabel background;
    JCheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19;
    JButton [][] bt = new JButton[15][15];
    JButton restart, quit2, regras2, recomecar, quit3;
    JPanel panel, panel1, panel2;

    String[] palavras = {
            "TEATRO","UMBILICAL","PADARIA","LIBERTAR","SENTIR","HUMOR","CARIBE","EMIGRAR","CALOR","APOIO","PESADO","DESVIAR","SOCO","MIGALHA","REPRESENTAR","MENINA","MASCOTE","GALO","MATAGAL"
    };

    String st = "";

    String[][] letra = {
            {"C","P","A","D","A","R","I","A","H","M","E","N","I","N","A"},
            {"O","I","M","A","S","C","O","T","E","G","J","K","E","A","Z"},
            {"R","L","I","P","E","S","A","D","O","X","C","G","P","E","H"},
            {"E","I","G","J","F","A","P","S","U","C","W","H","T","M","S"},
            {"P","B","A","U","V","U","O","M","M","K","D","V","D","I","O"},
            {"R","E","L","L","V","R","I","E","B","L","U","C","V","G","C"},
            {"E","R","H","C","A","L","O","R","I","T","E","A","T","R","O"},
            {"S","-T","A","T","J","H","N","J","L","I","Y","R","Z","A","J"},
            {"E","A","Z","O","S","U","X","Z","I","S","R","I","S","R","K"},
            {"N","R","G","R","E","M","M","C","C","E","F","B","Q","H","L"},
            {"T","N","G","A","L","O","L","F","A","N","C","E","N","N","R"},
            {"A","Q","B","V","N","R","U","Y","L","T","A","S","V","B","U"},
            {"R","W","V","Z","Q","A","U","M","B","I","L","I","C","A","L"},
            {"S","D","E","S","V","I","A","R","I","R","Z","K","Z","X","W"},
            {"J","O","T","B","J","L","M","A","T","A","G","A","L","V","A"}
    };

    Toolkit tlk = getToolkit();
    Dimension dim = tlk.getScreenSize();
    Border blackline, raisedetched, loweredetched, raisedbevel, loweredbevel, empty;
    int ct1, ct2;
    int comp = 1000, alt = 800;
    int comp2 = 500, alt2 = 400;

    //FONTES
    Font arial = new Font("Arial",Font.BOLD,12);
    Font arial2 = new Font("Arial",Font.BOLD,14);

    //Para centrar o programa ao centro do ecra
    //independente das diferentes resoluçoes de cada utilizador

    //contrutor
    public principal() {
        setTitle("Sopa de Letras");
        setLayout(null);

        setIconImage(Toolkit.getDefaultToolkit().getImage(principal.class.getResource("logo2.png")));

        //Abandonar o programa no X da Janela
            setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Bordas
            blackline = BorderFactory.createLineBorder(Color.black);
            raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
            loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
            raisedbevel = BorderFactory.createRaisedBevelBorder();
            loweredbevel = BorderFactory.createLoweredBevelBorder();
            empty = BorderFactory.createEmptyBorder();

        //Barra
            mnb = new JMenuBar();
            mnb.setBorder(empty);

        //File
            mn = new JMenu("File");
            mn.setFont(arial2);

                quit = new JMenuItem("Quit");
                quit.addActionListener(this);
                quit.setFont(arial2);
                mn.add(quit);

            mnb.add(mn);

        //Info
            mn2 = new JMenu("Info");
            mn2.setFont(arial2);

                regras = new JMenuItem("Rules");
                regras.addActionListener(this);
                regras.setFont(arial2);
                mn2.add(regras);

            mn2.addSeparator();

                acerca = new JMenuItem("Help");
                acerca.addActionListener(this);
                acerca.setFont(arial2);
                mn2.add(acerca);

            mnb.add(mn2);

            setJMenuBar(mnb);

        //Painel
            panel = new JPanel(new GridLayout(15,15));
            panel.setBounds(30,60,690,600);

                //Botoes do jogo
                for (ct1=0; ct1<15; ct1++){
                    for (ct2=0; ct2<15; ct2++){
                        bt[ct1][ct2] = new JButton(letra[ct1][ct2]);
                        bt[ct1][ct2].addActionListener(this);
                        bt[ct1][ct2].setBackground(Color.WHITE);
                        bt[ct1][ct2].setCursor(new Cursor(Cursor.HAND_CURSOR));
                        bt[ct1][ct2].setFont(arial);
                       panel.add(bt[ct1][ct2]);
                   }//ct2
                }//ct1

                tf = new JTextField();
                tf.setBounds(35,685,115,25);
                tf. setEnabled(false);
                add(tf);

                //Botao de Reiniciar
                restart = new JButton("Reiniciar");
                restart.setBounds(750,620,100,40);
                restart.addActionListener(this);
                add(restart);

                //Botao de Sair
                quit2 = new JButton("Sair");
                quit2.setBounds(860,620,100,40);
                quit2.addActionListener(this);
                add(quit2);

                //Botao de Regras
                regras2 = new JButton("Regras");
                regras2.setBounds(800,670,100,40);
                regras2.addActionListener(this);
                add(regras2);

            add(panel);

        //Label's
            lb1 = new JLabel("Teatro");
            add(lb1);

            lb2 = new JLabel("Umbilical");
            add(lb2);

            lb3 = new JLabel("Padaria");
            add(lb3);

            lb4 = new JLabel("Libertar");
            add(lb4);

            lb5 = new JLabel("Sentir");
            add(lb5);

            lb6 = new JLabel("Humor");
            add(lb6);

            lb7 = new JLabel("Caribe");
            add(lb7);

            lb8 = new JLabel("Emigrar");
            add(lb8);

            lb9 = new JLabel("Calor");
            add(lb9);

            lb10 = new JLabel("Apoio");
            add(lb10);

            lb11 = new JLabel("Pesado");
            add(lb11);

            lb12 = new JLabel("Desviar");
            add(lb12);

            lb13 = new JLabel("Soco");
            add(lb13);

            lb14 = new JLabel("Migalha");
            add(lb14);

            lb15 = new JLabel("Representar");
            add(lb15);

            lb16 = new JLabel("Menina");
            add(lb16);

            lb17 = new JLabel("Mascote");
            add(lb17);

            lb18 = new JLabel("Galo");
            add(lb18);

            lb19 = new JLabel("Matagal");
            add(lb19);

        //CheckBoxs
            cb1 = new JCheckBox();
            cb1.setEnabled(false);
            add(cb1);

            cb2 = new JCheckBox();
            cb2.setEnabled(false);
            add(cb2);

            cb3 = new JCheckBox();
            cb3.setEnabled(false);
            add(cb3);

            cb4 = new JCheckBox();
            cb4.setEnabled(false);
            add(cb4);

            cb5 = new JCheckBox();
            cb5.setEnabled(false);
            add(cb5);

            cb6 = new JCheckBox();
            cb6.setEnabled(false);
            add(cb6);

            cb7 = new JCheckBox();
            cb7.setEnabled(false);
            add(cb7);

            cb8 = new JCheckBox();
            cb8.setEnabled(false);
            add(cb8);

            cb9 = new JCheckBox();
            cb9.setEnabled(false);
            add(cb9);

            cb10 = new JCheckBox();
            cb10.setEnabled(false);
            add(cb10);

            cb11 = new JCheckBox();
            cb11.setEnabled(false);
            add(cb11);

            cb12 = new JCheckBox();
            cb12.setEnabled(false);
            add(cb12);

            cb13 = new JCheckBox();
            cb13.setEnabled(false);
            add(cb13);

            cb14 = new JCheckBox();
            cb14.setEnabled(false);
            add(cb14);

            cb15 = new JCheckBox();
            cb15.setEnabled(false);
            add(cb15);

            cb16 = new JCheckBox();
            cb16.setEnabled(false);
            add(cb16);

            cb17 = new JCheckBox();
            cb17.setEnabled(false);
            add(cb17);

            cb18 = new JCheckBox();
            cb18.setEnabled(false);
            add(cb18);

            cb19 = new JCheckBox();
            cb19.setEnabled(false);
            add(cb19);


            //BOUNDS
            cb1.setBounds(785,108,17,14);
            cb2.setBounds(785,133,17,14);
            cb3.setBounds(785,158,17,14);
            cb4.setBounds(785,183,17,14);
            cb5.setBounds(785,208,17,14);
            cb6.setBounds(785,233,17,14);
            cb7.setBounds(785,258,17,14);
            cb8.setBounds(785,283,17,14);
            cb9.setBounds(785,308,17,14);
            cb10.setBounds(785,333,17,14);
            cb11.setBounds(785,358,17,14);
            cb12.setBounds(785,383,17,14);
            cb13.setBounds(785,408,17,14);
            cb14.setBounds(785,433,17,14);
            cb15.setBounds(785,458,17,14);
            cb16.setBounds(785,483,17,14);
            cb17.setBounds(785,508,17,14);
            cb18.setBounds(785,533,17,14);
            cb19.setBounds(785,558,17,14);

            lb1.setBounds(815,100,100,30);
            lb2.setBounds(815,125,100,30);
            lb3.setBounds(815,150,100,30);
            lb4.setBounds(815,175,100,30);
            lb5.setBounds(815,200,100,30);
            lb6.setBounds(815,225,100,30);
            lb7.setBounds(815,250,100,30);
            lb8.setBounds(815,275,100,30);
            lb9.setBounds(815,300,100,30);
            lb10.setBounds(815,325,100,30);
            lb11.setBounds(815,350,100,30);
            lb12.setBounds(815,375,100,30);
            lb13.setBounds(815,400,100,30);
            lb14.setBounds(815,425,100,30);
            lb15.setBounds(815,450,100,30);
            lb16.setBounds(815,475,100,30);
            lb17.setBounds(815,500,100,30);
            lb18.setBounds(815,525,100,30);
            lb19.setBounds(815,550,100,30);

            //Painel para por o background
            panel1 = new JPanel();
            panel1.setBounds(0,-5,1000,800);
            //panel1.setBackground(Color.red);
            background = new JLabel("");
            background.setIcon(new ImageIcon(principal.class.getResource("asasd.jpg")));
            panel1.add(background);
            add(panel1);

            //JFRAME (GAMEOVER)
            gameover = new JFrame();
            gameover.setTitle("Fim de Jogo.");
            gameover.setLayout(null);

            gameover.setIconImage(Toolkit.getDefaultToolkit().getImage(principal.class.getResource("logo2.png")));

                //panel2
                panel2 = new JPanel();
                panel2.setBounds(90,30,300,250);
                background = new JLabel("");
                background.setIcon(new ImageIcon(principal.class.getResource("logo.png")));
                panel2.add(background);
                gameover.add(panel2);

                //botao recomecar
                recomecar = new JButton("Recomecar");
                recomecar.setBounds(130,290,140,30);
                recomecar.addActionListener(this);
                gameover.add(recomecar);

                //botao quit
                quit3 = new JButton("Sair");
                quit3.setBounds(280,290,70,30);
                quit3.addActionListener(this);
                gameover.add(quit3);

            gameover.setResizable(false);
            gameover.setBounds(dim.width/2-comp2/2,dim.height/2-alt2/2,comp2,alt2);
            gameover.setVisible(true);

        JOptionPane.showMessageDialog(this,"\nLER PRIMEIRO AS REGRAS ANTES DE JOGAR.","AVISO.",JOptionPane.WARNING_MESSAGE);
        setResizable(false);
        setBounds(dim.width/2-comp/2,dim.height/2-alt/2,comp,alt);
        setVisible(false);

    }//end do contrutor

    //metodos
	/*
	actionPerformed
	*/
    public void actionPerformed(ActionEvent e) {
        int ct3;

        //Tudo o que acontece quando clica nos botoes do jogo
        for (ct1=0; ct1<15; ct1++) {
            for (ct2=0; ct2<15; ct2++) {
                if(e.getSource() == bt[ct1][ct2]) {
                    st += bt[ct1][ct2].getText();
                    bt[ct1][ct2].setBackground(Color.cyan);
                }//if

                tf.setText(st);

            }//ct2
        }//ct1

        for(ct3=0; ct3<19; ct3++) {
            if(st.equals(palavras[ct3])) {
                System.out.println("Encontrou a palavra");

                //limpar sts
                st = "";

                    //selecionar a cb1
                    if(tf.getText().equals("TEATRO")){
                        cb1.setSelected(true);
                    }

                    //selecionar a cb2
                    if(tf.getText().equals("UMBILICAL")){
                        cb2.setSelected(true);
                    }

                    //selecionar a cb3
                    if(tf.getText().equals("PADARIA")){
                        cb3.setSelected(true);
                    }

                    //selecionar a cb4
                    if(tf.getText().equals("LIBERTAR")){
                        cb4.setSelected(true);
                    }

                    //selecionar a cb5
                    if(tf.getText().equals("SENTIR")){
                        cb5.setSelected(true);
                    }

                    //selecionar a cb6
                    if(tf.getText().equals("HUMOR")){
                        cb6.setSelected(true);
                    }

                    //selecionar a cb7
                    if(tf.getText().equals("CARIBE")){
                        cb7.setSelected(true);
                    }

                    //selecionar a cb8
                    if(tf.getText().equals("EMIGRAR")){
                        cb8.setSelected(true);
                    }

                    //selecionar a cb9
                    if(tf.getText().equals("CALOR")){
                        cb9.setSelected(true);
                    }

                    //selecionar a cb10
                    if(tf.getText().equals("APOIO")){
                        cb10.setSelected(true);
                    }

                    //selecionar a cb11
                    if(tf.getText().equals("PESADO")){
                        cb11.setSelected(true);
                    }

                    //selecionar a cb12
                    if(tf.getText().equals("DESVIAR")){
                        cb12.setSelected(true);
                    }

                    //selecionar a cb13
                    if(tf.getText().equals("SOCO")){
                        cb13.setSelected(true);
                    }

                    //selecionar a cb14
                    if(tf.getText().equals("MIGALHA")){
                        cb14.setSelected(true);
                    }

                    //selecionar a cb15
                    if(tf.getText().equals("REPRESENTAR")){
                        cb15.setSelected(true);
                    }

                    //selecionar a cb16
                    if(tf.getText().equals("MENINA")){
                        cb16.setSelected(true);
                    }

                    //selecionar a cb17
                    if(tf.getText().equals("MASCOTE")){
                        cb17.setSelected(true);
                    }

                    //selecionar a cb18
                    if(tf.getText().equals("GALO")){
                        cb18.setSelected(true);
                    }

                    //selecionar a cb19
                    if(tf.getText().equals("MATAGAL")){
                        cb19.setSelected(true);
                    }

            }//if

            //menssagem de game over
            if(cb1.isSelected() == true && cb2.isSelected() == true && cb3.isSelected() == true && cb4.isSelected() == true && cb5.isSelected() == true && cb6.isSelected() == true && cb7.isSelected() == true && cb8.isSelected() == true && cb9.isSelected() == true && cb10.isSelected() == true && cb11.isSelected() == true && cb12.isSelected() == true && cb13.isSelected() == true && cb14.isSelected() == true && cb15.isSelected() == true && cb16.isSelected() == true && cb17.isSelected() == true && cb18.isSelected() == true && cb19.isSelected() == true){
                setVisible(false);
                gameover.setVisible(true);
            }//if
        }//ct3

        //Supostamente reiniciar o jogo através de um botao
        if(e.getSource() == restart){
            JOptionPane.showMessageDialog(this,"\nO seu jogo vai ser reiniciado.","Restart.",JOptionPane.WARNING_MESSAGE);
            st = "";
            tf.setText("");
            for (ct1=0; ct1<15; ct1++) {
                for (ct2=0; ct2<15; ct2++) {
                    bt[ct1][ct2].setBackground(Color.WHITE);
                    cb1.setSelected(false);
                    cb2.setSelected(false);
                    cb3.setSelected(false);
                    cb4.setSelected(false);
                    cb5.setSelected(false);
                    cb6.setSelected(false);
                    cb7.setSelected(false);
                    cb8.setSelected(false);
                    cb9.setSelected(false);
                    cb10.setSelected(false);
                    cb11.setSelected(false);
                    cb12.setSelected(false);
                    cb13.setSelected(false);
                    cb14.setSelected(false);
                    cb15.setSelected(false);
                    cb16.setSelected(false);
                    cb17.setSelected(false);
                    cb18.setSelected(false);
                    cb19.setSelected(false);

                }//ct2
            }//ct1
        }//if

        if(e.getSource() == quit2){
            JOptionPane.showMessageDialog(this,"\nVais perder todo o progresso, ate a proxima.","Sair.",JOptionPane.WARNING_MESSAGE);
            System.gc();
            System.exit(0);
        }//quit2

        if(e.getSource() == quit){
            JOptionPane.showMessageDialog(this,"\nVais perder todo o progresso, ate a proxima.","Sair.",JOptionPane.WARNING_MESSAGE);
            System.gc();
            System.exit(0);
        }//quit

        if (e.getSource() == acerca) {
            JOptionPane.showMessageDialog(this,"\n\tSopa de Letras\nFPCT PI PL 0919\nMauro Maria","Sobre.",JOptionPane.INFORMATION_MESSAGE);
        }//acerca

		//botao das regras
		//mostra as regras
        if (e.getSource() == regras) {
            JOptionPane.showMessageDialog(this,"\n                                                                                                     MODO HARDCORE\n\n" +
                    "So existem palavras na VERTICAL(cima para baixo) e na HORIZONTAL(esquerda para a direita).\n" +
                    "Certifique-se bem onde esta a clicar e se e o local certo caso contrario nao vai poder reformolar a palavra a nao ser que reinicie o jogo.\n" +
                    "Certifique-se que clica ordenamente nas letras caso contrario nao vai formar a palavra.","Regras.",JOptionPane.INFORMATION_MESSAGE);
        }//regras

		//botao das regras numero 2
		//mostra as regras
        if (e.getSource() == regras2) {
            JOptionPane.showMessageDialog(this,"\n                                                                                                     MODO HARDCORE\n\n" +
                    "So existem palavras na VERTICAL(cima para baixo) e na HORIZONTAL(esquerda para a direita).\n" +
                    "Certifique-se bem onde esta a clicar e se e o local certo caso contrario nao vai poder reformolar a palavra a nao ser que reinicie o jogo.\n" +
                    "Certifique-se que clica ordenamente nas letras caso contrario nao vai formar a palavra.","Regras.",JOptionPane.INFORMATION_MESSAGE);
        }//regras2

		//Botao de recomeçar
        if (e.getSource() == recomecar) {
			//limpa a string st
            st = "";
			//limpa a TextField
            tf.setText("");
			//Desmarcar as checkboxes
			//Meter os botoes na default color
            for (ct1=0; ct1<15; ct1++) {
                for (ct2=0; ct2<15; ct2++) {
                    bt[ct1][ct2].setBackground(Color.WHITE);
                    cb1.setSelected(false);
                    cb2.setSelected(false);
                    cb3.setSelected(false);
                    cb4.setSelected(false);
                    cb5.setSelected(false);
                    cb6.setSelected(false);
                    cb7.setSelected(false);
                    cb8.setSelected(false);
                    cb9.setSelected(false);
                    cb10.setSelected(false);
                    cb11.setSelected(false);
                    cb12.setSelected(false);
                    cb13.setSelected(false);
                    cb14.setSelected(false);
                    cb15.setSelected(false);
                    cb16.setSelected(false);
                    cb17.setSelected(false);
                    cb18.setSelected(false);
                    cb19.setSelected(false);

                }//ct2
            }//ct1

			//torna a frame visivel novamente
            setVisible(true);
        }//if

		//Botao de Sair nuemro3
		//Sai da aplicação
        if (e.getSource() == quit3) {
            System.gc();
            System.exit(0);
        }

    }//end metodo

    public static void main(String[] args) {
        principal frm = new principal();
        frm.setVisible(true);
    }//end da main

}//end da class publica
