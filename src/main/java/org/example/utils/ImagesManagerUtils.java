package org.example.utils;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ImagesManagerUtils {

    /**
     * Get a string formatted with the names of all images between quotes
     * and delimited by spaces, this way 'Windows file manager' can select various files
     *
     * @param imagesSet, an array of File containing the images to be select
     * @return a formatted String to select all the images if typed in the Windows file manager explorer
     */
    public static String getImagesStringForSelecting(File[] imagesSet) {
        return Arrays.stream(imagesSet)
                .map(File::getName)
                .map(i->"\"" + i + "\"")
                .collect(Collectors.joining(" "));

    }

}
