package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailContentCheckerOGK implements ContentCheckerOGK{

    public List<String> checkForContent(String line) {

        String emailRegex = "[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(line);

        List<String> results = new ArrayList<>();
        while (matcher.find()) {
            results.add(matcher.group());
        }
        return results;
    }
}
