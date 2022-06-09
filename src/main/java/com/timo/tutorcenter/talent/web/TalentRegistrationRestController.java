package com.timo.tutorcenter.talent.web;

import com.timo.tutorcenter.global.web.SuccessResponse;
import com.timo.tutorcenter.talent.application.TalentRegistrationService;
import com.timo.tutorcenter.talent.web.dto.SelectTalentTypeRequest;
import com.timo.tutorcenter.talent.web.dto.SelectTalentTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/talents/registration")
@RestController
public class TalentRegistrationRestController {

    private final TalentRegistrationService service;

    @PostMapping("/step1")
    public SuccessResponse<SelectTalentTypeResponse> selectTalentType(@RequestBody SelectTalentTypeRequest request) {
        return SuccessResponse.success(service.newTalent(request));
    }
}
