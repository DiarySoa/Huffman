/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman2;

import java.util.HashMap;

/**
 *
 * @author Darisoa
 */
public class Noeud{
    char symbole;
    int frequence;
    double probabilite;
    String code;
    Noeud gauche;
    Noeud droite;

    public char getSymbole() {
        return symbole;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public double getProbabilite() {
        return probabilite;
    }

    public void setProbabilite(double probabilite) {
        this.probabilite = probabilite;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Noeud getGauche() {
        return gauche;
    }

    public void setGauche(Noeud gauche) {
        gauche.setCode("0");
        this.gauche = gauche;
    }

    public Noeud getDroite() {
        return droite;
    }

    public void setDroite(Noeud droite) {
        droite.setCode("1");
        this.droite = droite;
    }
    
    
    public void Codage(String code, Huffman h) {
        if (this == null) return;

        if (this.getGauche() == null && this.getDroite() == null) {
            this.setCode(code);
            h.getCodage().put(this.getSymbole(), this);
        }else{
            if(this.getGauche() != null){
                this.getGauche().Codage(code + "0",h);
            }
            if(this.getDroite() != null){
                this.getDroite().Codage(code + "1",h);
            }
        }
    }
    
    
}
