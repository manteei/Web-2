package resposeFormation;

import validate.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseFormator {
    Validator validate = new Validator();
    public String[] formation(String x, String y, String r){
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        long startTime = System.nanoTime();
        String message = validate.checkResult(x, y, r);
        long timeResponse = (System.nanoTime() - startTime);
        return (new String[]{x, y, r,  message, timeResponse + " ns", currentTime});
    }
}
