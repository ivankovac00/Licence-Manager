package ba.sum.fpmoz.licencemanager.repository;

import ba.sum.fpmoz.licencemanager.entity.Licence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicenceRepository extends JpaRepository<Licence, Long> {

    List<Licence> findAllByUserId(Long userId);
}