package org.NSoft.studentinformationsystem.web.api;



import java.util.List;
import lombok.RequiredArgsConstructor;
import org.NSoft.studentinformationsystem.domain.PersonalEntity;
import org.NSoft.studentinformationsystem.domain.SchoolEntity;
import org.NSoft.studentinformationsystem.service.SchoolService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping (value = "v1/school", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
@RestController
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/list")
    public ResponseEntity<List<SchoolEntity>> getAllInfo(){
        return ResponseEntity.ok(schoolService.findAllPersonalInformation());
    }

}


