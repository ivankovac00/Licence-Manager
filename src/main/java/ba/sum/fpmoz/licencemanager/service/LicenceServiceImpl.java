package ba.sum.fpmoz.licencemanager.service;

import ba.sum.fpmoz.licencemanager.entity.Licence;
import ba.sum.fpmoz.licencemanager.entity.User;
import ba.sum.fpmoz.licencemanager.model.LicenceDto;
import ba.sum.fpmoz.licencemanager.repository.LicenceRepository;
import ba.sum.fpmoz.licencemanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LicenceServiceImpl implements LicenceService {

    private final LicenceRepository licenceRepository;
    private final UserRepository userRepository;

    public LicenceServiceImpl(LicenceRepository licenceRepository, UserRepository userRepository) {
        this.licenceRepository = licenceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Licence save(LicenceDto licenceDto, Long id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty()) return null;

        Licence licence = new Licence();
        licence.setSerial(licenceDto.getSerial());
        licence.setIssuedDate(licenceDto.getIssuedDate());
        licence.setExpiryDate(licenceDto.getExpiryDate());
        licence.setUser(user.get());
        return licenceRepository.save(licence);
    }

    @Override
    public List<LicenceDto> getAllByUserId(Long userId) {
        return licenceRepository.findAllByUserId(userId).stream().map(this::mapLicence).toList();
    }

    @Override
    public void delete(Long id) {
        licenceRepository.deleteById(id);
    }

    private LicenceDto mapLicence(Licence licence) {
        return new LicenceDto(licence.getId(), licence.getSerial(), licence.getIssuedDate(), licence.getExpiryDate());
    }
}