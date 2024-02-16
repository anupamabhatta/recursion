package Program;

import java.awt.Desktop;
 import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;

public class FileFinder {

    private File folderToSearch;
    
    private String fileSearchExpression;
    
    private String fileOutput;
    
    private boolean needSave;
    
    private boolean status;
    
    private String delimiter;
    
    private String statusDesc;
    
    private boolean isSuccess;
    
    private boolean cancel; 
       
    private ArrayList<File> listFiles; 
    

    public FileFinder(File folderToSearch, String fileSearchExpression, String fileOutput, boolean needSave, String delimiter) {
        this.folderToSearch = folderToSearch;
        this.fileSearchExpression = fileSearchExpression;
        this.fileOutput = fileOutput;
        this.needSave = needSave;
        this.delimiter = delimiter;
        this.statusDesc = statusDesc;
        this.isSuccess = isSuccess;
    }
    
    /**
     *  get all the files that match the search expression and then create a string to be displayed on the form.
     */
    public void execute(){  
        this.cancel = false;
        try 
        {
            this.listFiles = new ArrayList<>();
        
            searchForFiles(folderToSearch, fileSearchExpression); 
        } 
        catch (Exception e) 
        {
            isSuccess = false;
            this.statusDesc = "There was a problem. Error: " + e.getMessage();
        }
        
        if (!cancel)
            isSuccess = true;
    }

    /***
     * searchForFiles - searches for files that match recursively
     * @param folderToSearch - folder to search for files
     * @param fileSearchExpression - expression to match the file against
     */
    private void searchForFiles(File folderToSearch, String fileSearchExpression) {
        
        // if dir is not a directory, return
        if (!folderToSearch.isDirectory() || folderToSearch.listFiles()== null)
        {
            statusDesc = "Root folder specified is not correct.";
            isSuccess = false;
            return;
        }
        
        File[] arDirItems = folderToSearch.listFiles();
        
        for (File folderItem : arDirItems)
        {
            if (cancel)          
                return;
            
            if (folderItem.isDirectory()) // if item is a folder, search for files - make recursive call
            {
                 searchForFiles(folderItem, fileSearchExpression);
            }
            else // if item is a file, check if it matches the search pattern. If so, then add to the collection
            {
                boolean matches = fileMatchesPattern(folderItem.getName(), fileSearchExpression);
                if (matches)
                    this.listFiles.add(folderItem);
            }
        }
    }
    
    
    private boolean fileMatchesPattern(String fileName, String pattern)
    {
        String regexPattern = pattern.replace(".","\\.");   // escape dot using backslash to signify the real dot character (
                                                            // not any single character) - also need to escape the backslash to keep compiler happy
                                                            
        regexPattern = regexPattern.replace("?",".?");      // Any one (or zero) character. The question mark indicates zero or one.
                                                            // occurence of the preceding element. For example, colou?r matches both "color" and "colour"
        
        regexPattern = regexPattern.replace("*",".*");      // Any sequence (or zero sequence before). A regular expression followed by an asterisk(*) 
                                                            // matches a sequence of zero or more occurences of the regular expression.  
        
        // Convert to one case to make it case insensitive as regex expressions are case sensitive                                                    
        regexPattern = regexPattern.toLowerCase();
        fileName = fileName.toLowerCase();
        
        return fileName.matches(regexPattern);
                                                            
    }
    
    /***
     * toHTML method creates a string with HTML table with file information
     * @return
     */
    private String toHTML()
    {
        String sRows = "";
        int rowNum = 0;

        for (File file : listFiles)
        {
            
            String fileSize = "";
            String createdTime = "";
            String sPath = "";
            String fileName = "";   
            try 
            {
                BasicFileAttributes fileAttr = Files.getFileAttributeView(file.toPath(), BasicFileAttributeView.class).readAttributes();  
                
                Date date = new Date(fileAttr.creationTime().toMillis());
                createdTime = AuxPackage.AuxFormatter.formatDateTime(date); 
                
                fileName = file.getName();
                sPath = file.getAbsolutePath();
                fileSize = getFileSize(fileAttr);
                
            } 
            catch (Exception e) 
            {
                String sErr = e.getMessage();
            }
            
            String row = stringToHTMLRow(fileName, fileSize, createdTime, sPath);
            row = insertStyle(row, rowNum);
            sRows += row;
            
        }
        
        sRows = "<html><html table border='0' cellspacing= '0' style='border-collapse:collapse'>" 
        + "<tr style='color:#472d59; font: 105% bold Georgia, serif; '><td>File</td>" + "<td>Size</td>" + "<td>Created</td>" + "<td>Location</td></tr>" 
        + sRows + "</html>";
        
        return sRows;
    }
    
    /***
     * writeFile() method writes the entire file with the search results
     */
    public void writeFile()
    {
        String sRow = "";
        
        PrintWriter outputStream = null;

        try
        {
            outputStream = new PrintWriter(new FileOutputStream(fileOutput));
        }
        catch(FileNotFoundException e)
        {
            status = false;
            statusDesc = "Problem accessing output file." + e.getMessage();
        }

        if(outputStream == null)
        {
            status = false;
            statusDesc = "Problem accessing output file. Output stream is null.";
        }
        
        sRow = "File" + Configs.COLUMN_DELIMETER + "Size" + Configs.COLUMN_DELIMETER 
                + "Date Created" + Configs.COLUMN_DELIMETER + "Date Modified" + Configs.COLUMN_DELIMETER 
                + "Date Last Accessed" + Configs.COLUMN_DELIMETER + "Absolute Path";

        outputStream.println(sRow);
        
        
        for(File file: listFiles)
        {
            if(cancel)
               return;
            
            String sFile = "";
            String sSize = "";
            String sDateCreated = "";
            String sDateModified = "";
            String sDateLastAccessed = "";
            String sAbsolutePath = "";
            
            try 
            {
                BasicFileAttributes fileAttr= Files.getFileAttributeView(file.toPath(), BasicFileAttributeView.class).readAttributes();

                sFile= file.getName();
                sSize = getFileSize(fileAttr);
                
                Date dCreationDate= new Date(fileAttr.creationTime().toMillis());
                sDateCreated= AuxPackage.AuxFormatter.formatDateTime(dCreationDate);

                Date dModifiedDate= new Date(fileAttr.lastModifiedTime().toMillis());
                sDateModified= AuxPackage.AuxFormatter.formatDateTime(dModifiedDate);

                Date dLastAccessedDate= new Date(fileAttr.lastAccessTime().toMillis());
                sDateLastAccessed= AuxPackage.AuxFormatter.formatDateTime(dLastAccessedDate);

                sAbsolutePath=file.getAbsolutePath();            
            } 
            catch (Exception e) 
            {
                statusDesc = "Unexpected error occured while getting data for the following file.";
                isSuccess = false;
            }
            
            sRow = rowToCSV(sFile, sSize, sDateCreated, sDateModified, sDateLastAccessed, sAbsolutePath);
            outputStream.println(sRow);           
        }
        outputStream.close();    
    }   
    
    public void openFile()
    {
        File file = new File(fileOutput); 
        try {
            if(cancel)
               return;
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String stringToHTMLRow(String... arFields)
    {
        String row = "";
        
        for (String sField : arFields)
        {
            sField = "<td>" + sField + "</td>";
            row += sField;
        }
            row = "<tr>" + row + "</tr>";
        
        return row;
    }
    
    private String rowToCSV(String... arFields)
    {
        String row = "";
        int iCount = 0;
        
        for (String sField: arFields)
        {
            iCount++;
            sField = "\"" + sField + "\"";
            
            if (iCount == 1)
                sField = sField;
            else
                sField = Configs.COLUMN_DELIMETER + sField;
            
            row += sField;
        }
        
        return row;
    }
    
    private String insertStyle(String row, int rowNum)
    {
        String style = "style='background-color:#FFFFFF;'";
        if (rowNum % 2 == 0)
            style = "style='style='background-color:#f3f3f3;'";
        
        style = "<tr " + style + ">";
        row = row.replace("<tr>", style);
        return row;
    }
    
    
    
    private String getFileSize(BasicFileAttributes fileAttr)
    {   
        String fileSize = "";
        double dSize = fileAttr.size();
        
        double dKilobytes = (dSize/1024);
        double dMegabytes = (dSize/(1024 * 1024));
        double dGigabytes = (dSize/(1024 * 1024 * 1024));
        
        if(dSize < 1024)
            {
                fileSize= String.valueOf(dSize) + " bytes";
            }
        else
            if(dSize >= 1024 && dSize < (1024 * 1024))
            {
               fileSize=String.valueOf(dKilobytes) + " KB";
            }
        else
            if(dSize >= (1024 * 1024) && dSize < (1024 * 1024 * 1024))
            {
               fileSize=String.valueOf(dMegabytes) + " MB";
            }
        else
            if(dSize >= (1024 * 1024 * 1024))
            {
               fileSize= String.valueOf(dGigabytes) + " GB";
            }       
        
        return fileSize;
    }
    

    public String toString()
    {
        if (listFiles.size()== 0)
            return "No files were found.";
        else
            return toHTML();
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel( ) {
        this.cancel = true;
        isSuccess = false;
        statusDesc = "Operation was cancelled by the user.";  
    }

}
