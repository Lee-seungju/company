package test.company.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("cal-account")
    public CompanyDto calAccount(String id) {
        System.out.println("id = " + id);
        CompanyDto data = companyService.findData(id);
        return data;
    }

    @PostMapping("cal-account")
    public Company make(String id) {
        System.out.println("id = " + id);
        Company make = companyService.make(id);
        return make;
    }
}
