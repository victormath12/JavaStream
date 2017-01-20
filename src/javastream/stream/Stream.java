package javastream.stream;

/**
 * Interface Stream
 * @version 1.0
 * @author victorsax12@gmail.com
 */
public interface Stream {
 
   /**
   * Retorna o proximo char disponivel no Stream
   * @return char
   */
   public char getNext();
   
   
  /**
   * Verifica se existe um proximo char no Stream
   * @return boolean
   */
   public boolean hasNext(); 
   
}
