
package Program;

/**
 * Name: Anupama Bhatta
 * Date: 04/17/2018
 * Description: Java application that allows searching for files and rename files in batches.
 */

import AuxPackage.AuxMethods;
import AuxPackage.AuxValidatorForm;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ValidatorSearch {
    
    JTextField txtSearchStartFolder;
    JTextField txtFileToSearch;
    JTextField txtSearchSaveFile;
    
    JLabel lblError;
    JLabel lblFoundFiles;

    JPanel pnlSearchRads;
    
    ButtonGroup btgFileSearchSave;
    JButton btnSearchFiles;

    public  ValidatorSearch( JTextField txtSearchStartFolder, JTextField txtFileToSearch, JTextField txtSearchSaveFile,JLabel lblError, JLabel lblFoundFiles, JPanel pnlSearchRads, ButtonGroup btgFileSearchSave, JButton btnSearchFiles)       
    {
       this.txtSearchStartFolder =txtSearchStartFolder;
       this.txtFileToSearch = txtFileToSearch;
       this.txtSearchSaveFile = txtSearchSaveFile;
       
       this.lblError = lblError;
       this.lblFoundFiles = lblFoundFiles;
       
       this.pnlSearchRads = pnlSearchRads;
       this.btgFileSearchSave = btgFileSearchSave;
       this.btnSearchFiles = btnSearchFiles;
    }    
    
    
    public boolean validateSearch(boolean needSave)
    {
       hideError();
       String sError = "";
     
       searchFilesButtonEnable(false); // assume validation failed
          
       
       if (btgFileSearchSave.getSelection()== null) //!radDisplayFileSearch.isSelected() && !radSaveFileSearch.isSelected()
       {
          sError = "Please make selection wether you would like to display the results or save them as well. Select of the radio buttons.";
          lblError.setVisible(true);
          lblError.setText(sError);
          AuxValidatorForm.styleError(lblError);
          AuxValidatorForm.styleError(pnlSearchRads);
          return false;
       } 
       else{
            if (!validateSaveToFile(needSave))
                return false;
       }
       
       if (!AuxValidatorForm.folderExistsAndNotEmpty(txtSearchStartFolder,lblError, "Search Folder"))
           return false;
             

    if (AuxValidatorForm.isEmpty(txtFileToSearch, lblError, "You must specify what file to search for. Please enter value in 'Search for file' filed."))
    {
        return false;
    }
      
    searchFilesButtonEnable(true);
    return true;
     
    }
    
    public void hideError()
    {
        searchFilesButtonEnable(true);
        lblError.setVisible(false);
        lblFoundFiles.setText(null);
        
    }
    
     public void searchFilesButtonEnable(boolean enable){
        if(enable){
             btnSearchFiles.setEnabled(true);
             btnSearchFiles.setIcon(null);
        } else {
             btnSearchFiles.setEnabled(false); 
             setButtonIcon(btnSearchFiles, "error.jpg");
        }
    }
     
    public boolean validateSaveToFile(boolean needSave)
    {
       String sError = "";
       
       if (needSave)
       {
           lblError.setVisible(false);
           AuxValidatorForm.styleNormal(txtSearchSaveFile); 
             
           if (txtSearchSaveFile.getText().contains(".csv"))
           {
               File file = new File(txtSearchSaveFile.getText());
               try {
                   file.createNewFile(); //attempt to create file
                   return true; // if successfull then return true
               }
               catch(Exception ex)      
               {
                   sError = "Specified output file could not be created. Please make sure to include existing folder and a valid file name.";
                   AuxValidatorForm.styleError(lblError);
                   lblError.setText(sError);
                   return false;
               }
           }
           else 
           {
                if (!AuxValidatorForm.folderExistsAndNotEmpty(txtSearchSaveFile,lblError, "Folder to Save to"))
                     return false;      
                else
                {
                    txtSearchSaveFile.setText(txtSearchSaveFile.getText() +"\\" + Configs.DEFAULT_SEARCH_SAVE_FILE);
                    if (!txtSearchSaveFile.getText().contains(".csv"))
                    {
                        sError +="The output file does not have a name. Please specify name in the following format: \"folder\\filename.csv\"";
                        sError = AuxMethods.wrapHTML(sError);
                        AuxValidatorForm.styleError(lblError);
                        AuxValidatorForm.styleError(txtSearchSaveFile); 
                        lblError.setText(sError);

                        return false;
                    } 

                } 
           }
       }
       
        hideError();
        return true;
   
        
    }
      
   private void setButtonIcon(JButton jComp, String sFileName)
   {
       jComp.setIcon(null);
       jComp.setIcon(new javax.swing.ImageIcon(getClass().getResource(Configs.getImageDirStatic() + sFileName)));
   }
}
