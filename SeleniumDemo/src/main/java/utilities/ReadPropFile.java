package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

    public static Properties ReadPropFileData() throws IOException {
        Properties prop = new Properties();

        FileInputStream ip = new FileInputStream(
                "C:\\Users\\Rutik\\IdeaProjects\\SeleniumDemo\\Config.properties");

        prop.load(ip);
        return prop;
    }
}
