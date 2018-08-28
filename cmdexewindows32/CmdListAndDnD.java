/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmdexewindows32;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author BAsh
 */
public class CmdListAndDnD extends JPanel implements ActionListener, ListSelectionListener
{
    private Set <File> myFileSet;
    private JButton btnAdd, btnClear, btnSort, btnUse;
    private DefaultListModel listModelFiles;
    private JList listFiles;
    private JScrollPane scrollFiles;
    private File selectedFile;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public CmdListAndDnD()
    {
        super( new BorderLayout() );
        myFileSet = new HashSet();
        
        // buttons
        btnAdd = new JButton( "Add More Files" );
            btnAdd.setToolTipText( "Button to select more file(s)." );
            btnAdd.setEnabled( true );
        btnClear = new JButton( "Clear All Files" );
            btnClear.setToolTipText( "Remove all files from the selection." );
            btnClear.setEnabled( false );
        btnSort = new JButton( "Sort Files" );
            btnSort.setToolTipText( "Sort all files according according to:  ");
            btnSort.setEnabled( false );
        btnUse = new JButton( "Use Selection");
            btnUse.setToolTipText( "Select the file(s) required then press this button." );
            btnUse.setEnabled( false );
        
        // File lists
        listModelFiles = new DefaultListModel();
        listFiles = new JList( listModelFiles );
        listFiles.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
        listFiles.setFont( new Font( "Courier New", Font.PLAIN, 12 ));
        
        // File scrollers
        scrollFiles = new JScrollPane( listFiles );
        scrollFiles.setPreferredSize( new Dimension( 300, 200 ));
        
        // Listeners
        listModelFiles.addListDataListener( new FileListDataListener() );
        listFiles.addListSelectionListener( this );
        btnAdd.addActionListener( this );
        btnClear.addActionListener( this );
        btnSort.addActionListener( this );
        btnUse.addActionListener( this );
        
        
        
    }

     
    
   /**
    * For Lists
    * @param e 
    */
   @Override
   public void valueChanged(ListSelectionEvent e)
   {
      if ( e.getSource() == listFiles )
      {
         selectedFile = (File)listFiles.getSelectedValue();        
         System.out.println( selectedFile.getName() );
      }   
   }

    /**
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == btnAdd )
        {

        }
        if (ae.getSource() == btnClear )
        {

        }
        if (ae.getSource() == btnSort )
        {

        }
        if (ae.getSource() == btnUse )
        {

        }    
    }
        
    
    /**
     * To deal with changes to lists
     */
    class FileListDataListener implements ListDataListener
    {

        @Override
        public void contentsChanged( ListDataEvent e )
        {
            System.out.println ("Contents Changed: "
                                + e.getIndex0() + ", " 
                                + e.getIndex1());
        }
        @Override
        public void intervalAdded(ListDataEvent e) {
            System.out.println ("Interval Added: "
                                + e.getIndex0() + ", " 
                                + e.getIndex1());
        }
        @Override
        public void intervalRemoved(ListDataEvent e) 
        {
            System.out.println ("Interval Removed: "
                                + e.getIndex0() + ", " 
                                + e.getIndex1());
        }
    }
}
