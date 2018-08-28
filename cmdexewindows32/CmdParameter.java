/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmdexewindows32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.commons.exec.CommandLine;
/**
 *
 * @author BAsh
 */
public class CmdParameter 
{
   private boolean isSynch = false;
   private final List DEFAULTLIST;
   private Map synchMap;
   
   public CmdParameter( )
   {
      isSynch = true;
      
      DEFAULTLIST = new ArrayList< String >();
      DEFAULTLIST.add( "DEFAULT" );
      
      synchMap = Collections.synchronizedMap( new HashMap< String, ArrayList<String>>()); 
      synchMap.put( "${cmdExe0}", DEFAULTLIST );
   }
   
   public boolean isSynchronized( )
   {
      return isSynch;
   }
   
   /**
    * 
    */
   public void createFullCommand()
   {
      HashMap tempMap = new HashMap();
      int i = synchMap.size();
      int j = 0;
      
      String tempKey;
      Iterator itKey = synchMap.keySet().iterator();
      ArrayList<String> tempList = new ArrayList();
      
      
      // return CommandLine
   }
   
   public boolean addKey( String myKey )
   {
      boolean b = false;
      if ( ! synchMap.containsKey( myKey ))
      {
         synchMap.put( myKey, DEFAULTLIST );
         b = true;
      }
      return b;
   }
   
   /**
    * 
    * @param myKey
    * @param myValue
    * @return 
    */
   public boolean updateDefaultKey( String myKey, ArrayList<String> myValue )
   {
      boolean b = false;
      
      if ( synchMap.get( myKey ).equals( "DEFAULT" ))
      {
         synchMap.put( myKey, myValue );
         b = true;
      }
      return b;
   }
   
   /**
    * 
    * @param delim
    * @param args
    * @return 
    */
   public synchronized ArrayList< String > createValue( String delim, String args )
   {
      ArrayList myArgs = new ArrayList< String >();
      StringTokenizer specified = new StringTokenizer( delim, args );
      while ( specified.hasMoreTokens() )
      {
         myArgs.add( specified.nextToken() );
      }
      return myArgs;
   }
   
 
   /**
    * 
    * @param myKey
    * @return 
    */
   protected boolean deleteKey( String myKey )
   {
      boolean b = false;
      if ( synchMap.containsValue( myKey))
      {
         synchMap.remove( myKey );
         b = true;
      }
      return b;
   }
   
   /**
    * 
    * @return 
    */
   protected boolean defaultCmdMap()
   {
      synchMap.clear();
      synchMap.put( "${cmdExe0}", DEFAULTLIST );
      return true;
   }
       
}
