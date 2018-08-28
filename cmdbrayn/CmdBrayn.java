/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmdbrayn;

import java.util.TreeMap;

/**
 *
 * @author Bryan.Ash
 */
public class CmdBrayn
{

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      // TODO code application logic here
      CreateTemplate cmd1 = new CreateTemplate();
      int numberArguments = 0;
      
      TreeMap<String, String> myMap = cmd1.createCommandDefinition(numberArguments);
      // Initial      
      System.out.println( myMap.toString() );
      
      // Added arguments
      int addedArguments = 2;
      
      TreeMap<String, String> addMap = cmd1.extraDefinitions(myMap, addedArguments);
      System.out.println( myMap.toString() );
   }
   
}
