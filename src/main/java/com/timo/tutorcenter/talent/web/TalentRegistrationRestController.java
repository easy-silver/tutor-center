package com.timo.tutorcenter.talent.web;

import com.timo.tutorcenter.global.web.SuccessResponse;
import com.timo.tutorcenter.talent.application.TalentRegistrationService;
import com.timo.tutorcenter.talent.web.dto.SelectTalentTypeRequest;
import com.timo.tutorcenter.talent.web.dto.TalentCreateResponse;
import com.timo.tutorcenter.talent.web.dto.SelectTalentTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/talents/registration")
@RestController
public class TalentRegistrationRestController {

    private final TalentRegistrationService service;

    @PostMapping("/step1")
    public SuccessResponse<TalentCreateResponse> selectTalentType(@RequestBody SelectTalentTypeRequest request) {
        return SuccessResponse.success(service.newTalent(request));
    }

    @GetMapping("/step1/{talentId}")
    public SuccessResponse<SelectTalentTypeResponse> getTalentType(@PathVariable Long talentId,
                                                                   @RequestParam Long ownerId) {
        return SuccessResponse.success(service.getTalentTypeAndCategory(talentId, ownerId));
    }
}
