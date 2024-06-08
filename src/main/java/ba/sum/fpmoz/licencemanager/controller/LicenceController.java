package ba.sum.fpmoz.licencemanager.controller;

import ba.sum.fpmoz.licencemanager.model.CustomUserDetails;
import ba.sum.fpmoz.licencemanager.model.LicenceDto;
import ba.sum.fpmoz.licencemanager.service.LicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("licences")
public class LicenceController {

    @Autowired
    private UserDetailsService userDetailsService;

    private final LicenceService licenceService;

    public LicenceController(LicenceService licenceService) {
        this.licenceService = licenceService;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping()
    public String create(LicenceDto licenceDto, Principal principal) {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(principal.getName());
        licenceService.save(licenceDto, userDetails.getId());
        return "redirect:/home";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("{id}")
    public String delete(@PathVariable( value = "id") long id) {
        licenceService.delete(id);
        return "redirect:/home";
    }
}