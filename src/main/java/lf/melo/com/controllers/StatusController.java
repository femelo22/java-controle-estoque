package lf.melo.com.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
public class StatusController {

	
	@GetMapping("/status")
	@ApiResponses(value = {
			@ApiResponse(code = 999, message = "Erro personalizado")
	})
	public ResponseEntity<String> status() {
		return ResponseEntity.ok().body("Ok");
	}
	
	
}
