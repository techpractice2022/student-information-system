/*
package org.NSoft.studentinformationsystem.shared.utility;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.NSoft.studentinformationsystem.web.exception.InvalidRequestException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Slf4j
@RequiredArgsConstructor
public class ImageProofUtility {



    public static final String ERROR_MAX_FILE_SIZE = "File size (%s) exceeds maximum allowed size: 10MB";




    public void validateFile(File file) throws InvalidRequestException {

        if (!isPng(file) && !isJpeg(file) && !isJpg(file)) {
            throw new InvalidRequestException("Invalid file format");
        }

        String fileSize = getFileSize(file);
        String errorMessage = String.format(ERROR_MAX_FILE_SIZE, fileSize);
        if (fileSize.contains("MB")) {
            if (Integer.parseInt(fileSize.split(" ")[0]) > 10) {
                throw new InvalidRequestException(errorMessage);
            }
        } else if (fileSize.contains("GB")) {
            throw new InvalidRequestException(errorMessage);
        }
    }

    public static String saveFile(String inputPath, MultipartFile file) throws FileSystemException {
        try {
            Path path = Paths.get(inputPath + file.getOriginalFilename());
            Files.write(path, file.getBytes());
            return path.toString();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new FileSystemException("Error saving file to temporary location.");
        }
    }

    public static boolean isPng(File file) {
        return FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("png") ? true : false;
    }

    public static boolean isJpg(File file) {
        return FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("jpg") ? true : false;
    }

    public static boolean isJpeg(File file) {
        return FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("jpeg") ? true : false;
    }

    public static String getFileSize(File file) {
        long size = FileUtils.sizeOf(file);
        return FileUtils.byteCountToDisplaySize(size);
    }

}

*/
