package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutor {
    public static String executeCommand(String command, boolean readOutput) throws IOException, InterruptedException {
        try {
            Process p = Runtime.getRuntime().exec(command);
            if (readOutput) {
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                return sb.toString();
            } else {
                new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
                int returnCode = p.waitFor();
                System.out.println(command);
                System.out.println("Return code = " + returnCode);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "Success!";
    }
}
