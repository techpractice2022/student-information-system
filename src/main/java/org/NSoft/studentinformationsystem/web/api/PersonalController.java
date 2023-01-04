package org.NSoft.studentinformationsystem.web.api;



import java.io.IOException;
import java.util.List;
import javax.print.DocFlavor.BYTE_ARRAY;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.NSoft.studentinformationsystem.domain.PersonalEntity;
import org.NSoft.studentinformationsystem.service.PersonalService;
import org.NSoft.studentinformationsystem.web.request.PersonalRequestDetailsDto;
import org.NSoft.studentinformationsystem.web.response.PersonalResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequestMapping(value = "v1/personal", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
@RestController
public class PersonalController {

     private final PersonalService personalService;

    public static final String REQUEST_KEY_PERSONAL_DETAILS = "personalRequestDetails";

    public static final String REQUEST_KEY_PERSONAL_IMAGE = "personalRequestImage";

     // WE PERFORM CRUD IN HERE //


    //CREATE: We used POST METHOD here to add data's to our DB//
    /*@PostMapping("/add")
    public ResponseEntity <PersonalResponseDto> addPersonalInfo (@RequestBody final PersonalRequestDetailsDto personalRequestDetailsDto){
        PersonalResponseDto dto = personalService.addPersonalInformation(personalRequestDetailsDto);
        return ResponseEntity.ok(dto);
    }*/


    //This is a sample postmapping method getting data + image. PS. Not working for reference only
    @PostMapping("/add")
    public ResponseEntity <PersonalResponseDto> addPersonalInfo(@RequestPart(value = REQUEST_KEY_PERSONAL_DETAILS) @Valid PersonalRequestDetailsDto personalRequestDetails,
        @RequestPart(value = REQUEST_KEY_PERSONAL_IMAGE, required = false) MultipartFile personalRequestImage) throws IOException {

         PersonalRequestDetailsDto request = new PersonalRequestDetailsDto();
         request.setLastname(personalRequestDetails.getLastname());
         request.setFirstname(personalRequestDetails.getFirstname());
         request.setMiddleinitial(personalRequestDetails.getMiddleinitial());
         request.setAge(personalRequestDetails.getAge());
         request.setImage(personalRequestImage);

         PersonalResponseDto responseDto = personalService.addPersonalInformation(request);
         return ResponseEntity.ok(responseDto);
    }


    // READ: We used GET METHOD here to get all the Personal Information from DB //
    // http://localhost:8080/v1/personal/list
    @GetMapping("/list")
    public ResponseEntity<List<PersonalEntity>> getAllPersonalInfo(){
        return ResponseEntity.ok(personalService.findAllPersonalInformation());
    }

    // READ: We used GET METHOD here to get by lastname the Personal Information from DB //
    // http://localhost:8080/v1/personal/{lastname}
    @GetMapping(path = "lastname/{lastname}")
    public ResponseEntity<PersonalResponseDto> getByLastname(@PathVariable final String lastname){
        log.info("Lastname {} : ", lastname);
        return ResponseEntity.ok(personalService.findByLastname(lastname));
    }



    // READ: We used GET METHOD here to get by ID the Personal Information from DB //
    // http://localhost:8080/v1/personal/{id}
    @GetMapping(path = "id/{id}")
    public ResponseEntity<PersonalResponseDto> getById(@PathVariable final Long id){
        return ResponseEntity.ok(personalService.findById(id));
    }








}


