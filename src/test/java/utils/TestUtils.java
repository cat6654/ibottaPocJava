package utils;

import entities.ComAppleCoreSimulatorSimRuntimeIOS124;
import entities.ComAppleCoreSimulatorSimRuntimeIOS131;
import entities.SimctlListOutput;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class TestUtils {
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static TestScreenRecorder screenRecorder;

    public static List<String> getConnectedDevicesUDID() {
        List<String> connectedDevices = new ArrayList<>();
        try {
            String commandToExecute;
            if (OS.contains("win")) {
                commandToExecute = "cmd /c adb devices";
            } else{
                commandToExecute = "adb devices";
            }
            String[] commandResult = CommandExecutor.executeCommand(commandToExecute, true).split("\n");
            System.out.println(Arrays.toString(commandResult));
            for (String device : commandResult) {
                if (device.contains("\tdevice")) {
                    connectedDevices.add(device.substring(0, device.indexOf("\t")));
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        if (connectedDevices.size() == 0) {
            System.out.println("There are no connected devices. \n Check the 'adb devices' command output");
        }
        return connectedDevices;
    }

    public static String getApkPath() {
        System.out.println("Getting latest *.apk");
        String apkPath = "";
        final File apkRootFolder = Paths.get(System.getProperty("user.dir"), TestConstants.Constants.getLocalAppBasePath()).toAbsolutePath().toFile();
        List<File> apkFiles = new ArrayList<>();
        FileManagement.searchForApkFiles(apkRootFolder, apkFiles);

        String apkName = TestConstants.Constants.getLocalAndroidAppKeyword();

        for (File fileEntry : apkFiles) {
            if (fileEntry.getAbsolutePath().contains(apkName)) {
                apkPath = fileEntry.getAbsolutePath();
                System.out.println(String.format("apk is located at: %s", apkPath));
            }
        }

        return apkPath;
    }

    public static void startRecording(String testVideoRecordingsDir, String testName) throws IOException, AWTException {
        File file = new File(testVideoRecordingsDir);
        if (!file.exists()) {
            Files.createDirectories(Paths.get(file.getAbsolutePath()));
        }

        //Create a instance of GraphicsConfiguration to get the Graphics configuration
        //of the Screen. This is needed for ScreenRecorder class.
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        //Create a instance of ScreenRecorder with the required configurations
        screenRecorder = new TestScreenRecorder(gc,
                (Rectangle) null,
                new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, (15 * 60)),
                new Format(MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null,
                file, testName);
        screenRecorder.start();
    }

    public static void stopRecording() throws IOException {
        screenRecorder.stop();
        List<File> createdMovieFiles = screenRecorder.getCreatedMovieFiles();
        for (File movie : createdMovieFiles) {
            System.out.println("New test recording created: " + movie.getAbsolutePath());
        }
    }

    public static List<String> getBootedIphoneSimulatorsUDID(){
        List<String> bootedDevices = new ArrayList<>();
        try {
            String commandToExecute = "xcrun simctl list --json";
            String commandResult = CommandExecutor.executeCommand(commandToExecute, true);
            SimctlListOutput result = JsonConverter.deserializeToCustomClass(commandResult, SimctlListOutput.class);

            List<ComAppleCoreSimulatorSimRuntimeIOS131> bootedIOS131Devices = result.getDevices()
                    .getComAppleCoreSimulatorSimRuntimeIOS131()
                    .stream()
                    .filter(device -> device.getState().equalsIgnoreCase("Booted")).collect(Collectors.toList());
            List<ComAppleCoreSimulatorSimRuntimeIOS124> bootedIOS124Devices = result.getDevices()
                    .getComAppleCoreSimulatorSimRuntimeIOS124()
                    .stream()
                    .filter(device -> device.getState().equalsIgnoreCase("Booted")).collect(Collectors.toList());

            bootedDevices.addAll(
                    bootedIOS131Devices.stream().map(ComAppleCoreSimulatorSimRuntimeIOS131::getUdid)
                    .collect(Collectors.toList())
            );
            bootedDevices.addAll(
                    bootedIOS124Devices.stream().map(ComAppleCoreSimulatorSimRuntimeIOS124::getUdid)
                            .collect(Collectors.toList())
            );

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        if (bootedDevices.size() == 0) {
            System.out.println("There are no booted ios devices. \n Check the 'xcrun simctl list' command output");
        }
        return bootedDevices;
    }
}
