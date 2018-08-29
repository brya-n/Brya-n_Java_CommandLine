/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmdbrayn;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



/**
 * Class to execute command line executions
* @author brya-n   https://github.com/brya-n
 */
public class CreateTemplate
{   
   private static final String NEWLINE = "\n";
   
   public CreateTemplate()
   {
      
   }
   
   /**
    * Create a command line definition
    * Dir                        =  0
    * Dir /w                     =  1
    * ffplay -f h264 -i myFile   =  2
    * @param numberOfParameters only specify parameters not arguments
    * @return a command line definition with place holders
    */
   public TreeMap<String, String> createCommandDefinition( int numberOfParameters )
   {
      return defineCommandLine( numberOfParameters );
   }
   
   /**
    * Display the command line parameters
    * @param numberOfParameters
    * @return a String representing the command line definition
    */
   public String showCommandDefinition( int numberOfParameters )
   {
      return defineCommandLine( numberOfParameters ).toString(); 
   }

   
   /**
    * Creates a custom map with total parameters, code reuse
    * @param inMap
    * @param numberOfParameters
    * @return 
    */
   public TreeMap<String, String> overwriteDefinitionMap ( TreeMap<String, String> inMap,
                                             int numberOfParameters )
   {
      TreeMap<String, String> tempMap = defineCommandLine( numberOfParameters );
      tempMap.putAll( inMap );
      return tempMap;
   }
   
   
   /**
    * Creates a definition map with additional parameters
    * @param inMap
    * @param additionalParameters
    * @return 
    */
   public TreeMap<String, String> extraDefinitions( TreeMap<String, String> inMap, 
                                             int additionalParameters )
   {
      int currentParameters = Integer.valueOf(inMap.get( "TXT_PARAMS" ));
      TreeMap<String, String> tempMap = defineCommandLine( 
                                 currentParameters + additionalParameters );
      inMap.put( "TXT_PARAMS", tempMap.get( "TXT_PARAMS" ));
      
      // remove zero arguments
      if ( currentParameters == 0 )
      {
         inMap.remove( "${0_p}" );
         inMap.remove( "${0_q}" );
      }
      
      Iterator it = tempMap.entrySet().iterator();
      while ( it.hasNext() )
      {
         Map.Entry tempPair = (Map.Entry)it.next(); 
         String tempKey = tempPair.getKey().toString();
         if ( ! inMap.containsKey( tempPair.getKey() ))
         {
            inMap.put(tempKey, null);           
         }
      }     
      return inMap;
   }
   
   /**
    * Create and return a definition of a command line
    * @param numberArguments total number of parameters
    * @return 
    */
   private TreeMap<String, String> defineCommandLine( int numberOfParameters )
   {      
      // Define initial command placement and place within
      TreeMap<String, String> cmdMap = new TreeMap();
      
      // Specify how many parameters to lookup
      cmdMap.put("TXT_PARAMS", "" + numberOfParameters );
      cmdMap.put( "${0_c}", null );
        
      // Create placeholders for argument, from 0 .. *
      String tempParameter;
      String tempArgument;
      
      // for a command on its' own
      if ( numberOfParameters == 0 )
      {
         cmdMap.put( "${0_p}", null );       
         cmdMap.put( "${0_q}", null );
      }
      else
      {
         for ( int i = 1; i < numberOfParameters +1; i ++ )
         {
            tempParameter = ( "${" + i + "_p}" );
            cmdMap.put( tempParameter, null );
            
            tempArgument = ( "${" + i + "_q}" );
            cmdMap.put( tempArgument, null );
         }
      }
       
      // return the command line definition placeholder
      return cmdMap; 
   }
  
}
