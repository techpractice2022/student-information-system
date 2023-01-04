package org.NSoft.studentinformationsystem.shared.utility;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.NSoft.studentinformationsystem.domain.PersonalImageEntity;
import org.NSoft.studentinformationsystem.repository.PersonalImageRepository;
import org.NSoft.studentinformationsystem.repository.PersonalRepository;
import org.springframework.web.multipart.MultipartFile;


public class ImageUtils {

    private  PersonalImageRepository repository;



    public static byte[] compressImage(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }



    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }


    public String uploadImage(MultipartFile file) throws IOException {

        PersonalImageEntity imageData = repository.save(PersonalImageEntity.builder()
            .imageName(file.getOriginalFilename())
            .imageType(file.getContentType())
            .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String imageName){
        Optional<PersonalImageEntity> dbImageData = repository.findByImageName(imageName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }



}
