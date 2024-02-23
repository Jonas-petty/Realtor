package br.com.realtor.realtorApp.entity.residence;

import br.com.realtor.realtorApp.repository.RealtorRepository;
import br.com.realtor.realtorApp.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidenceManager {

    @Autowired
    private RealtorRepository realtorRepository;

    @Autowired
    private ResidenceRepository residenceRepository;

    public ResidenceDetailsData create(NewResidenceData data) {
        if (!realtorRepository.existsById(data.realtorId())) {
            throw new RuntimeException("Realtor Id does not exists");
        }

        var realtor = realtorRepository.getReferenceById(data.realtorId());
        var residence = new Residence(null, realtor, data.CEP(), data.residenceType(), data.address(),
                data.addressComplement(), data.totalBedrooms(), data.totalBathrooms(), true, null);
        residenceRepository.save(residence);
        residenceRepository.flush();

        return new ResidenceDetailsData(residence);
    }
}
