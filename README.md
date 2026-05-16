delivery-api

Pequena API Spring Boot exemplo usada no repositório `delivery-api`.

Requisitos
- JDK 17 (recomendado) ou JDK 21 (se preferir).
- Maven wrapper está incluído (use `mvnw.cmd` no Windows).

Configurar JAVA_HOME (Windows PowerShell)
1. Instale um JDK (por exemplo, Temurin/OpenJDK 17).
2. No PowerShell (execute como usuário):

```powershell
[Environment]::SetEnvironmentVariable('JAVA_HOME', 'C:\\Program Files\\Java\\jdk-17.0.8', 'User')
# Feche e reabra o terminal após definir a variável
```

Verifique:

```powershell
java -version
.\mvnw.cmd -v
```

Comandos úteis (Windows PowerShell)

```powershell
.\mvnw.cmd clean package
.\mvnw.cmd spring-boot:run
.\mvnw.cmd test
```

Endpoints de exemplo
- GET /api/orders - lista pedidos
- POST /api/orders - cria pedido (body JSON com `customer` e `address`)

Exemplo cURL para criar um pedido:

```bash
curl -X POST http://localhost:8080/api/orders -H "Content-Type: application/json" -d '{"customer":"Alice","address":"Rua A, 123"}'
```

Resposta JSON esperada (exemplo):

```json
{
	"id": 1,
	"customer": "Alice",
	"address": "Rua A, 123"
}
```

H2 Console
- URL: http://localhost:8080/h2-console
- JDBC URL (padrão): `jdbc:h2:mem:deliverydb`

Test script
- Use `run-tests.ps1` (adicionado neste repositório) para checar `JAVA_HOME` e executar testes.
