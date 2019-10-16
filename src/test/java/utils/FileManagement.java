package utils;

import java.io.File;
import java.util.List;

public class FileManagement {
    public static void searchForApkFiles(File root, List<File> apkOnly) {
        if(root == null || apkOnly == null) return;
        if(root.isDirectory()) {
            for(File file : root.listFiles()) {
                searchForApkFiles(file, apkOnly);
            }
        } else if(root.isFile() && root.getName().endsWith(".apk")) {
            apkOnly.add(root);
        }
    }
}
