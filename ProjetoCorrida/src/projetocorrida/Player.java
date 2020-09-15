/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorrida;

import java.awt.Graphics;

/**
 *
 * @author Murillo
 */
public class Player extends Elemento{

    
    @Override
    public void desenhar(Graphics g) {
     //   g.setColor(getCor());
    //    g.fillRect(x, y, largura, altura);
        g.drawImage(img.getImage(), x, y, null);
    }
    
    public Player(String url)
    {
       super(url);
    }
    
    
    public boolean colisaoComElemento(Elemento elemento) {
        if (x + largura >= elemento.getX() && x < elemento.getX() + elemento.getLargura()
                && y + altura >= elemento.getY() && y <= elemento.getY() + elemento.getAltura()) {
         return true;
        } else {
            return false;
        }

    }
    
}
