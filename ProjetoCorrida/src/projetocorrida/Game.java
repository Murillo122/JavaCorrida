/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorrida;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Murillo
 */
public class Game extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Game
     */
    private boolean jogo = false;
    private boolean space = false;
    private boolean setaUp = false;
    private boolean setaDown = false;
    private boolean setaRight = false;
    private boolean setaLeft = false;

    private Game() { 
        initComponents();
        createBufferStrategy(2);
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            setaUp = true;
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            setaDown = true;
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            setaLeft = true;
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            setaRight = true;
        } else if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            space = true;
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            setaUp = false;
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            setaDown = false;
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            setaLeft = false;
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            setaRight = false;
        } else if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            space = false;
        }
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    @Override
    public void run() {

        PlayWave.novoAudio("som.wav");
        Graphics g;
        int cont = 0;
        long time_music = 45000;
        long time = 700;
        long time2 = 10000;
        long time3 = 800;
        int larcar = 40;
        int altcar = 40;
        long tempoJogo = System.currentTimeMillis();
        int pontos = 0;
        int vel = 1;
        long tempoJogo1 = System.currentTimeMillis();
        int[] score = new int[5];
        for (int i = 0; i < 5; i++) {
            score[i] = 0;
        }

        int j = (int) (Math.random() * 4);

        ArrayList<Elemento> cars = new ArrayList();

        Player p = new Player("C_amarelo.png");
        p.setX(getWidth() / 2 - p.getLargura());
        p.setY(250);
        p.setIncX(0);
        p.setIncY(0);
        p.setAltura((int) p.img.getIconHeight());
        p.setLargura((int) p.img.getIconWidth());

        Energia gas = new Energia(0, -20, larcar, altcar, Color.orange, 0, 0, "can.png");
        gas.setAltura((int) gas.img.getIconHeight());
        gas.setLargura((int)gas.img.getIconWidth());
        gas.setGasosa(100);
        
         //Criando os objetos
        Car car1 = new Car(0, -50, 0, 0, Color.red, 0, 0, "C_azul.png");
        Car car2 = new Car(0, -50, 0, 0, Color.GREEN, 0, 0, "C_White.png");
        Car car3 = new Car(0, -50, 0, 0, Color.CYAN, 0, 0, "C_Pink.png");
        Car car4 = new Car(0, -50, 0, 0, Color.MAGENTA, 0, 0, "C_verde.png");
        car1.setAltura((int) car1.img.getIconHeight());
        car1.setLargura((int) car1.img.getIconWidth());
        car2.setAltura((int) car2.img.getIconHeight());
        car2.setLargura((int) car2.img.getIconWidth());
        car3.setAltura((int) car3.img.getIconHeight());
        car3.setLargura((int) car3.img.getIconWidth());
        car4.setAltura((int) car4.img.getIconHeight());
        car4.setLargura((int) car4.img.getIconWidth());

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        //jogo
        while (true) {

            int i = (int) (Math.random() * 4);
            //desenhando os objetos e definindo seu local
            g = getBufferStrategy().getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.GRAY);
            g.fillRect(90, 0, getWidth() - 190, getHeight());
            g.setColor(Color.WHITE);
            g.drawString(" Energia = " + gas.getGasosa(), 5, 70);
            g.setColor(Color.WHITE);
            g.drawString(" Pontuacao = " + pontos, 5, 80);
            g.setColor(Color.WHITE);
            g.drawString(vel + "/5", 10, 90);
            PlayWave p1 = new PlayWave(0);

            //inicio de jogo{
            if (jogo) {
                //music
                if (time_music + 45000 < System.currentTimeMillis()) {
                    p1.start();
                    time_music = System.currentTimeMillis();
                }
                //energia
                if (time2 + 10000 < System.currentTimeMillis() && gas.getY() < getHeight()) {

                    if (j == 0) {
                        gas.setIncY(vel);
                        gas.setX(100);

                    }
                    if (j == 1) {
                        gas.setIncY(vel);
                        gas.setX(getWidth() - 265);

                    }
                    if (j == 2) {
                        gas.setIncY(vel);
                        gas.setX(getWidth() - 210);

                    }
                    if (j == 3) {
                        gas.setIncY(vel);
                        gas.setX(getWidth() - 150);

                    }

                    time2 = System.currentTimeMillis();
                }

                //cars
                if (time + 700 < System.currentTimeMillis()) {
                    if (i == 0) {
                        cars.get(i).setIncY(vel);
                        cars.get(i).setX(100);

                    }
                    if (i == 1) {
                        cars.get(i).setIncY(vel);
                        cars.get(i).setX(getWidth() - 265);

                    }
                    if (i == 2) {
                        cars.get(i).setIncY(vel);
                        cars.get(i).setX(getWidth() - 210);

                    }
                    if (i == 3) {
                        cars.get(i).setIncY(vel);
                        cars.get(i).setX(getWidth() - 150);

                    }
                    time = System.currentTimeMillis();
                }
                //contando tempo de jogo
                if (tempoJogo + 10000 < System.currentTimeMillis()) {
                    pontos += 10;

                    tempoJogo = System.currentTimeMillis();
                }
                if (tempoJogo1 + 15000 < System.currentTimeMillis()) {
                    if (vel <= 5) {
                        vel++;
                    }

                    tempoJogo1 = System.currentTimeMillis();
                }
                //contando energia
                if (time3 + 800 < System.currentTimeMillis()) {
                    gas.setGasosa(gas.getGasosa() - 1);
                    time3 = System.currentTimeMillis();
                }

                //setando a Posicao
                if (cars.get(i).getY() > getHeight()) {
                    cars.get(i).setY(-50);
                    cars.get(i).setIncY(0);
                }
                //setando posicao energia
                if (gas.getY() > getHeight()) {
                    gas.setY(-20);
                    gas.setIncY(0);
                    j = (int) (Math.random() * 4);
                }
                //controle
                if (setaDown) {
                    p.setIncY(3);

                } else if (setaUp) {
                    p.setIncY(-3);

                } else {
                    p.setIncY(0);
                }
                if (setaLeft) {
                    p.setIncX(-3);
                } else if (setaRight) {
                    p.setIncX(3);

                } else {
                    p.setIncX(0);
                }
                //colisao energia
                if (p.colisaoComElemento(gas)) {
                    gas.setGasosa(gas.getGasosa() + 20);
                    pontos += 50;
                    gas.setY(-20);
                    gas.setIncY(0);

                }
                //colisao carro
                for (int k = 0; k < cars.size(); k++) {
                    if (p.colisaoComElemento(cars.get(k))) {
                        jogo = !jogo;
                        p.setIncX(0);
                        p.setIncY(0);
                        gas.setIncY(0);
                        for (Elemento e : cars) {
                            e.setIncY(0);
                        }

                    }
                }
                //parar sem energia
                if (gas.getGasosa() <= 0) {
                    p.setIncX(0);
                    p.setIncY(0);
                    gas.setIncY(0);
                    for (Elemento e : cars) {
                        e.setIncY(0);
                    }
                    jogo = !jogo;
                }
                p.trataColisaoComJanela(getWidth() - 100, getHeight());
                //}fim de jogo
            } else {
                g.drawString("  1° Score " + score[0], 5, 100);
                g.drawString("  2° Score " + score[1], 5, 110);
                g.drawString("  3° Score " + score[2], 5, 120);
                g.drawString("  4° Score " + score[3], 5, 130);
                g.drawString("  5° Score " + score[4], 5, 140);

                for (int k = 0; k < score.length; k++) {

                    if (pontos > score[k] && cont == 0) {

                        score[k] = pontos;
                        cont++;

                    }

                }

                g.setColor(Color.WHITE);
                g.drawString("PRECIONE ESPAÇO PARA COMEÇAR ", getWidth() / 2 - (110), 100);
                if (space) {
                    jogo = true;
                    cont = 0;
                    for (Elemento c : cars) {

                        c.setY(-50);
                        c.setIncY(0);

                    }
                    vel = 1;
                    time = 500;
                    time2 = 10000;
                    time3 = 800;
                    tempoJogo = System.currentTimeMillis();
                    tempoJogo1 = System.currentTimeMillis();
                    gas.setGasosa(100);
                    pontos = 0;
                }
            }

            //player
            p.desenhar(g);
            p.mover();
            //gas
            gas.desenhar(g);
            gas.mover();

            //desenhar carro
            for (Elemento c : cars) {
                c.desenhar(g);
            }

            //mover carro
            for (Elemento c : cars) {
                c.mover();
            }

            g.dispose();
            getBufferStrategy().show();

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}