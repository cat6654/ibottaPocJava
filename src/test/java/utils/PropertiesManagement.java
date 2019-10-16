package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManagement {
    private static PropertiesManagement INSTANCE = null;
    private Properties props = null;
    private PropertiesManagement(){
    }

    public synchronized Properties loadProps(String propsFileName) {
        FileInputStream fis = null;
        try {
            File propsFile = new File(propsFileName);
            props = new Properties();
            fis = new FileInputStream(propsFile);
            props.load(fis);
        } catch (IOException e) {
            try {
                props.load(PropertiesManagement.class.getClassLoader().getResourceAsStream(propsFileName));
            } catch (IOException e1) {
                /* do nothing */
            }
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                /* do nothing */
            }
        }
        return props;
    }
    public static PropertiesManagement getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PropertiesManagement();
        }
        return INSTANCE;
    }


    public void save(String propsFileName) throws IOException {
        props.store(new FileOutputStream(propsFileName), null);
    }
}
