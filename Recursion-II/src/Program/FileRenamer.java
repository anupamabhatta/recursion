package Program;

/**
 * Name: Anupama Bhatta
 * Date: 04/17/2018
 * Description: Java application that allows searching for files and rename files in batches.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import org.apache.commons.io.FilenameUtils;

public class FileRenamer {

    private File dir;
    private String template;
    private String copyFolder;
    private boolean renameCopy;
    private boolean isSuccess;
    private boolean excludeSubs;
    private String errorStatus;
    private String successStatus;   
    private int startCounter;
    
    private int successFileCount;
    private int failedFileCount;
    
    private FileFinder fileFinder;   
    private ArrayList<RenameTemplate> arTemplate = new ArrayList<RenameTemplate>();
    private ArrayList<File> listFiles = new ArrayList<>();

    public FileRenamer(File dir, String template, int startCounter, String copyFolder, boolean renameCopy, FileFinder finder, boolean excludeSubs)
    {
        this.dir = dir;
        this.template = template;
        this.startCounter = startCounter;
        this.copyFolder = copyFolder;
        this.renameCopy = renameCopy;
        errorStatus = "";
        successStatus = ""; 
        
        try 
        {
            getTemplateArray();
        }
        catch(Exception e)
        {
            errorStatus = "Error happened in getTemplateArray() method in FileRenamer class";
            isSuccess = false;
            return;
        }
        
        listFiles = finder.getListFiles();
        
        if (excludeSubs)
            renameFiles(finder.getInnerFile());
        else
            renameFiles(finder.getListFiles());
 
    }
    
    private void renameFiles(ArrayList<File> listFiles)
    {
        int iCount = startCounter;
        for (File file : listFiles)
        {
            renameSingleFile( file, iCount);
            iCount ++;
        }
        
        if (failedFileCount > 0)
            errorStatus = failedFileCount + " files were not renamed due to unexpected error.";
        else
            successStatus = successFileCount + " files were renamed successfully.";
    }

    private String createFileName(int iCount)
    {
        String newName = "";
        for (RenameTemplate temp : arTemplate)
        {
            String sPart = temp.getChars();
            int iCharCount = temp.getCounterLength();
            String sCounter = "";
            int currentLength = String. valueOf(iCount).length();

            if (iCharCount > currentLength)
            {
                for (int i=0; i<iCharCount - currentLength; i++)
                    sCounter += "0";
            }
            sCounter += iCount;

            newName += sPart + sCounter;
        }

        return newName;
    }

    private void getTemplateArray()
    {
        String modifiedTemplate = template;

        for (int n=template.length(); n>=1; n--)
        {
            String replaceString = "";
            for (int m=n; m>0; m--)
                replaceString += "#";

            modifiedTemplate = modifiedTemplate.replaceAll(replaceString, "#");
        }

        String[] arWords = modifiedTemplate.split("#");
        arTemplate = new ArrayList<>();

        for (int i=0; i<arWords.length; i++)
        {
            int iStart = 0;
            int iEnd = 0;
            int charCount = 0;

            if (i==arWords.length-1) // last character
                iEnd = template.length(); // end of word
            else
                iEnd = template.indexOf(arWords[i+1]); // beginning of next word

            iStart = template.indexOf(arWords[i]) + arWords[i].length();
            charCount = iEnd - iStart;

            arTemplate.add(new RenameTemplate(arWords[i], charCount));
        } 
    }


    private void renameSingleFile(File file, int iCount)
    {
        String newName = createFileName(iCount);
        
        String ext = FilenameUtils.getExtension(file.getAbsolutePath());
        newName += "." + ext;
        
        File newFile = null;
        
        if (renameCopy)
            newFile = new File(copyFolder + "/" + newName);
        else
            newFile = new File(file.getParentFile().getAbsolutePath() + "/" + newName);
        
        try 
        {
            if (renameCopy)
                Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            else
                file.renameTo(newFile);
                
            successFileCount++;   
        } 
        catch (IOException ex) 
        {
            System.out.println("Error happened when copying " + newName + "to " + copyFolder);
            failedFileCount++;
        }
    }
    
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public FileFinder getFileFinder() {
        return fileFinder;
    }

    public void setFileFinder(FileFinder fileFinder) {
        this.fileFinder = fileFinder;
    }

    public ArrayList<RenameTemplate> getArTemplate() {
        return arTemplate;
    }

    public void setArTemplate(ArrayList<RenameTemplate> arTemplate) {
        this.arTemplate = arTemplate;
    }

    public String getErrorStatus() {
        return errorStatus;
    }

}
