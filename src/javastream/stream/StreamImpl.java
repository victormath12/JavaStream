package javastream.stream;

/**
 * Classe que Implementa as funcionalidades da Stream
 * @version 1.0
 * @author victorsax12@gmail.com
 */
public class StreamImpl implements Stream{
 

  //Atributos Especificos da Stream
  private String streamText;
  private Integer currentIndex;
  private char currentChar;
  
    
  //Construtor
  public StreamImpl(String text) {
    this.streamText = text;
    this.currentIndex = -1;
  }
  
  
  /**
  * Retorna o proximo char disponivel no Stream
  * @return char
  */
  @Override
  public char getNext(){
    currentIndex = currentIndex + 1;
    currentChar = streamText.charAt(currentIndex);
    return currentChar;
  }
  
  
  /**
  * Verifica se existe um proximo char no Stream
  * @return boolean
  */
  @Override
  public boolean hasNext() {
    try {
      char nextChar = streamText.charAt(currentIndex + 1);
      return true;
    }catch(Exception ex){
     return false;
    }
  }


}
