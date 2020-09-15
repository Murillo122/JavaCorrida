/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorrida;


import java.awt.Color;
import java.awt.Graphics;
import javax.print.DocFlavor;

/**
 *
 * @author Murillo
 */
public class Car extends Elemento{

    public Car(int x, int y, int largura, int altura, Color cor, int incX, int incY, String url ) {
        super(url);
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.cor = cor;
        this.incX = incX;
        this.incY = incY;
    }

    
    
    public void desenhar(Graphics g) {
        //g.setColor(getCor());
        //g.fillRect((int)x,(int)y,(int)largura,(int)altura);
        g.drawImage(img.getImage(), x, y, null);
    }

   
    
}
