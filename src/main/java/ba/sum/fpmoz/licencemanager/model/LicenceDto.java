package ba.sum.fpmoz.licencemanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LicenceDto {
    private Long id;
    private String serial;
    private LocalDateTime issuedDate;
    private LocalDateTime expiryDate;

}