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
public class Utils {
    public static HashMap<Character, Integer> frequence(String text) {
        HashMap<Character, Integer> frequencies = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        System.out.println("Fréquences :");
        for (char c : frequencies.keySet()) {
            System.out.println(c + ": " + frequencies.get(c));
        }
        
        double somme = 0.0;
        for (double frr : frequencies.values()) {
            somme += frr;
        }
        System.out.println("Somme des frequence: " + somme);
        
        return frequencies;
    }
    
    public static HashMap<Character, Double> probabilite(String text){
        int total_lettres = text.length();
        HashMap<Character,Integer> fr = frequence(text);
        HashMap<Character,Double> prob = new HashMap<>();
        
        for (char c : fr.keySet()) {
            int frequency = fr.get(c);
            double probability = (double) frequency / total_lettres;
            prob.put(c, probability);
        }
        
//        System.out.println("Probabilites :");
//        for (char p : prob.keySet()) {
//            System.out.println(p + ": " + prob.get(p));
//        }
        
        double somme = 0.0;
        for (double probs : prob.values()) {
            somme += probs;
        }
        System.out.println("Somme des probabilités: " + somme);
         
        return prob;
    }
}
