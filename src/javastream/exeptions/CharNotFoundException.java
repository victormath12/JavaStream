package javastream.exeptions;

/**
 * @author victorsax12@gmail.com
 */
public class CharNotFoundException extends Exception{
 
  public CharNotFoundException(){
      super("Nenhum Caracter foi Localizado");
  }
  
  public CharNotFoundException(String msg){
      super(msg);
  }

  public CharNotFoundException(String msg, Throwable cause){
      super(msg, cause);
  }
 
}
