package Program;

/**
 * Name: Anupama Bhatta
 * Date: 04/17/2018
 * Description: Java application that allows searching for files and rename files in batches.
 */

public class Configs {
   private  String imageDir = "/images/";
   public static final String DEFAULT_SEARCH_SAVE_FILE = "Search_Results.csv";
   public static final String COLUMN_DELIMETER = ",";
          
    public Configs()
    {
         
               
    }
    
    public String getImageURL() {
        return imageDir;
    }
    
    public String getImageDir() {
        return imageDir;
    }

    public static String getImageDirStatic() {
        Configs _config = new Configs();
        return _config.imageDir;
    }
}
