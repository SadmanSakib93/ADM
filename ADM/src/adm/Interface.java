package adm;


import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.ConditionalFeature.SWT;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Interface extends javax.swing.JFrame {
public static int[] queueID=new int[100];
public static int[] finishedID=new int[100];
static double  progressValue=0.0;
public static JLabel progressLabel;
public static String[] data = new String[4];
public static DefaultTableModel queueTableModel;
public static DefaultTableModel finishedTableModel;

StartDownload download[]=new StartDownload[100];
static String  buttonStates[]=new String[100];
  public static  Boolean[] onGoingDownload=new Boolean[50] ;


    public Interface() {
        initComponents();
        for(int I=0;I<40;I++) onGoingDownload[I]=false;
        progressValue=0.0;
        removeButton.setEnabled(false);
        pauseButton.setEnabled(false);
        resumeButton.setEnabled(false);
        startDownloadButton.setEnabled(false);
        
        queueTable.setBackground(Color.GRAY);
        queueTable.setForeground(Color.WHITE);
        queueTable.setRowHeight(30);
        queueTable.setDefaultEditor(Object.class, null); //Table row can be selected but cannot be edited
        
        removeFinishedButton.setEnabled(false);
        openSavedLocation.setEnabled(false);
        
        finishTable.setBackground(Color.GRAY);
        finishTable.setForeground(Color.WHITE);
        finishTable.setRowHeight(30);
        finishTable.setDefaultEditor(Object.class, null); //Table row can be selected but cannot be edited
        updateQueueTable();
        updateFinishedTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        queue = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        queueTable = new javax.swing.JTable();
        addUrlButton = new javax.swing.JButton();
        startDownloadButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        saveLocation = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        finishTable = new javax.swing.JTable();
        openSavedLocation = new javax.swing.JButton();
        removeFinishedButton = new javax.swing.JButton();
        finishTableRefreshButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADM");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFont(new java.awt.Font("Kozuka Gothic Pro H", 0, 12)); // NOI18N

        queue.setBackground(new java.awt.Color(153, 153, 153));
        queue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        queueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Link", "Name", "Location", "Progress"
            }
        ));
        queueTable.setGridColor(new java.awt.Color(153, 153, 153));
        queueTable.setRowHeight(20);
        queueTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                queueTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(queueTable);

        addUrlButton.setBackground(new java.awt.Color(255, 255, 255));
        addUrlButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        addUrlButton.setForeground(new java.awt.Color(204, 0, 0));
        addUrlButton.setText("+");
        addUrlButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addUrlButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addUrlButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addUrlButtonMousePressed(evt);
            }
        });
        addUrlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUrlButtonActionPerformed(evt);
            }
        });

        startDownloadButton.setText("START DOWNLOAD");
        startDownloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDownloadButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("PAUSE");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        resumeButton.setText("RESUME");
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });

        removeButton.setText("REMOVE");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("REFRESH");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        saveLocation.setIcon(new javax.swing.ImageIcon("E:\\STUDY\\4.2\\LAB\\NET PROG\\SAMPLE PROJECTS\\ADM\\src\\adm\\save-icon-20.png")); // NOI18N
        saveLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startDownloadButton)
                        .addGap(68, 68, 68)
                        .addComponent(saveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addUrlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(pauseButton)
                .addGap(71, 71, 71)
                .addComponent(resumeButton)
                .addGap(69, 69, 69)
                .addComponent(removeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addUrlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(startDownloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resumeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        queue.addTab("QUEUE", jPanel1);

        finishTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "SAVED LOCATION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        finishTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finishTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(finishTable);
        if (finishTable.getColumnModel().getColumnCount() > 0) {
            finishTable.getColumnModel().getColumn(0).setResizable(false);
            finishTable.getColumnModel().getColumn(0).setHeaderValue("NAME");
            finishTable.getColumnModel().getColumn(1).setResizable(false);
            finishTable.getColumnModel().getColumn(1).setHeaderValue("SAVED LOCATION");
        }

        openSavedLocation.setText("OPEN");
        openSavedLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSavedLocationActionPerformed(evt);
            }
        });

        removeFinishedButton.setText("REMOVE");
        removeFinishedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFinishedButtonActionPerformed(evt);
            }
        });

        finishTableRefreshButton.setText("REFRESH");
        finishTableRefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishTableRefreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(finishTableRefreshButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeFinishedButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openSavedLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openSavedLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeFinishedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finishTableRefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        queue.addTab("FINISHED", jPanel2);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(96, 25));

        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu1.setText("Settings");
        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu2.setText("About");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(queue)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(queue)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Change color on mouse press
    private void addUrlButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUrlButtonMousePressed
        addUrlButton.setBackground(Color.darkGray);
        addUrlButton.setForeground(Color.white);
        
    }//GEN-LAST:event_addUrlButtonMousePressed
   //Change color on mouse Enter
    private void addUrlButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUrlButtonMouseEntered
        addUrlButton.setBackground(Color.LIGHT_GRAY);
        addUrlButton.setForeground(Color.red);
    }//GEN-LAST:event_addUrlButtonMouseEntered

    private void addUrlButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUrlButtonMouseExited
        addUrlButton.setBackground(Color.white);
        addUrlButton.setForeground(Color.red);
    }//GEN-LAST:event_addUrlButtonMouseExited

    private void addUrlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUrlButtonActionPerformed
        AddURL o=new AddURL();
        o.show();
    }//GEN-LAST:event_addUrlButtonActionPerformed

    //Refresh buttons and refreshes Queue table
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
       updateQueueTable();
        removeButton.setEnabled(false);
        pauseButton.setEnabled(false);
        resumeButton.setEnabled(false);
        startDownloadButton.setEnabled(false);
    }//GEN-LAST:event_refreshButtonActionPerformed

  //Start Download
    private void startDownloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDownloadButtonActionPerformed
            //getQueueID();                      
            int rowIndex = queueTable.getSelectedRow();
            onGoingDownload[rowIndex]=true;

        
        if(rowIndex>=0)
        {
            try {
                int selectedRowIndex = queueTable.getSelectedRow();
                //int selectedColumnIndex = queueTable.getSelectedColumn();
                String urlString = (String) queueTable.getModel().getValueAt(selectedRowIndex, 0);
                String name = (String) queueTable.getModel().getValueAt(selectedRowIndex, 1);
                String location = (String) queueTable.getModel().getValueAt(selectedRowIndex, 2);
                //System.out.print(url);
                URL link = new URL(urlString);
                if (link != null) {
                    pauseButton.setEnabled(true);
                    resumeButton.setEnabled(false);
                    updateButtonState();
                    download[rowIndex]=new StartDownload(link,name,location,rowIndex);

                }
                
                //Thread thread = new Thread();
                //thread.start();
            } catch (MalformedURLException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_startDownloadButtonActionPerformed
  
    //Get The IDs of queue from Queue table    
    public static void getQueueID() 
    {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
        myConn=ConnectDB.connection();
        myStmt = myConn.createStatement();
        myRs = myStmt.executeQuery("select * from queue");
        int index=0;
        while (myRs.next()) 
        {
            queueID[index]=myRs.getInt("queueID");
            //queueID[index]=Integer.parseInt(id);            
            //System.out.println(queueID[index]+"---"+myRs.getInt("queueID"));
            index++;
        }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        getQueueID();
        int rowIndex = queueTable.getSelectedRow();
        if(rowIndex>=0)
        {
            
            int deleteIndex=-1;
            deleteIndex=queueID[rowIndex];

            Connection conn = null;
            PreparedStatement pst=null;
            conn=ConnectDB.connection();
            String qry="DELETE FROM queue WHERE queueID=?";
            try {
                 pst=conn.prepareStatement(qry);
                 pst.setInt(1, deleteIndex);
                 pst.execute();

                 } catch (SQLException ex) {
                    Logger.getLogger(AddURL.class.getName()).log(Level.SEVERE, null, ex);
                }
            //int colIndex = table.getSelectedColumn();
            //System.out.println(rowIndex);
            //System.out.println("Deleted index from table: "+rowIndex+"\t Deleted id from DB:"+queueID[rowIndex]);
            updateQueueTable();
            removeButton.setEnabled(false);
            pauseButton.setEnabled(false);
            resumeButton.setEnabled(false);
            startDownloadButton.setEnabled(false);
        }

    
    }//GEN-LAST:event_removeButtonActionPerformed

    private void queueTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_queueTableMouseClicked
        
        int rowIndex=queueTable.getSelectedRow();
        System.out.println("***  Row: "+rowIndex);
        if(rowIndex>=0){
        //for(int i=0;i<=10;i++) System.out.println("onGoingDownload["+i+"]="+onGoingDownload[i]);
        //System.out.println("***  Row: "+rowIndex+"  ### Button: "+buttonStates[rowIndex]);
        if(onGoingDownload[rowIndex]==true)
        {
            
            if(buttonStates[rowIndex]==("paused")) 
                {
                    pauseButton.setEnabled(false);
                    resumeButton.setEnabled(true);
                }
            else if(buttonStates[rowIndex]==("resumed")) 
                {
                    pauseButton.setEnabled(true);
                    resumeButton.setEnabled(false);
                }
            else
            {
                pauseButton.setEnabled(true);
                resumeButton.setEnabled(true);
            }
        }
        else
        {
           pauseButton.setEnabled(false); 
           resumeButton.setEnabled(false);
        } 
        updateButtonState();
        }

    }//GEN-LAST:event_queueTableMouseClicked

    private void saveLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveLocationActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        // For Directory
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
 
        fileChooser.setAcceptAllFileFilterUsed(false);
 
        int a = fileChooser.showOpenDialog(null);
        if (a == JFileChooser.APPROVE_OPTION) {
          //location.setText(fileChooser.getSelectedFile().toString());
            Connection conn = null;
            PreparedStatement pst=null;
            conn=ConnectDB.connection();
            String qry="UPDATE savelocation SET LocationPath=? WHERE LocationID=1";
            try {
                pst=conn.prepareStatement(qry);
                pst.setString(1, fileChooser.getSelectedFile().toString());

                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(AddURL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveLocationActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        pauseButton.setEnabled(false);
        resumeButton.setEnabled(true);
        int rowIndex = queueTable.getSelectedRow();
        buttonStates[rowIndex]="paused"; 
        download[rowIndex].pause();
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        pauseButton.setEnabled(true);
        resumeButton.setEnabled(false);
        int rowIndex = queueTable.getSelectedRow();
        buttonStates[rowIndex]="resumed"; 
        download[rowIndex].resume();
    }//GEN-LAST:event_resumeButtonActionPerformed
//Refresh buttons and refreshes Finished table
    private void finishTableRefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishTableRefreshButtonActionPerformed
        removeFinishedButton.setEnabled(false);
        openSavedLocation.setEnabled(false);
        updateFinishedTable();
    }//GEN-LAST:event_finishTableRefreshButtonActionPerformed

    private void removeFinishedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFinishedButtonActionPerformed
        getFinishedID();
        int rowIndex = finishTable.getSelectedRow();
        if(rowIndex>=0)
        {

            int deleteIndex=-1;
            deleteIndex=finishedID[rowIndex];

            Connection conn = null;
            PreparedStatement pst=null;
            conn=ConnectDB.connection();
            String qry="DELETE FROM finished WHERE finishID=?";
            try {
                pst=conn.prepareStatement(qry);
                pst.setInt(1, deleteIndex);
                pst.execute();

            } catch (SQLException ex) {
                Logger.getLogger(AddURL.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateFinishedTable();
            removeFinishedButton.setEnabled(false);
            openSavedLocation.setEnabled(false);
        }
    }//GEN-LAST:event_removeFinishedButtonActionPerformed

    private void openSavedLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSavedLocationActionPerformed
        getFinishedID();
        int rowIndex = finishTable.getSelectedRow();
        if(rowIndex>=0)
        {

            int openIndex=-1;
            openIndex=finishedID[rowIndex];

            String openPath="";
            String fileName="";
            Connection conn = null;
            PreparedStatement pst=null;
            ResultSet rs = null;
            conn=ConnectDB.connection();
            String qry="SELECT * FROM finished WHERE finishID=?";
            try {

                pst=conn.prepareStatement(qry);
                pst.setInt(1, openIndex);
                rs=pst.executeQuery();
                while(rs.next())
                {
                    openPath=rs.getString("finishLocation");
                    fileName=rs.getString("finishName");
                }

            } catch (SQLException ex) {
                Logger.getLogger(AddURL.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(openPath+fileName);
            File folder = new File(openPath); // path to the directory to be opened
            System.out.println(folder);
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            try {
                desktop.open(folder);
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_openSavedLocationActionPerformed

    private void finishTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishTableMouseClicked
        removeFinishedButton.setEnabled(true);
        openSavedLocation.setEnabled(true);
    }//GEN-LAST:event_finishTableMouseClicked

    //Get The IDs of queue from Finished table 
    public static void getFinishedID() 
    {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
        myConn=ConnectDB.connection();
        myStmt = myConn.createStatement();
        myRs = myStmt.executeQuery("select * from finished");
        int index=0;
        while (myRs.next()) 
        {
            finishedID[index]=myRs.getInt("finishID");
            index++;
        }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    } 
    
        
    // Update button Enabled or disabled
    public void updateButtonState()
    {
        removeButton.setEnabled(true);
        int selectedRow=queueTable.getSelectedRow();
        if(!onGoingDownload[selectedRow])
        startDownloadButton.setEnabled(true);
        else startDownloadButton.setEnabled(false);
    }
    
    

    
   
    
    public static void getProgress(double val)
    {
        progressValue=val;
        progressLabel.setText(Double.toString(progressValue));
        data[3]=Double.toString(progressValue);
        //tableModel.setRowCount(0);
        queueTableModel.addRow(data);
        queueTable.setModel(queueTableModel);
    }
    
    //Update queue table with database queue table info
    public static void updateQueueTable()
    {
        queueTableModel = (DefaultTableModel) queueTable.getModel();
        queueTableModel.setRowCount(0); //Ata na use korle previous table info gula clear hoina
        Connection conn = null;
        PreparedStatement pst=null;
        ResultSet rs = null;
        conn=ConnectDB.connection();
        try {
            String qry="SELECT queueLink,queueName,queueLocation FROM queue";
            pst=conn.prepareStatement(qry);
            rs=pst.executeQuery();
            while(rs.next())
            {
                
                data[0]=rs.getString("queueLink");
                data[1]=rs.getString("queueName");
                data[2]=rs.getString("queueLocation");
                //queueTable.getColumnModel().getColumn(3).setCellRenderer(new ProgressRenderer(0, 100));
                progressLabel = new JLabel();
                
                progressLabel.setText(Double.toString(progressValue));
                data[3]=Double.toString(progressValue);
            queueTableModel.addRow(data);
            }
            queueTable.setModel(queueTableModel);
            
            
            //queueTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(AddURL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Insert into queue table 
    public static  void insertFinishedTable(String name,String location,int r)
    {
        onGoingDownload[r]=false;
        buttonStates[r]="finished";

        String NAME=name;
        String LOCATION=location;
        Connection conn = null;
        PreparedStatement pst=null;
           conn=ConnectDB.connection();
            String qry="INSERT INTO finished (finishName,finishLocation) value(?,?)";
            try {
                pst=conn.prepareStatement(qry);
                pst.setString(1, NAME);
                pst.setString(2, LOCATION);
                pst.execute();
                updateFinishedTable();
            } catch (SQLException ex) {
                Logger.getLogger(AddURL.class.getName()).log(Level.SEVERE, null, ex);
            }        
    }
    //Update finish table with database finish table info
    public static void updateFinishedTable()
    {
        finishedTableModel = (DefaultTableModel) finishTable.getModel();
        finishedTableModel.setRowCount(0); //Ata na use korle previous table info gula clear hoina
        Connection conn = null;
        PreparedStatement pst=null;
        ResultSet rs = null;
        conn=ConnectDB.connection();
        try {
            String qry="SELECT finishName,finishLocation FROM finished";
            pst=conn.prepareStatement(qry);
            rs=pst.executeQuery();
            while(rs.next())
            {               
                data[0]=rs.getString("finishName");
                data[1]=rs.getString("finishLocation");
            finishedTableModel.addRow(data);
            }
            finishTable.setModel(finishedTableModel);
            
            
            //queueTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(AddURL.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUrlButton;
    private static javax.swing.JTable finishTable;
    private javax.swing.JButton finishTableRefreshButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton openSavedLocation;
    private javax.swing.JButton pauseButton;
    private javax.swing.JTabbedPane queue;
    private static javax.swing.JTable queueTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton removeFinishedButton;
    private javax.swing.JButton resumeButton;
    private javax.swing.JButton saveLocation;
    private javax.swing.JButton startDownloadButton;
    // End of variables declaration//GEN-END:variables
}
