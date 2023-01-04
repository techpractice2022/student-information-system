package org.NSoft.studentinformationsystem.service;



import java.io.IOException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.NSoft.studentinformationsystem.domain.PersonalEntity;
import org.NSoft.studentinformationsystem.domain.PersonalImageEntity;
import org.NSoft.studentinformationsystem.repository.PersonalRepository;
import org.NSoft.studentinformationsystem.service.mapper.PersonalMapper;
import org.NSoft.studentinformationsystem.shared.utility.ImageUtils;
import org.NSoft.studentinformationsystem.web.exception.ResourceNotFoundException;
import org.NSoft.studentinformationsystem.web.request.PersonalRequestDetailsDto;
import org.NSoft.studentinformationsystem.web.response.PersonalResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonalService {


    private String message;
    private final PersonalMapper personalMapper;

    /*private final ImageProofUtility imageProofUtility;*/

    private final ImageUtils imageUtils;


    private final PersonalRepository personalRepository;



/*    private String tempDirectory;*/

    /*@Value("${C:\\KAT FILES\\Desktop\\LOCAL\\SIS-IMAGE_DIR}")
    public void setTempDirectory(String tempDirectory) {
        this.tempDirectory = tempDirectory;
    }*/


   /* @PostConstruct
    private void setupTempDirectory() {
        try {
            Path path = Paths.get(tempDirectory);

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (InvalidPathException | IOException e) {
            log.warn("An error occurred while creating temporary directory {}. {}", tempDirectory, e.getMessage());
        }
    }*/


  /*  public PersonalResponseDto addPersonalInformation(PersonalRequestDetailsDto personalRequestDetailsDto) {

        PersonalEntity personalEntity = personalMapper.toEntity(personalRequestDetailsDto);

        PersonalEntity saveInfo = personalRepository.save(personalEntity);

        return personalMapper.toDto(saveInfo);

    }*/

    public PersonalResponseDto addPersonalInformation(PersonalRequestDetailsDto personalRequestDetailsDto) {

        PersonalEntity personalEntity = new PersonalEntity();
        PersonalEntity saveInfo = personalRepository.save(personalEntity);

        personalEntity.setLastname(personalRequestDetailsDto.getLastname());
        personalEntity.setFirstname(personalRequestDetailsDto.getFirstname());
        personalEntity.setMiddleinitial(personalEntity.getMiddleinitial());
        personalEntity.setAge(personalRequestDetailsDto.getAge());

     /* Optional<PersonalRequestDetailsDto> request = imageUtils.uploadImage(file)*/;

    }

    public List<PersonalEntity> findAllPersonalInformation() {
        List<PersonalEntity> paramPersonal = personalRepository.findAll(); //(Note:.findAll() is auto generated from JPA to fetch all data in DB)

        if (paramPersonal.isEmpty() || paramPersonal == null) {
            throw new ResourceNotFoundException("Data not found.");
        }
        return paramPersonal;
    }


    public PersonalResponseDto findByLastname(String lastname) {
        validateRequest(lastname);

        PersonalResponseDto response = new PersonalResponseDto();
        response.setLastname(lastname);

        Optional<PersonalEntity> existingPersonalInformation = personalRepository.findByLastname(
            lastname);
        if (existingPersonalInformation.isPresent()) {
            response.setFirstname(existingPersonalInformation.get().getFirstname());
            response.setMiddleinitial(existingPersonalInformation.get().getMiddleinitial());
            response.setAge(existingPersonalInformation.get().getAge());
        } else {
            throw new ResourceNotFoundException("Data not found.");
        }
        return response;
    }


    public PersonalResponseDto findById(Long id) {
        Optional<PersonalEntity> entity = personalRepository.findById(id); //(Note:.findById() is auto generated from JPA to fetch data by Id in DB)

        if (!entity.isPresent()) {
            message = String.format("No data found with id: '%s'", id);
            throw new ResourceNotFoundException(message);
        }

        return personalMapper.toDto(entity.get());
    }

    private void validateRequest(String lastname) {
        if (StringUtils.isEmpty(lastname)) {
            throw new ResourceNotFoundException("Lastname must not be null or empty");
        }


        private void setImageRequest(PersonalRequestDetailsDto request){
            try {
                log.info("Image added succesfully {}", re());

        }
    }


    /*private void validateRequestImage(PersonalRequestDetailsDto personalRequestDetailsDto)
        throws IOException {
        //File validation
        if (personalRequestDetailsDto.getImage() != null && !personalRequestDetailsDto.getImage().isEmpty()) {
            File imageProofFile = null;

            try {
                String filePath = ImageProofUtility.saveFile(tempDirectory, personalRequestDetailsDto.getImage());
                imageProofFile = new File(filePath);
                imageProofUtility.validateFile(imageProofFile);
            } catch (FileSystemException e) {
                throw new RuntimeException(String.format("Unable to process input image proof file '%s'", personalRequestDetailsDto.getImage().getOriginalFilename()));
            } finally {
                if (imageProofFile != null)
                    Files.delete(imageProofFile.toPath());
            }
        }
    }*/

    //This is method is not required
      /*  public PersonalResponseDto findById(Long id) {
            Optional<PersonalEntity> entity = personalRepository.findById(id);

            validateId(id);

            PersonalResponseDto response = new PersonalResponseDto();
            response.setId(id);

            Optional<PersonalEntity> existingPersonalInformation = personalRepository.findById(id);
            if (existingPersonalInformation.isPresent()) {
                response.setFirstname(existingPersonalInformation.get().getFirstname());
                response.setMiddleinitial(existingPersonalInformation.get().getMiddleinitial());
                response.setAge(existingPersonalInformation.get().getAge());
                response.setImage(existingPersonalInformation.get().getImage());
            }
            return response;
        }*/

    //This is method is not required
   /* private void validateId(Long id){
        if(id == null){
            throw new ResourceNotFoundException("Id must not be null or empty");
        }
    }
*/

}


