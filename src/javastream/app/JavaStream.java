package javastream.app;
import javastream.core.JavaStreamCore;
import javastream.stream.Stream;
import javastream.stream.StreamImpl;
import javax.swing.JOptionPane;

/**
 * @author victorsax12@gmail.com
 */
public class JavaStream {

 
 
 /**
  * Método MAIN
  * @param args
  */
 public static void main(String[] args) {

  try{
   
    //Solicitar input do Usuário
    String inputText = JOptionPane.showInputDialog("Digite uma Palavra:");
    
    
    //Aceitar apenas caracteres (não aceitar números)
    if(!ValidarInput(inputText))
     throw new Exception("Valor Inválido! Tente Novamente");

    
    //Criar Stream a partir do input do usuário
    Stream streamText = new StreamImpl(inputText);
    
    
    //[CORE METHOD] Retornar primeira vogal válida
    char firstChar = JavaStreamCore.firstChar(streamText);
    
    
    //Mostrar Mensagem na Tela
    JOptionPane.showMessageDialog(null, "Caracter Encontrado: " + firstChar);

    
  }catch(Exception erro){
   JOptionPane.showMessageDialog(null, erro.getMessage());
  } 
  
 }
 
 
 //Metodo para Validar o Input do Usuario
 public static boolean ValidarInput(String text) {
   return text.matches("[^\\d]+");
 }
  
 
}
