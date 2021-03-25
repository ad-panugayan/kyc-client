package com.asia.ph.kyc.presentation;

import com.asia.ph.kyc.core.namescreen.NameScreenRequest;
import com.asia.ph.kyc.core.namescreen.NameScreeningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class NameScreenController {

    private final NameScreeningService nameScreeningService;

    @Autowired
    public NameScreenController(NameScreeningService nameScreeningService) {
        this.nameScreeningService = nameScreeningService;
    }

    @PostMapping("/name-screen")
    public ResponseEntity<HttpStatus> nameScreen(@RequestBody NameScreenRequest nameScreenRequest) {
        log.info("[START] Received name screen request: {}", nameScreenRequest);

        nameScreeningService.nameScreen(nameScreenRequest);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
