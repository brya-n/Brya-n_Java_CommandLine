/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmdbrayn;

import java.util.TreeMap;
import java.util.Iterator;

/**
 *
 * @author Bryan.Ash
 */
public class DefineProgramParameters
{
   private static String programString;
   private TreeMap<String, DefineProgramParameterArgument> parameterMap;
   
   public DefineProgramParameters( String aProgram )
   {
      programString = aProgram;
   }
   
   /**
    * Determines if the program is the same (case insensitive)
    * @param myProgram
    * @return true if the same program, otherwise false
    */
   public boolean isSameProgram( String myProgram )
   {
      return ( programString.toLowerCase().equals( myProgram.toLowerCase()));
   }  
      
   
   /**
    * @param parameter
    * @param argument
    * @param definition
    * @param overwrite  true = description will be replaced if exists
    * @return 0:  not done
    *         1:  new parameter, updated
    *         2:  existing parameter with new argument, updated
    *         3:  existing parameter and argument, with amended description
    *         4:  everything overwritten
    */
   public int overwriteParameterArgument( String parameter, String argument, String definition, boolean overwrite )
   {
      return updateParameterArgument( parameter, argument, definition, overwrite );
   }
   
  
   /**
    * Helper method to update a parameter with an argument if it already exists
    * @param parameter
    * @param argument
    * @param definition 
    * @param keepExistingDescription
    */
   private int updateParameterArgument( String parameter, String argument, String definition, boolean keepExistingDescription )
   {
      if ( ! keyExists( parameter ))
      {
         // new existing parameter
         DefineProgramParameterArgument dPPA = 
                 new DefineProgramParameterArgument( argument, definition );
         parameterMap.put( parameter, dPPA );
         return 1;
      }   
      else
      {
         Iterator it = parameterMap.keySet().iterator();
         while (it.hasNext())
         {
            String myKey = it.next().toString();
            if ( myKey.toLowerCase().equals(parameter.toLowerCase()))
            {
               DefineProgramParameterArgument dPPA = 
                    parameterMap.get( myKey ); 
               if ( ! dPPA.isArgumentPresent(argument))
               {
                  dPPA.addToArguments(argument, definition);
                  parameterMap.put( parameter, dPPA);  
                  return 2;
               }
               else
               {
                  if ( keepExistingDescription )
                  {
                     String tempInfo = dPPA.getArgumentDescription(argument);
                     dPPA.addToArguments(argument, definition + "OLD: " + tempInfo ); 
                     parameterMap.put( parameter, dPPA);
                     return 3;
                  }
                  else
                  {
                     String tempInfo = dPPA.getArgumentDescription(argument);
                     dPPA.addToArguments(argument, definition ); 
                     parameterMap.put( parameter, dPPA);
                     return 4;
                  }
               }
            }
         }
      }
      // should never return 0
      return 0;
   }
    
   
   /**
    * Check if a key  exists but case insensitive
    * @param parameter
    * @return true if present, false otherwise
    */
   private boolean keyExists( String parameter )
   {
      // initialised to check if not present
      boolean isAbscent = true;
      Iterator it = parameterMap.keySet().iterator();
      while (it.hasNext() )
      {         
         isAbscent = isAbscent && 
                  // true + false = false
                  // true + true  = true
                  ! (it.next().toString().toLowerCase().equals(parameter.toLowerCase()));
      }
      // true = false if abscent
      return ! isAbscent;
   }
   
}
