package com.jntugv.exammanagement.audit;

import com.jntugv.exammanagement.model.AuthResponseDTO;
import com.jntugv.exammanagement.model.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserResponseDTO) {
                String name = ((UserResponseDTO) principal).getFullName();
            } else if (principal instanceof String) {
                return Optional.of((String) principal); // Directly return String
            }
        }

        return Optional.empty();
    }
}
