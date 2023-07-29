package chap01;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class FilteringHiddenFilesV2 {
    public static void main(String[] args) {
        File[] hiddenFiles = new File("C:\\Program Files").listFiles(File::isHidden);
        System.out.println("hiddenFiles = " + Arrays.stream(hiddenFiles).count());
    }
}
