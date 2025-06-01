/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ifdminterfaces;

/**
 *
 * @author douglas
 */
public class IfdmInterfaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.setVisible(true);
        Process process = new Process();
        process.carregarEstados(tela.getUfComboBox());
        
        
    }
    
}
