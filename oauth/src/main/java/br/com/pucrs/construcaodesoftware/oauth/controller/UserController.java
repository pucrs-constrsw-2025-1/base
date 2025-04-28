package br.com.pucrs.construcaodesoftware.oauth.controller;

import br.com.pucrs.construcaodesoftware.oauth.dto.UserCreationDTO;
import br.com.pucrs.construcaodesoftware.oauth.dto.UserResponseDTO;
import br.com.pucrs.construcaodesoftware.oauth.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Usuários", description = "Endpoints para gerenciar usuários")
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Criar um novo usuário")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso",
            content = @Content(schema = @Schema(implementation = UserResponseDTO.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreationDTO userCreationDTO) {
        UserResponseDTO createdUser = userService.createUser(userCreationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping
    @Operation(summary = "Listar todos os usuários")
    @ApiResponse(responseCode = "200", description = "Usuários retornados com sucesso")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por ID")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable String id) {
        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
} 