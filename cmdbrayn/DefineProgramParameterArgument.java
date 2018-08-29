/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmdbrayn;

import java.util.Map;
import java.util.TreeMap;

/**
 *
* @author brya-n   https://github.com/brya-n
 */
public class DefineProgramParameterArgument
{
   private static String programString;
   private static String parameterString;
   private TreeMap<String, String> argumentMap;
   
   public DefineProgramParameterArgument( String myProgram, String myParameter )
   {
      programString = myProgram;
      parameterString = myParameter;
      argumentMap = new TreeMap();
   }
   
   /**
    * Determines if the program is the same (case insensitive)
    * @param myProgram
    * @return true if the same program, otherwise false
    */
   public boolean isSameProgram( String myProgram )
   {
      return ( programString.toUpperCase().equals( myProgram.toUpperCase()));
   }
           
   /**
    * Update the current TreeMap of arguments
    * @param argument String of the argument
    * @param definition String of the description of the argument
    */
   public void addToArguments( String argument, String definition )
   {
      argumentMap.put(argument, definition);
   }

   
   /**
    * @param argument String of argument, case sensitive
    * @return true if present, false if not found
    */
   public boolean isArgumentPresent( String argument )
   {
      return doesArgumentExist(argument);
   }
   
   
   /**
    * Removes an argument in the TreeMap of arguments
    * @param argument
    * @return true if successful, false if not
    */
   public boolean removeArgument( String argument )
   {
      if ( doesArgumentExist(argument) )
      {
         argumentMap.remove( argument );
         return true;          
      }
      return false;
   }   
   
   /**
    * Get the program associated with an instance of this object
    * @return String
    */
   public String getProgram()
   {
      return programString;
   }
   
   /**
    * Get the parameter associated with an instance of this object
    * @return String
    */
   public String getParameter()
   {
      return parameterString;
   }
   
   /**
    * Gets all the arguments
    * @return TreeMap of all the arguments
    */
   public TreeMap<String, String> getAllArguments()
   {
      return argumentMap;
   }
   
   /**
    * Returns a description of an argument
    * @param argument
    * @return String
    */
   public String getArgumentDescription( String argument )
   {
      if ( doesArgumentExist(argument) )
      {
         return argumentMap.get(argument);
      }
      return "Exception: Argument not present";
   }
    
   
   /**
    * Helper method to check if an argument is present, code refactoring
    * @param argument single argument
    * @return 
    */
   private boolean doesArgumentExist( String argument )
   {
      return ( argumentMap.containsKey(argument) );
   }
   
}
