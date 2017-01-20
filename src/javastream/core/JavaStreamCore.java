package javastream.core;
import java.util.ArrayList;
import java.util.List;
import javastream.exeptions.CharNotFoundException;
import javastream.stream.Stream;

/**
 * Classe Core que contém a funcionalidade principal da aplicação
 * @author victorsax12@gmail.com
 */
public class JavaStreamCore {
 
 
 /*
 * Método que retorna a primeira vogal unica sucedida de uma consoante que vem após uma vogal
 */
 public static char firstChar(Stream input) throws CharNotFoundException{
  
  
  //Lista de Chars que nao se repetem na Stream
  List<Character> notRepeatedChars = new ArrayList<Character>();
  
  
  //Lista de Chars que se repetem na Stream
  List<Character> repeatedChars = new ArrayList<Character>();
  
  
  //Possiveis Vogais que podem ser retornadas (Vêm depois de uma consoante e não se repetem)
  //(No resultado do algoritimo será considerado sempre a primeira vogal da lista)
  List<Character> possibleVowelsChars = new ArrayList<Character>();
  
  
  //Lista de Vogais do Alfabeto
  String listOfVowels = "aeiouAEIOU";
  
  
  //char anterior no loop
  Character previousChar = null;
  
  
  //char atual no loop
  Character currentChar = null;
  
  
  //boleano que determina se o char atual do loop se repete no Stream
  boolean isRepeatedChar = false;
  
  
  //boleano que determina que foi encontrado a consoante (que sucede após uma vogal)
  boolean consonantFound = false;
  
  
  
  //Loop pelos caracteres do Stream
  while(input.hasNext()){
   

     //Setar o char atual do loop
     currentChar = input.getNext();
     isRepeatedChar = false;
     
     
     //Se o char atual for encontrado na lista de characteres repetidos, o boleano isRepeatedChar e setado como verdadeiro
     //Senão, é verificado se o char está na lista de não repetidos (Significa que o char atual é a primeira repetição do mesmo na Stream)
     //Se for a primeira repetição na Stream, adiciona o char na lista de repetidos
     if(!repeatedChars.contains(currentChar)){
      
        if(notRepeatedChars.contains(currentChar)){
          isRepeatedChar = true;
          notRepeatedChars.remove(currentChar);
          repeatedChars.add(currentChar);
          
          if(possibleVowelsChars.contains(currentChar))
            possibleVowelsChars.remove(currentChar);
          
        }else{
          notRepeatedChars.add(currentChar);
        }
        
     }else{
       isRepeatedChar = true;
     }


     //Verifica se o char é uma Vogal ou uma Constante
     if(!listOfVowels.contains(currentChar.toString())){

       //Se a consoante tiver um char antecessor que é uma vogal,
       //Significa que as proximas vogais poderão ser elegiveis se não se repetirem
       if(previousChar != null && listOfVowels.contains(previousChar.toString()))
         consonantFound = true;
       
     }else{

       //Se foi encontrado a consoante que sucede uma vogal, 
       //todas as vogais podem ser elegiveis, a menos que sejam repetidas
       if(isRepeatedChar == false && consonantFound == true)
        possibleVowelsChars.add(currentChar);

     }
      
      
     //Registra o char anterior para proseguir o loop
     previousChar = currentChar;
        
   
  }//FIM LOOP
  
  
  //Registrar Logs no Console
  System.out.println("Não Repetem - " + notRepeatedChars);
  System.out.println("Repetem - " + repeatedChars);
  System.out.println("Possiveis - " + possibleVowelsChars);
  
  
  
  //Se a Lista de possiveis Vogais tiver um registro (uma vogal que sucede uma consoante e não se repete)
  //Retornar sempre a primeira vogal da lista, que se refere a primeira da Stream
  //Se não encontrar nenhuma, retorna um CharNotFoundException
  if(possibleVowelsChars.size() > 0)
   return possibleVowelsChars.get(0);
  else
   throw new CharNotFoundException();
  
  
 }

  
 
}
