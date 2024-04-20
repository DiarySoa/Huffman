/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman2;

/**
 *
 * @author Darisoa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Huffman h = new Huffman();
        String text = "Diarisoa";
        h.RunHuffman(text);
        
        for (char i :text.toCharArray()) {
            
        System.out.println("Dico : " + h.getCodage().get(i).getCode());
        }
        System.out.println("Dico : " + h.getCodage());


    }
    
}
