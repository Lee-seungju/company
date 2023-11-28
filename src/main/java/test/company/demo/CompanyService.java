package test.company.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyDto findData(String id) {
        if (validation(id)) return null;
        Company company = companyRepository.findAll().get(0);
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCar(company.getCar());
        companyDto.setDistance(company.getDistance());
        companyDto.setTime(company.getTime());
        return companyDto;
    }

    private boolean validation(String id) {
        if (id == null || !id.equals("abcde")) {
            return true;
        }
        return false;
    }

    @Transactional
    public Company make(String id) {
        if (validation(id)) return null;
        Company company = new Company();
        company.setCar(1L);
        company.setDistance(2L);
        company.setTime(3L);
        Company save = companyRepository.save(company);
        return save;
    }
}
