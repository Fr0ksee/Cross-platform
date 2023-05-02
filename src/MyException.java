import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyException extends Exception {
    private static final String LOG_FILE_NAME = "log.txt";
    
    private String errorMessage;
    
    public MyException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public void logError() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        
        try (FileWriter fileWriter = new FileWriter(LOG_FILE_NAME, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(formattedDateTime + " - " + errorMessage);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}