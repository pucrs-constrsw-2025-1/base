# Configurações de Debug - ConstrSW

Este arquivo documenta as configurações de debug disponíveis no VS Code para todos os serviços do projeto ConstrSW.

## Configurações Individuais

### Serviços Node.js/TypeScript

#### 1. OAuth Service
- **Porta de Debug**: 8281
- **Tipo**: Node.js (attach)
- **Localização**: `backend/oauth`

#### 2. BFF Service
- **Porta de Debug**: 8282
- **Tipo**: Node.js (attach)
- **Localização**: `backend/bff`

#### 3. Professors Service
- **Porta de Debug**: 8283
- **Tipo**: Node.js (attach)
- **Localização**: `backend/professors`

### Serviços Java/Spring Boot

#### 4. Classes Service
- **Porta de Debug**: 8284
- **Tipo**: Java (attach)
- **Localização**: `backend/classes`

#### 5. Courses Service
- **Porta de Debug**: 8285
- **Tipo**: Java (attach)
- **Localização**: `backend/courses`

#### 6. Resources Service
- **Porta de Debug**: 8287
- **Tipo**: Java (attach)
- **Localização**: `backend/resources`

#### 7. Rooms Service
- **Porta de Debug**: 8288
- **Tipo**: Java (attach)
- **Localização**: `backend/rooms`

#### 8. Students Service
- **Porta de Debug**: 8289
- **Tipo**: Java (attach)
- **Localização**: `backend/students`

#### 9. Reservations Service
- **Porta de Debug**: 8290
- **Tipo**: Java (attach)
- **Localização**: `backend/reservations`

### Serviços Python

#### 10. Lessons Service
- **Porta de Debug**: 8286
- **Tipo**: Python (attach)
- **Localização**: `backend/lessons`

### Frontend

#### 11. Frontend
- **Tipo**: Node.js (launch)
- **Localização**: `frontend`
- **Comando**: `npm start`

## Configurações Compostas (Compounds)

### Debug All Backend Services
Debug de todos os serviços backend simultaneamente:
- OAuth Service
- BFF Service
- Professors Service
- Classes Service
- Courses Service
- Lessons Service
- Resources Service
- Rooms Service
- Students Service
- Reservations Service

### Debug Core Services
Debug dos serviços principais:
- OAuth Service
- BFF Service
- Professors Service

### Debug Academic Services
Debug dos serviços acadêmicos:
- Classes Service
- Courses Service
- Lessons Service
- Students Service

### Debug Infrastructure Services
Debug dos serviços de infraestrutura:
- Resources Service
- Rooms Service
- Reservations Service

## Como Usar

### 1. Debug Individual
1. Abra o VS Code
2. Vá para a aba "Run and Debug" (Ctrl+Shift+D)
3. Selecione o serviço desejado no dropdown
4. Clique em "Start Debugging" (F5)

### 2. Debug Composto
1. Abra o VS Code
2. Vá para a aba "Run and Debug" (Ctrl+Shift+D)
3. Selecione uma configuração composta (ex: "Debug Core Services")
4. Clique em "Start Debugging" (F5)

### 3. Debug com Breakpoints
1. Abra o arquivo que deseja debugar
2. Defina breakpoints clicando na margem esquerda
3. Inicie o debug do serviço correspondente
4. Execute a ação que ativa o código com breakpoint

## Pré-requisitos

### Para Serviços Node.js
- Node.js instalado
- Extensão "Node.js" do VS Code

### Para Serviços Java
- Java JDK instalado
- Extensão "Extension Pack for Java" do VS Code
- Maven ou Gradle configurado

### Para Serviços Python
- Python instalado
- Extensão "Python" do VS Code

## Portas de Debug

| Serviço | Porta de Debug | Porta da API |
|---------|----------------|--------------|
| OAuth | 8281 | 8088 |
| BFF | 8282 | 8182 |
| Professors | 8283 | 8083 |
| Classes | 8284 | 8084 |
| Courses | 8285 | 8085 |
| Lessons | 8286 | 8086 |
| Resources | 8287 | 8087 |
| Rooms | 8288 | 8088 |
| Students | 8289 | 8089 |
| Reservations | 8290 | 8090 |

## Troubleshooting

### Problema: "Cannot connect to the target VM"
- Verifique se o serviço está rodando
- Confirme se a porta de debug está correta
- Verifique se o Docker está configurado para expor a porta de debug

### Problema: "Source maps not found"
- Para serviços Node.js, verifique se o TypeScript está compilando
- Para serviços Java, verifique se o projeto foi compilado

### Problema: "Breakpoints not hitting"
- Verifique se está debugando o serviço correto
- Confirme se o código está sendo executado
- Verifique se os source maps estão configurados corretamente

## Dicas

1. **Debug Remoto**: Todas as configurações são para debug remoto (attach), assumindo que os serviços estão rodando em containers Docker

2. **Hot Reload**: Os serviços Node.js suportam hot reload durante o debug

3. **Logs**: Use `console.log()` em Node.js ou `System.out.println()` em Java para logs adicionais

4. **Variables**: Use a aba "Variables" no debugger para inspecionar valores em tempo real

5. **Call Stack**: Use a aba "Call Stack" para navegar pela pilha de execução 