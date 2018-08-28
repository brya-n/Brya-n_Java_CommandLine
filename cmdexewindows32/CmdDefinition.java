/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmdexewindows32;

import java.util.*;
import org.apache.commons.exec.CommandLine;

/**
 *
 * @author BAsh
 */
public class CmdDefinition 
{
   // variables for use
   private boolean isPipe;
   private int inStr, outStr;
   
   // Constants
   final static private ArrayList<String> DEFAULT = new ArrayList<>( Arrays.asList( "DEFAULT" ));   
   final static private HashMap< String, ArrayList<String>> EXECMD0 = new HashMap();
   final static private HashMap< String, ArrayList<String>> EXEARG0 = new HashMap();
   
   final static private HashMap< String, ArrayList<String>> INFILE0 = new HashMap();
   final static private HashMap< String, ArrayList<String>> INFILE1 = new HashMap();
   final static private HashMap< String, ArrayList<String>> INARGS1 = new HashMap();   
   
   final static private HashMap< String, ArrayList<String>> OUFILE0 = new HashMap();
   final static private HashMap< String, ArrayList<String>> OUFILE1 = new HashMap();
   final static private HashMap< String, ArrayList<String>> OUARGS1 = new HashMap();      
   
   final static private HashMap< String, ArrayList<String>> PIPCMD1 = new HashMap();
   final static private HashMap< String, ArrayList<String>> PIPARG1 = new HashMap();
   
   final static private HashMap< String, ArrayList<String>> pseudoCmdMap = new HashMap();
   
   public CmdDefinition()
   {
      this.isPipe = false;
      this.inStr = 0;
      this.outStr = 0; 
      EXECMD0.put("${exeCmd0}", DEFAULT );
      EXECMD0.put("${exeArg0}", DEFAULT );
   }

}
