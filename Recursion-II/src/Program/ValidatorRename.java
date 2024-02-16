
package Program;

/**
 * Name: Anupama Bhatta
 * Date: 04/17/2018
 * Description: Java application that allows searching for files and rename files in batches.
 */

import AuxPackage.AuxMethods;
import AuxPackage.AuxValidatorForm;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ValidatorRename {  
    private ButtonGroup btgRenameOptions;
    private ButtonGroup btgRenameSubs;
    private JTextField txtRenameTemplate;        
    private JLabel lblError;
    private JLabel lblRenameStatus;
    private JTextField txtRenameSaveToFolder;
    private JTextField txtRenameFolder;
    private JPanel pnlRenameIncludeSub;
    private JPanel pnlRenameRads;
    private boolean renameCopy;

    public ValidatorRename(ButtonGroup btgRenameOptions, ButtonGroup btgRenameSubs, JTextField txtRenameTemplate, JLabel lblError, JLabel lblRenameStatus, JTextField txtRenameSaveToFolder, JTextField txtRenameFolder, JPanel pnlRenameIncludeSub, JPanel pnlRenameRads, boolean renameCopy) {
        this.btgRenameOptions = btgRenameOptions;
        this.btgRenameSubs = btgRenameSubs;
        this.txtRenameTemplate = txtRenameTemplate;
        this.lblError = lblError;
        this.lblRenameStatus = lblRenameStatus;
        this.txtRenameSaveToFolder = txtRenameSaveToFolder;
        this.txtRenameFolder = txtRenameFolder;
        this.pnlRenameIncludeSub = pnlRenameIncludeSub;
        this.pnlRenameRads = pnlRenameRads;
        this.renameCopy = renameCopy;  
    }
       
    public boolean validate()
    {
        String sError = "";

            
        if (!AuxValidatorForm.folderExistsAndNotEmpty(txtRenameFolder,lblError, "Folder with the Files to Rename"))
            return false;
                
        
        if (AuxValidatorForm.isEmpty(txtRenameTemplate, lblError,"'Rename Template field is required.'"))
            return false;
    
        if (btgRenameOptions.getSelection()==null) //!radRename.isSelected() && !radRenameCopy.isSelected()
        {
           sError += "Please select if you would like to just rename files or rename & copy them to a folder <br/>";
           lblError.setText(sError);
           AuxValidatorForm.styleError(lblError);
           AuxValidatorForm.styleError(pnlRenameRads);
           return false;
        }
        
        if (renameCopy==true)  // validate "Copy To folder only if user selected the option to copy
        {
            if (!AuxValidatorForm.folderExistsAndNotEmpty(txtRenameSaveToFolder,lblError, "Copy To Folder"))
                 return false;      
        }
         
        
        if (btgRenameSubs.getSelection() == null) //!radRenameExcludeSubs.isSelected() && !radRenameIncludeSubs.isSelected()
        {
           sError += "Please select if you would like to include files in the subfolders.<br/>";
           lblError.setText(sError);
            AuxValidatorForm.styleError(lblError);
            AuxValidatorForm.styleError(pnlRenameIncludeSub);
           return false;
        }
        
        
       if (!sError.isEmpty())
       {
            sError = AuxMethods.wrapHTML(sError);
            lblError.setText(sError);
            lblError.setVisible(true);
            clearRenameStatus();
            return false;
       }
       else
       {
            lblError.setText(null);
            lblError.setVisible(false);
            lblError.setVisible(false);
            return true;
       }  
    }
             
   private void clearRenameStatus()
    {
        lblRenameStatus.setText(null);
    }
      
   
}
