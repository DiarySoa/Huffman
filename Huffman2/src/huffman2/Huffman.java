/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author Darisoa
 */
public class Huffman {
    ArrayList<Noeud> arbre = new ArrayList<>();
    HashMap<Character, Double> prob = new HashMap<>();
    Noeud racine ;
    HashMap<Character,Noeud> codage = new HashMap<>();

    public ArrayList<Noeud> getArbre() {
        return arbre;
    }

    public void setArbre(ArrayList<Noeud> arbre) {
        this.arbre = arbre;
    }

    public HashMap<Character, Double> getProb() {
        return prob;
    }

    public void setProb(HashMap<Character, Double> prob) {
        this.prob = prob;
    }

    public Noeud getRacine() {
        return racine;
    }

    public void setRacine(Noeud racine) {
        this.racine = racine;
    }

    public HashMap<Character, Noeud> getCodage() {
        return codage;
    }

    public void setCodage(HashMap<Character, Noeud> codage) {
        this.codage = codage;
    }
    
    
    public void getProbabilite(String texte){
        this.setProb(Utils.probabilite(texte));
    }
    
    public void initialisation(){
        for (char p : this.getProb().keySet()) {
            Noeud n = new Noeud();
            n.setSymbole(p);
            n.setProbabilite(this.getProb().get(p));
            this.getArbre().add(n);
        }
    }
    
    public void creationArbre(){
//        PriorityQueue<Noeud> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Noeud::getProba);
        PriorityQueue<Noeud> priorityQueue = new PriorityQueue<>(Comparator.comparing(Noeud::getProbabilite));
        for (Noeud n : this.getArbre()) {
            priorityQueue.offer(n);
        }

        while (priorityQueue.size() > 1) {
            Noeud g = priorityQueue.poll();
            Noeud d = priorityQueue.poll();
            Noeud parent = new Noeud();
            double pro = g.getProbabilite() + d.getProbabilite();
//            parent.setSymbole();
            parent.setProbabilite(pro);
            parent.setGauche(g);
            parent.setDroite(d);
            priorityQueue.offer(parent);
        }

        Noeud root = priorityQueue.poll();
        this.setRacine(root);
    }
    
    public void creerCode(){
        this.getRacine().Codage("", this);
    }
    
    public String HuffmanCode(String texte){
        String code = "";
        for(char c: texte.toCharArray()){
            String cha = String.valueOf(c);
//            System.out.println("ngambany" +this.getCodage().get(cha));
            Noeud valeur = this.getCodage().get(c);
//            String v = cha;
            if (valeur != null){
                cha = valeur.getCode();
            }
//            code = code + v;
            code = code + cha;

            System.out.println("Codage : " + code);
        }
        return code;
    }
    
    public void RunHuffman(String texte){
        this.getProbabilite(texte);
        System.out.println("Probabilite :");
        for (char c : this.getProb().keySet()) {
            System.out.println(c + ": " + this.getProb().get(c));
        }
        this.initialisation();
        this.creationArbre();
        this.creerCode();
        this.HuffmanCode(texte);
        
    }
    
}
