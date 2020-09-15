/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorrida;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Abutua
 */
public abstract class Elemento {

    protected int x;
    protected int y;
    protected int incX = 1;
    protected int incY = 1;
    protected ImageIcon img;
    protected Color cor = Color.BLACK;
    protected int largura = 30;
    protected int altura = 30;

   public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public void mover() {
        y = y + incY;
        x = x + incX;
    }

    public boolean colisao(Elemento elementos) {
        //verifica se nao esta colidindo com o mesmo objeto
        if (elementos.equals(this)) {
            return false;
        }

        if (x + largura >= elementos.getX()
                && x < elementos.getX() + elementos.getLargura()
                && y + altura >= elementos.getY()
                && y <= elementos.getY() + elementos.getAltura()) {
            return true;
        } else {
            return false;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getIncX() {
        return incX;
    }

    public void setIncX(int incX) {
        this.incX = incX;
    }

    public int getIncY(){
        return incY;
    }

    public void setIncY(int incY) {
        this.incY = incY;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public Elemento(String url)
    {
        String path = this.getClass().getResource("/").getPath();
        img = new ImageIcon(path+"imagens/"+url);
        altura = img.getIconHeight();
        largura = img.getIconWidth();
    }
    public void trataColisaoComJanela (int width, int height) {

        if (x + largura > width) {
            incX = -1;
        } else {
            if (x < 90) {
                incX = 1;
            }
        }
        if (y + altura > height) {
            incY = -1;
        } else {
            if (y < 0) {
                incY = 1;
            }
        }
    }
   

    public abstract void desenhar(Graphics g);
    
    

}
