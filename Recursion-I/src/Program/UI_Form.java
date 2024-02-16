package Program;

import AuxPackage.AuxFile;
import AuxPackage.AuxValidatorForm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UI_Form extends javax.swing.JFrame {

  private boolean needSave;
  private boolean renameCopy;
  private FileFinder finder;
  private FileRenamer renamer;
  private boolean excludeSubs;
  private String outputFile;
  
  private ValidatorSearch searchValidator;


    public UI_Form( ) {
        setSize(1000, 800);

        setBackgroundImage("calculator.jpg");
        setResizable(false);

        initComponents();
        setPosition();
        setBorder();
        InitControls();
        searchValidator = new ValidatorSearch(txtSearchStartFolder,  txtFileToSearch,  txtSearchSaveFile, lblError,  lblFoundFiles,  pnlSearchRads,  btgFileSearchSave,  btnSearchFiles);
    }

    private void setPosition() //put the form in the middle of the screen
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }
 
    public void setBackgroundImage(String imagePath)
    {
      //resizes the images based on the size of the form.
        imagePath = Configs.getImageDirStatic() + imagePath;
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath)); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(getWidth(), getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon = new ImageIcon(newimg);  // transform it back
        setContentPane(new JLabel(imageIcon)); 
    }
    
     
     public void setBorder()
    {
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#182943")));
    }
     
   private void setLoaderIcon(JLabel jComp)
   {
       jComp.setIcon(null);
       jComp.setIcon(new javax.swing.ImageIcon(getClass().getResource(Configs.getImageDirStatic() + "load.gif")));
   }
   
   private void setLoaderIcon(JButton jComp)
   {
       jComp.setIcon(null);
       jComp.setIcon(new javax.swing.ImageIcon(getClass().getResource(Configs.getImageDirStatic() + "load.gif")));
   }
    
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgFileSearchSave = new javax.swing.ButtonGroup();
        btgRenameOptions = new javax.swing.ButtonGroup();
        btgRenameSubs = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        tabPanel = new javax.swing.JTabbedPane();
        pnlSearchForFile = new javax.swing.JPanel();
        btnSearchFiles = new javax.swing.JButton();
        lblSearchForFile = new javax.swing.JLabel();
        txtSearchStartFolder = new javax.swing.JTextField();
        btnBrowseSearchRoot = new javax.swing.JButton();
        lblFileSearchStatus = new javax.swing.JLabel();
        lblSearchFolder = new javax.swing.JLabel();
        txtFileToSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblFoundFiles = new javax.swing.JLabel();
        txtSearchSaveFile = new javax.swing.JTextField();
        btnSearchSaveBrowse = new javax.swing.JButton();
        btnSearchCancel = new javax.swing.JButton();
        pnlSearchRads = new javax.swing.JPanel();
        radDisplayFileSearch = new javax.swing.JRadioButton();
        radSaveFileSearch = new javax.swing.JRadioButton();
        pnlFileRename = new javax.swing.JPanel();
        txtRenameFolder = new javax.swing.JTextField();
        btnRenameFolderBrowse = new javax.swing.JButton();
        lblRenameFolder = new javax.swing.JLabel();
        btnRename = new javax.swing.JButton();
        lblRenameTemplate = new javax.swing.JLabel();
        txtRenameTemplate = new javax.swing.JTextField();
        lblRenameStatus = new javax.swing.JLabel();
        lblRenameTemplateExplain = new javax.swing.JLabel();
        spinStartAt = new javax.swing.JSpinner();
        lblRenameTemplateExplain1 = new javax.swing.JLabel();
        txtRenameSaveToFolder = new javax.swing.JTextField();
        btnRenameSaveToBrowse = new javax.swing.JButton();
        pnlRenameRads = new javax.swing.JPanel();
        radRenameCopy = new javax.swing.JRadioButton();
        radRename = new javax.swing.JRadioButton();
        lblSubsExplain = new javax.swing.JLabel();
        pnlRenameIncludeSub = new javax.swing.JPanel();
        radRenameIncludeSubs = new javax.swing.JRadioButton();
        radRenameExcludeSubs = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblTitle.setBackground(new java.awt.Color(102, 102, 102));
        lblTitle.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Recursion Demo");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(0, 10, 930, 30);

        lblError.setBackground(new java.awt.Color(255, 204, 204));
        lblError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 51));
        lblError.setText("Error Label");
        lblError.setOpaque(true);
        getContentPane().add(lblError);
        lblError.setBounds(20, 60, 920, 80);

        pnlSearchForFile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearchFiles.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSearchFiles.setText("Search");
        btnSearchFiles.setActionCommand("btnSearchForFile");
        btnSearchFiles.setAutoscrolls(true);
        btnSearchFiles.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSearchFiles.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/images/error.jpg"))); // NOI18N
        btnSearchFiles.setFocusPainted(false);
        btnSearchFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFilesActionPerformed(evt);
            }
        });
        pnlSearchForFile.add(btnSearchFiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 140, 50));
        btnSearchFiles.getAccessibleContext().setAccessibleName("btnSearchForFile");

        lblSearchForFile.setBackground(new java.awt.Color(255, 255, 255));
        lblSearchForFile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSearchForFile.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearchForFile.setText("Search for file:");
        pnlSearchForFile.add(lblSearchForFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 113, 25));

        txtSearchStartFolder.setBackground(new java.awt.Color(245, 245, 245));
        txtSearchStartFolder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearchStartFolder.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtSearchStartFolder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchStartFolderKeyReleased(evt);
            }
        });
        pnlSearchForFile.add(txtSearchStartFolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 590, 25));

        btnBrowseSearchRoot.setText("Browse...");
        btnBrowseSearchRoot.setActionCommand("Browse");
        btnBrowseSearchRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseSearchRootActionPerformed(evt);
            }
        });
        pnlSearchForFile.add(btnBrowseSearchRoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, -1, -1));

        lblFileSearchStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblFileSearchStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFileSearchStatus.setForeground(new java.awt.Color(0, 51, 102));
        lblFileSearchStatus.setText("Search Status");
        lblFileSearchStatus.setOpaque(true);
        pnlSearchForFile.add(lblFileSearchStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 840, 50));

        lblSearchFolder.setBackground(new java.awt.Color(255, 255, 255));
        lblSearchFolder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSearchFolder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearchFolder.setText("Search in folder:");
        pnlSearchForFile.add(lblSearchFolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 113, 25));

        txtFileToSearch.setBackground(new java.awt.Color(245, 245, 245));
        txtFileToSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFileToSearch.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtFileToSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFileToSearchKeyReleased(evt);
            }
        });
        pnlSearchForFile.add(txtFileToSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 430, 25));

        lblFoundFiles.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane2.setViewportView(lblFoundFiles);

        pnlSearchForFile.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 780, 260));

        txtSearchSaveFile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearchSaveFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtSearchSaveFile.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtSearchSaveFile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSaveFileKeyReleased(evt);
            }
        });
        pnlSearchForFile.add(txtSearchSaveFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 470, 25));

        btnSearchSaveBrowse.setText("Browse...");
        btnSearchSaveBrowse.setActionCommand("Browse");
        btnSearchSaveBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSaveBrowseActionPerformed(evt);
            }
        });
        pnlSearchForFile.add(btnSearchSaveBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, -1, -1));

        btnSearchCancel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSearchCancel.setText("Cancel");
        btnSearchCancel.setActionCommand("btnSearchForFile");
        btnSearchCancel.setAutoscrolls(true);
        btnSearchCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCancelActionPerformed(evt);
            }
        });
        pnlSearchForFile.add(btnSearchCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 90, 50));

        pnlSearchRads.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btgFileSearchSave.add(radDisplayFileSearch);
        radDisplayFileSearch.setText("Display Only");
        radDisplayFileSearch.setActionCommand("Display");
        radDisplayFileSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radDisplayFileSearchActionPerformed(evt);
            }
        });
        pnlSearchRads.add(radDisplayFileSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 7, -1, -1));

        btgFileSearchSave.add(radSaveFileSearch);
        radSaveFileSearch.setText("Display & Save");
        radSaveFileSearch.setActionCommand("Save");
        radSaveFileSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radSaveFileSearchActionPerformed(evt);
            }
        });
        pnlSearchRads.add(radSaveFileSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        pnlSearchForFile.add(pnlSearchRads, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 70, 260, 40));

        tabPanel.addTab("Search For File", pnlSearchForFile);

        pnlFileRename.setMaximumSize(new java.awt.Dimension(950, 700));
        pnlFileRename.setMinimumSize(new java.awt.Dimension(950, 700));
        pnlFileRename.setPreferredSize(new java.awt.Dimension(950, 700));
        pnlFileRename.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRenameFolder.setEditable(false);
        txtRenameFolder.setBackground(new java.awt.Color(245, 245, 245));
        txtRenameFolder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRenameFolder.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtRenameFolder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRenameFolderKeyReleased(evt);
            }
        });
        pnlFileRename.add(txtRenameFolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 79, 640, 25));

        btnRenameFolderBrowse.setText("Browse...");
        btnRenameFolderBrowse.setActionCommand("Browse");
        btnRenameFolderBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenameFolderBrowseActionPerformed(evt);
            }
        });
        pnlFileRename.add(btnRenameFolderBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, -1, 25));

        lblRenameFolder.setBackground(new java.awt.Color(255, 255, 255));
        lblRenameFolder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRenameFolder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRenameFolder.setText("Folder with files:");
        pnlFileRename.add(lblRenameFolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 110, 25));

        btnRename.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnRename.setText("Rename Files");
        btnRename.setActionCommand("btnSearchForFile");
        btnRename.setAutoscrolls(true);
        btnRename.setFocusPainted(false);
        btnRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenameActionPerformed(evt);
            }
        });
        pnlFileRename.add(btnRename, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 192, 50));

        lblRenameTemplate.setBackground(new java.awt.Color(255, 255, 255));
        lblRenameTemplate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRenameTemplate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRenameTemplate.setText("Rename template:");
        pnlFileRename.add(lblRenameTemplate, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 149, 110, 25));

        txtRenameTemplate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRenameTemplate.setText("#February##_Conference_###");
        txtRenameTemplate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtRenameTemplate.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtRenameTemplate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRenameTemplateKeyReleased(evt);
            }
        });
        pnlFileRename.add(txtRenameTemplate, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 148, 420, 25));

        lblRenameStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblRenameStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRenameStatus.setForeground(new java.awt.Color(0, 51, 102));
        lblRenameStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRenameStatus.setText("Search Status");
        lblRenameStatus.setOpaque(true);
        pnlFileRename.add(lblRenameStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 858, 50));

        lblRenameTemplateExplain.setText("Use pound sign \"#\" for sequential number");
        pnlFileRename.add(lblRenameTemplateExplain, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 123, 290, 21));

        spinStartAt.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        spinStartAt.setMaximumSize(new java.awt.Dimension(29, 20));
        pnlFileRename.add(spinStartAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 148, 53, 26));

        lblRenameTemplateExplain1.setText("Start At:");
        pnlFileRename.add(lblRenameTemplateExplain1, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 148, 51, 26));

        txtRenameSaveToFolder.setEditable(false);
        txtRenameSaveToFolder.setBackground(new java.awt.Color(245, 245, 245));
        txtRenameSaveToFolder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRenameSaveToFolder.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtRenameSaveToFolder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRenameSaveToFolderKeyReleased(evt);
            }
        });
        pnlFileRename.add(txtRenameSaveToFolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 430, 25));

        btnRenameSaveToBrowse.setText("Browse...");
        btnRenameSaveToBrowse.setActionCommand("Browse");
        btnRenameSaveToBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenameSaveToBrowseActionPerformed(evt);
            }
        });
        pnlFileRename.add(btnRenameSaveToBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, -1, 25));

        btgRenameOptions.add(radRenameCopy);
        radRenameCopy.setText("Copy Renamed Files To Folder");
        radRenameCopy.setActionCommand("Move");
        radRenameCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radRenameCopyActionPerformed(evt);
            }
        });

        btgRenameOptions.add(radRename);
        radRename.setText("Rename Files");
        radRename.setActionCommand("Rename");
        radRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radRenameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRenameRadsLayout = new javax.swing.GroupLayout(pnlRenameRads);
        pnlRenameRads.setLayout(pnlRenameRadsLayout);
        pnlRenameRadsLayout.setHorizontalGroup(
            pnlRenameRadsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRenameRadsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(radRename)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radRenameCopy)
                .addGap(16, 16, 16))
        );
        pnlRenameRadsLayout.setVerticalGroup(
            pnlRenameRadsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRenameRadsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlRenameRadsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radRenameCopy)
                    .addComponent(radRename))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlFileRename.add(pnlRenameRads, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 192, 340, 60));

        lblSubsExplain.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSubsExplain.setForeground(new java.awt.Color(0, 51, 153));
        lblSubsExplain.setText("File number to be renamed");
        pnlFileRename.add(lblSubsExplain, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 450, 30));

        btgRenameSubs.add(radRenameIncludeSubs);
        radRenameIncludeSubs.setText("Include subfolders");
        radRenameIncludeSubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radRenameIncludeSubsActionPerformed(evt);
            }
        });

        btgRenameSubs.add(radRenameExcludeSubs);
        radRenameExcludeSubs.setText("Exclude subfolders");
        radRenameExcludeSubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radRenameExcludeSubsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRenameIncludeSubLayout = new javax.swing.GroupLayout(pnlRenameIncludeSub);
        pnlRenameIncludeSub.setLayout(pnlRenameIncludeSubLayout);
        pnlRenameIncludeSubLayout.setHorizontalGroup(
            pnlRenameIncludeSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRenameIncludeSubLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(radRenameExcludeSubs)
                .addGap(18, 18, 18)
                .addComponent(radRenameIncludeSubs)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRenameIncludeSubLayout.setVerticalGroup(
            pnlRenameIncludeSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRenameIncludeSubLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlRenameIncludeSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radRenameExcludeSubs)
                    .addComponent(radRenameIncludeSubs))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlFileRename.add(pnlRenameIncludeSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        tabPanel.addTab("Batch Rename", pnlFileRename);

        getContentPane().add(tabPanel);
        tabPanel.setBounds(30, 150, 910, 580);
        tabPanel.getAccessibleContext().setAccessibleName("tabSearchForFile");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchSaveBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSaveBrowseActionPerformed
        // TODO add your handling code here:
       File dataDir = AuxFile.getFileDirectoryFileChooser();
        
       if (dataDir==null) // this is needed when user clicks cancel in the file chooser; then dataDir is null - make sure to stop the method otherwise errors.
       {
         searchValidator.validateSaveToFile(needSave); // validate so that we can display errors right away
         return;
       }
        txtSearchSaveFile.setText(dataDir.getAbsolutePath()); // put the directory into the text box so that we can validate it
        searchValidator.validateSaveToFile(needSave);      

      
    }//GEN-LAST:event_btnSearchSaveBrowseActionPerformed

    private void btnBrowseSearchRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseSearchRootActionPerformed
         File dataDir = AuxFile.getFileDirectoryFileChooser();
         if (dataDir==null) // this is needed when user clicks cancel in the file chooser; then dataDir is null - make sure to stop the method otherwise errors.
             return;
         
        txtSearchStartFolder.setText(dataDir.getAbsolutePath());
        AuxValidatorForm.styleNormal(txtSearchStartFolder);
        searchValidator.hideError();
    }//GEN-LAST:event_btnBrowseSearchRootActionPerformed

    private void btnSearchFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFilesActionPerformed
        lblFoundFiles.setText(null);
        if (btnSearchFiles.getIcon() != null) // if there is another processes already searching for the files then do not create another.
            return;
        
        if (!searchValidator.validateSearch(needSave))    // validate the fields. if there are some missing then halt   
            return;
        
        File folder = new File(txtSearchStartFolder.getText());
        String pattern = txtFileToSearch.getText();
        String fileOutput = txtSearchSaveFile.getText();
        String delimiter = Configs.COLUMN_DELIMETER;
        
        finder = new FileFinder(folder, pattern, fileOutput, needSave, delimiter);
        
        new Thread(() -> {
                setLoaderIcon(btnSearchFiles);
                setLoaderIcon(lblFileSearchStatus);  
                btnSearchCancel.setVisible(true);
                searchFiles();
        }).start();
        
    }//GEN-LAST:event_btnSearchFilesActionPerformed

   
   private void searchFiles() {
       
        finder.execute();
        if (!finder.isIsSuccess())
        {
            lblError.setText(finder.getStatusDesc());
            lblError.setVisible(true);
            lblFoundFiles.setText(null);
        }
        else
        {
                if (finder.isCancel())
                {
                    lblFoundFiles.setText(finder.getStatusDesc());
                }
                else
                {
                    if (needSave)
                    {
                        finder.writeFile();
                        finder.openFile();           
                    }
                    
                lblFoundFiles.setText(finder.toString());
            }
        }
        
        btnSearchFiles.setIcon(null);
        btnSearchCancel.setVisible(false);
    }
    
    
    private void txtSearchStartFolderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStartFolderKeyReleased
         AuxValidatorForm.styleNormal((JComponent)evt.getSource());
         searchValidator.hideError();
    }//GEN-LAST:event_txtSearchStartFolderKeyReleased

    private void txtFileToSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFileToSearchKeyReleased
        AuxValidatorForm.styleNormal((JComponent)evt.getSource());
        searchValidator.hideError();
    }//GEN-LAST:event_txtFileToSearchKeyReleased

       
    private void btnSearchCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCancelActionPerformed
        finder.setCancel();
    }//GEN-LAST:event_btnSearchCancelActionPerformed

    private void txtSearchSaveFileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSaveFileKeyReleased
        AuxValidatorForm.styleNormal((JComponent)evt.getSource());
        searchValidator.hideError();
      
    }//GEN-LAST:event_txtSearchSaveFileKeyReleased

    private void txtRenameFolderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRenameFolderKeyReleased
       
    }//GEN-LAST:event_txtRenameFolderKeyReleased

    private void btnRenameFolderBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenameFolderBrowseActionPerformed
        File fileDir = AuxFile.getFileDirectoryFileChooser();
        if (fileDir==null) // this is needed when user clicks cancel in the file chooser; then dataDir is null - make sure to stop the method otherwise errors.
        {
            lblRenameStatus.setIcon(null);
            return;
        }
        txtRenameFolder.setText(fileDir.getAbsolutePath());       
    }//GEN-LAST:event_btnRenameFolderBrowseActionPerformed


    private void btnRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenameActionPerformed
        if (btnRename.getIcon() != null)
            return;
         
        if (btnSearchFiles.getIcon() != null)
             return;
     
        if (!validateRename())
            return;
    }//GEN-LAST:event_btnRenameActionPerformed

 private boolean validateRename()
    {
        ValidatorRename  validator = new ValidatorRename ( btgRenameOptions,  btgRenameSubs,  txtRenameTemplate,  lblError,  lblRenameStatus,  txtRenameSaveToFolder,  txtRenameFolder,  pnlRenameIncludeSub,  pnlRenameRads,  renameCopy) ;
        return validator.validate();       
    }
             
    private void radSaveFileSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radSaveFileSearchActionPerformed
        setSaveResultFlag((JRadioButton)evt.getSource());
        AuxValidatorForm.styleNormal(pnlSearchRads);
        searchValidator.searchFilesButtonEnable(true);
    }//GEN-LAST:event_radSaveFileSearchActionPerformed

    private void radDisplayFileSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radDisplayFileSearchActionPerformed
        setSaveResultFlag((JRadioButton)evt.getSource());
        AuxValidatorForm.styleNormal(pnlSearchRads);
        searchValidator.searchFilesButtonEnable(true);
    }//GEN-LAST:event_radDisplayFileSearchActionPerformed

    private void setSaveResultFlag(JRadioButton radButton)
      {
            if (radButton.isSelected())
            {
                String sAction = radButton.getActionCommand();
                if (sAction.equalsIgnoreCase("Save"))
                {
                  txtSearchSaveFile.setVisible(true);
                  btnSearchSaveBrowse.setVisible(true);
                  needSave = true;
                }
                else
                {
                  txtSearchSaveFile.setVisible(false);
                  txtSearchSaveFile.setText(null);
                  btnSearchSaveBrowse.setVisible(false);
                  needSave = false;
                }
            }
            
        AuxValidatorForm.styleNormal(pnlSearchRads);
        searchValidator.hideError();
      
      }
    
    private void txtRenameTemplateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRenameTemplateKeyReleased
        
    }//GEN-LAST:event_txtRenameTemplateKeyReleased

    private void txtRenameSaveToFolderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRenameSaveToFolderKeyReleased
        
    }//GEN-LAST:event_txtRenameSaveToFolderKeyReleased

    private void btnRenameSaveToBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenameSaveToBrowseActionPerformed
        File fileDir =AuxFile.getFileDirectoryFileChooser();
        if (fileDir==null) // this is needed when user clicks cancel in the file chooser; then dataDir is null - make sure to stop the method otherwise errors.
            return;
        
    }//GEN-LAST:event_btnRenameSaveToBrowseActionPerformed

    private void radRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radRenameActionPerformed
         setRenameFlag((JRadioButton)evt.getSource());
    }//GEN-LAST:event_radRenameActionPerformed

    private void radRenameCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radRenameCopyActionPerformed
         setRenameFlag((JRadioButton)evt.getSource());
    }//GEN-LAST:event_radRenameCopyActionPerformed

    private void setRenameFlag(JRadioButton radButton)
    {
        if (radButton.isSelected())
        {
            String sAction = radButton.getActionCommand();
            if (sAction.equalsIgnoreCase("Move"))
            {
                txtRenameSaveToFolder.setVisible(true);
                btnRenameSaveToBrowse.setVisible(true);
                renameCopy = true;
            }
            else
            {
                txtRenameSaveToFolder.setVisible(false);
                txtRenameSaveToFolder.setText(null);
                btnRenameSaveToBrowse.setVisible(false);
                renameCopy = false;
            }

        }

       AuxValidatorForm.styleNormal(pnlRenameRads);
       searchValidator.hideError();

    }
    
    private void radRenameExcludeSubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radRenameExcludeSubsActionPerformed
       
    }//GEN-LAST:event_radRenameExcludeSubsActionPerformed

    private void radRenameIncludeSubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radRenameIncludeSubsActionPerformed
     
    }//GEN-LAST:event_radRenameIncludeSubsActionPerformed



     private void InitControls()
      {
        txtSearchSaveFile.setVisible(false);
        btnSearchSaveBrowse.setVisible(false);
        btnSearchCancel.setVisible(false);

        //method that set initial visibility of labels (hides error labels and clears labels and text boxes)
        lblError.setVisible(false);
        lblFileSearchStatus.setText("");
        lblFileSearchStatus.setVisible(false);


/*      use this for testing only
        txtFileToSearch.setText("*.java");
        txtSearchStartFolder.setText("src\\");
*/
        txtRenameSaveToFolder.setVisible(false);
        btnRenameSaveToBrowse.setVisible(false);

        lblSubsExplain.setText(null);
        lblSubsExplain.setVisible(false);

        // style all text boxes in the same way. Also, use setTextBoxStyle() to go from error to normal.
        setTextBoxStyle(txtFileToSearch);
        setTextBoxStyle(txtSearchStartFolder);
        setTextBoxStyle(txtSearchSaveFile);
        setTextBoxStyle(txtRenameFolder);
           
    }

   private void setTextBoxStyle(JTextField txt)
     {
          txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
          txt.setBackground(new java.awt.Color(250, 250, 250));
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgFileSearchSave;
    private javax.swing.ButtonGroup btgRenameOptions;
    private javax.swing.ButtonGroup btgRenameSubs;
    private javax.swing.JButton btnBrowseSearchRoot;
    private javax.swing.JButton btnRename;
    private javax.swing.JButton btnRenameFolderBrowse;
    private javax.swing.JButton btnRenameSaveToBrowse;
    private javax.swing.JButton btnSearchCancel;
    private javax.swing.JButton btnSearchFiles;
    private javax.swing.JButton btnSearchSaveBrowse;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFileSearchStatus;
    private javax.swing.JLabel lblFoundFiles;
    private javax.swing.JLabel lblRenameFolder;
    private javax.swing.JLabel lblRenameStatus;
    private javax.swing.JLabel lblRenameTemplate;
    private javax.swing.JLabel lblRenameTemplateExplain;
    private javax.swing.JLabel lblRenameTemplateExplain1;
    private javax.swing.JLabel lblSearchFolder;
    private javax.swing.JLabel lblSearchForFile;
    private javax.swing.JLabel lblSubsExplain;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlFileRename;
    private javax.swing.JPanel pnlRenameIncludeSub;
    private javax.swing.JPanel pnlRenameRads;
    private javax.swing.JPanel pnlSearchForFile;
    private javax.swing.JPanel pnlSearchRads;
    private javax.swing.JRadioButton radDisplayFileSearch;
    private javax.swing.JRadioButton radRename;
    private javax.swing.JRadioButton radRenameCopy;
    private javax.swing.JRadioButton radRenameExcludeSubs;
    private javax.swing.JRadioButton radRenameIncludeSubs;
    private javax.swing.JRadioButton radSaveFileSearch;
    private javax.swing.JSpinner spinStartAt;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTextField txtFileToSearch;
    private javax.swing.JTextField txtRenameFolder;
    private javax.swing.JTextField txtRenameSaveToFolder;
    private javax.swing.JTextField txtRenameTemplate;
    private javax.swing.JTextField txtSearchSaveFile;
    private javax.swing.JTextField txtSearchStartFolder;
    // End of variables declaration//GEN-END:variables
}
