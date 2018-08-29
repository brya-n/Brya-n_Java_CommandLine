/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmdexewindows32;

import java.awt.Font;
import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author brya-n   https://github.com/brya-n
 */
public class CmdActivityLog extends JFrame
{
    private JTextArea log;
    
    private final Font textFont = new Font( "Courier New", Font.PLAIN, 12);    
    
    private static final String NEWLINE = "\n";
    private static final String TAB = "\t";
    private static final String INDENT = "                          ";  
    private static final String WINPATHSEP = "\\";    
    
    
    /**
     * Log dimensions - 20 x 48, read only
     */
    public CmdActivityLog()
    {
        setUpLog( 20, 48, false, 
                  "Log of all main activities, read only." );        
    }
    
    /**
     * Define dimensions, otherwise read only
     * @param width
     * @param height 
     */
    public CmdActivityLog( int width, int height )
    {
        setUpLog( width, height, false, 
                  "Log of all main activities, read only." );
    }    
    
    /**
     * Fully defined log
     * @param width
     * @param height
     * @param isEditable
     * @param aLabel 
     */
    public CmdActivityLog( int width, int height, boolean isEditable, String aLabel )
    {
        setUpLog( width, height, isEditable, aLabel );
    }        

    
    /**
     * Handles definition of the log
     * @param width
     * @param height
     * @param isEditable
     * @param tipText
     * @return 
     */
    private void setUpLog( int width, int height, boolean isEditable, String tipText )
    {
        JTextArea Log = new JTextArea( width, height );
            Log.setMargin( new Insets( 4, 4, 4, 4 ));
            Log.setEditable( isEditable );
            Log.setFont( textFont );
            Log.setToolTipText( tipText );       
    }    
    
    /**
     * 
     * @return 
     */
    public JTextArea getLog()
    {
        return log;
    }
    
    /**
     * 
     * @param savedLogFile 
     */
    protected void saveLog( File savedLogFile )
    {
        try
        {
            if ( ! savedLogFile.exists() )
            {
                savedLogFile.createNewFile();
            }    
            FileWriter fw = new FileWriter( savedLogFile.getAbsoluteFile() );
            try (BufferedWriter writeLog = new BufferedWriter( fw ))
            {
                String myLogString = log.toString();
                writeLog.write( myLogString );
            }
        }   
        catch ( IOException ioe )
        {
            System.out.println( "IOException occured while writing log: " + ioe );
        }        
    }
    
    
    /**
     * 
     * @param timeDate
     * @param sentence 
     */
    protected void addToLog( Boolean timeDate, String sentence )
    {
        // if send time and date to log
        if ( timeDate )
        {
            log.append( getDateTime() + " " + sentence);
        }
        else
        {
            log.append( INDENT + sentence);
        }
        log.append( NEWLINE );
        log.setCaretPosition(log.getDocument().getLength());    
    }
    
    

    
     
    
    /**
     * 
     * @return 
     */
    private String getDateTime()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return ("[ " + dateFormat.format(date) + "]:  ");        
    }
}
