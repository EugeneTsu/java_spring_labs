package com.example.lab456.init;

import com.example.lab456.model.Owner;
import com.example.lab456.model.Specialist;
import com.example.lab456.repository.OwnerRepository;
import com.example.lab456.repository.SpecialistRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private SpecialistRepository specialistRepository;

    @PostConstruct
    public void init() {
        if (ownerRepository.count() == 0) {
            ownerRepository.save(new Owner() {{
                setFullName("Евгения Майорова");
                setPhone("+79991234567");
                setEmail("eugene@example.com");
            }});
            ownerRepository.save(new Owner() {{
                setFullName("Иван Петров");
                setPhone("+79997654321");
                setEmail("ivan@example.com");
            }});
        }

        if (specialistRepository.count() == 0) {
            specialistRepository.save(new Specialist() {{
                setFullName("Др. Анина");
                setSpecialty("Хирург");
                setPhone("+79991112233");
            }});
            specialistRepository.save(new Specialist() {{
                setFullName("Др. Борисов");
                setSpecialty("Терапевт");
                setPhone("+79994445566");
            }});
        }
    }
}