package com.ApiSpringHackathon.demo.controller;

import Services.Authentication.SWAuthenticationService;
import Services.Issue.SWIssueService;

import Services.Stamp.SWStampService;
import Utils.Responses.Authentication.SuccessAuthResponse;
import Utils.Responses.Stamp.SuccessV4Response;
//import Utils.Responses.Stamp.SuccessV1Response;
import Utils.Responses.Stamp.SuccessV4Response;
import com.ApiSpringHackathon.demo.model.ResponseDetails;
import com.ApiSpringHackathon.demo.utils.JsonConverter;
import com.ApiSpringHackathon.demo.utils.JwtTokenUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FacturacionController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @PostMapping("/crearFactura")
    public ResponseEntity<String> crearFactura(@RequestBody String request) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(request);
            String data = rootNode.path("data").asText();
            String dataFInal = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+data;

            System.out.println("Json as text: "+dataFInal);

            SWStampService sdk = new SWStampService("eduardoavilat2002@gmail.com", "wmxUyUq9#DaN", "https://services.test.sw.com.mx");

            SuccessV4Response response = null;
            response = (SuccessV4Response) sdk.Stamp(dataFInal, "v4");

            if(response.Status.equals("error")){
                return ResponseEntity.ok(response.message);
            }else{
                ResponseDetails responseDetails = new ResponseDetails();
                responseDetails.setStatus(response.Status);
                responseDetails.setMessage(response.message);
                responseDetails.setMessageDetail(response.messageDetail);
                responseDetails.setHttpStatus(response.HttpStatusCode);
                responseDetails.setData(response.cfdi);
                responseDetails.setUuid(response.uuid);
                responseDetails.setQrCode(response.qrCode);
                responseDetails.setCadenaTimbrado(response.cadenaOriginalSAT);
                responseDetails.setFechaTimbrado(response.fechaTimbrado);
                responseDetails.setSelloCFDI(response.selloCFDI);
                responseDetails.setSelloSAT(response.selloSAT);
                return ResponseEntity.ok(objectMapper.writeValueAsString(responseDetails));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.toString());
        }

    }
}