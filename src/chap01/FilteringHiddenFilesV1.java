package chap01;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class FilteringHiddenFilesV1 {
    public static void main(String[] args) {
        File[] hiddenFiles = new File("C:\\Program Files").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        System.out.println("hiddenFiles = " + Arrays.stream(hiddenFiles).count());
    }
}
