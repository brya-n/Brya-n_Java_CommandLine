/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmdbrayn;

import java.io.File;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.exec.CommandLine;

/**
 *
* @author brya-n   https://github.com/brya-n
 */
public class DefinedTemplates
{
   private final HashMap< String, SortedMap< String,String> > templateMap;
   private final CreateTemplate aTemplate;
   
   public DefinedTemplates()
   {
      templateMap = new HashMap();
      aTemplate = new CreateTemplate();
      
      // to hold defaults from 0 - 3 args
      for ( int i = 0; i < 4; i ++ )
      {
         String mapLabel = ( i + "_param" );
         templateMap.put( mapLabel, aTemplate.createCommandDefinition(i));
      }
   }
   
   /**
    * Create a custom label with arguments
    * @param myLabel
    * @param totalArguments 
    */
   public void addTemplateToMap( String myLabel, int totalArguments )
   {
      templateMap.put( myLabel, aTemplate.createCommandDefinition(totalArguments));
   }
   
   
}
