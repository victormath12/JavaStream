package javastream.core;
import javastream.exeptions.CharNotFoundException;
import javastream.stream.Stream;
import javastream.stream.StreamImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author victorsax12@gmail.com
 */
public class JavaStreamCoreTest {
 
 

  /**
   * Teste do método firstChar, o mesmo deve receber um Stream e retornar o valor esperado
   */
  @Test
  public void firstCharTest() throws Exception {


    //Input de Teste
    String input = "aAbBABacafe";
    Stream streamText = new StreamImpl(input);


    //Resultado Esperado
    char expResult = 'e';


    //Execução do Método
    char result = JavaStreamCore.firstChar(streamText);


    //O Método deve retornar o expResult
    assertEquals(expResult, result);


  }




  /**
   * Teste do método firstChar, no qual não encontrará o char, 
   * com isso, deverá retornar um CharNotFoundException
   */
  @Test(expected = CharNotFoundException.class)
  public void charNotFoundTest() throws CharNotFoundException{
    
   
    //Input de Teste
    String input = "aafbUuzyuU";
    Stream streamText = new StreamImpl(input);


    //Execução do Método (Deve retornar a Exception)
    JavaStreamCore.firstChar(streamText);
    

  }

 
  
}
