package uz.pdp.lesson1task2codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson1task2codingbat.entity.ProgrammingLanguage;
import uz.pdp.lesson1task2codingbat.payload.ApiResponse;
import uz.pdp.lesson1task2codingbat.payload.ProgrammingLanguageDto;
import uz.pdp.lesson1task2codingbat.sevice.ProgrammingLanguageService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguage")
public class ProgrammingLanguageController {

    @Autowired
    ProgrammingLanguageService programmingLanguageService;

    /**
     * Bu method barcha Dasturlash tillarni qaytaradi
     * This method returns all programming language.
     * @return programmingLanguages
     */
    @GetMapping
    public HttpEntity<List<ProgrammingLanguage>> getProgramingLanguages(){
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageService.getProgrammingLanguages();
        return ResponseEntity.ok(programmingLanguages);
    }

    /**
     * Bu method bitta dasturlash tilini id orqali qaytaradi.
     * This method returns one programming language by id.
     * @param id
     * @return programmingLanguage
     */
    @GetMapping("/{id}")
    public HttpEntity<ProgrammingLanguage> getProgrammingLanguageById(
            @PathVariable Integer id){
        ProgrammingLanguage programmingLanguage = programmingLanguageService.getProgrammingLanguageById(id);
        return ResponseEntity.ok(programmingLanguage);
    }

    /**
     * BU method yangi dasturlash tilini qo'shadi.
     * A new programming language is added by this method.
     * @param programmingLanguageDto
     * @return ApiResponse
     */
    @PostMapping
    public HttpEntity<ApiResponse> addProgrammingLanguage(
            @Valid @RequestBody ProgrammingLanguageDto programmingLanguageDto){
        ApiResponse apiResponse = programmingLanguageService.addProgrammingLanguage(programmingLanguageDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    /**
     * Bu method orqali dasturlash tili tahrirlanadi
     * A programming language is edited by this method.
     * @param id
     * @param programmingLanguageDto
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public HttpEntity<ApiResponse> editeProgrammingLanguage(
            @PathVariable Integer id,
            @Valid @RequestBody ProgrammingLanguageDto programmingLanguageDto){
        ApiResponse apiResponse = programmingLanguageService.editeProgrammingLanguage(id, programmingLanguageDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }

    /**
     * Bu method orqali dasturlash tili o'chiriladi
     * A programming language is deleted by this method.
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public HttpEntity<ApiResponse> deleteProgrammingLanguage(
            @PathVariable Integer id){
        ApiResponse apiResponse = programmingLanguageService.deleteProgrammingLanguage(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }

}
