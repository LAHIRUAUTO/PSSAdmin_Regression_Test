package Utilities;

public class FileReaderManager {

    private static FileReaderManager fileReaderManagerInstance = new FileReaderManager();
    private static ConfigFileReader configFileReader;


    private FileReaderManager() {

    }

    public static FileReaderManager getInstance() {
        if (fileReaderManagerInstance == null) {
            fileReaderManagerInstance = new FileReaderManager();
        }
        return fileReaderManagerInstance;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }



}
