package br.com.workmade.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workmade.dto.EmpresaDto;
import br.com.workmade.response.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {


	@ApiOperation(value = "Cadastrar itens.", response = EmpresaDto.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 201, message = "Recurso criado com sucesso"),
	        @ApiResponse(code = 401, message = "Você não tem autorização"),
	        @ApiResponse(code = 403, message = "Proibido de ver estas informações"),
	        @ApiResponse(code = 404, message = "O recurso não foi encontrado"),
			@ApiResponse(code = 422, message = "O item não foi encontrado")
	})
	@PostMapping(value="/cadastrar")
	public ResponseEntity<Response<EmpresaDto>> cadastrar(@Valid @RequestBody EmpresaDto empresaDto,
			BindingResult result) {
		Response<EmpresaDto> response = new Response<EmpresaDto>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		empresaDto.setId(1L);
		response.setData(empresaDto);
		
		return ResponseEntity.ok(response);
	}

}
