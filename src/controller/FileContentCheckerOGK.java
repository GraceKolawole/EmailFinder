package controller;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileContentCheckerOGK {
    private ContentCheckerOGK contentCheckerOGK;
    public FileContentCheckerOGK(ContentCheckerOGK contentCheckerOGK) {
        this.contentCheckerOGK = contentCheckerOGK;
    }
    public String fileWithEmailOGK(){
        String documentPath = "Documents";
        File dir = new File(documentPath);
        File[] directoryListing = dir.listFiles();
        StringBuilder stringBuilder = new StringBuilder();
        if (directoryListing != null) {
            System.out.println("Start searching for content in folder " + documentPath);
            for (File child : directoryListing) {
                if(!child.isDirectory()){
                    try (BufferedReader br = new BufferedReader(new FileReader(child))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            List<String> emails = this.contentCheckerOGK.checkForContent(line);
                            for(String email: emails){
                                stringBuilder.append(child.getName())
                                        .append(" ===> ")
                                        .append(email)
                                        .append("\n");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Finished searching for content in folder " + documentPath);
        }
        return stringBuilder.toString();
    }
}
