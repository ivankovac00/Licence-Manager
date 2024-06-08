package ba.sum.fpmoz.licencemanager.service;

import ba.sum.fpmoz.licencemanager.entity.Licence;
import ba.sum.fpmoz.licencemanager.model.LicenceDto;

import java.util.List;

public interface LicenceService {
    List<LicenceDto> getAllByUserId(Long id);

    Licence save(LicenceDto licence, Long id);

    void delete(Long id);
}