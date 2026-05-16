## Objetivo

Fornecer instruções concisas para agentes de IA que vão trabalhar neste repositório Java/Spring Boot (projeto `delivery-api`). O foco é o conhecimento mínimo necessário para ser produtivo imediatamente.

## Visão geral do projeto

- Aplicação Spring Boot mínima com ponto de entrada em `src/main/java/com/deliverytechy/delivery_api/DeliveryApiApplication.java`.
- Build/test/execution com Maven (wrapper incluído: `mvnw`, `mvnw.cmd`).
- Configuração mínima em `src/main/resources/application.properties`.

## Comandos essenciais (Windows PowerShell)

- Instalar/buildar: `.\mvnw.cmd clean package`
- Executar em modo desenvolvimento: `.\mvnw.cmd spring-boot:run`
- Executar testes: `.\mvnw.cmd test`
- Executar jar gerado: `java -jar target\delivery-api-*.jar`

Obs: em Linux/macOS use `./mvnw` em vez de `.\mvnw.cmd`.

## Arquitetura e convenções detectadas

- Pacote base: `com.deliverytechy.delivery_api`. Note que há um underscore no nome do pacote — é atípico em Java, mas já existe no projeto; siga esse layout ao adicionar classes.
- Estrutura esperada: coloque controladores em `controller` (ex.: `com.deliverytechy.delivery_api.controller`), serviços em `service`, repositórios em `repository` e modelos em `model`.
- Classe principal: `DeliveryApiApplication` (Spring Boot `@SpringBootApplication`). Use-a como ponto de referência para execução/debug.

## Dependências e pontos de atenção no `pom.xml`

- Projeto usa `spring-boot-starter-parent` e `spring-boot-starter-web`.
- Há duplicidade/confusão nas propriedades Java (aparecem `21` e `17`) — verifique e alinhe a `java.version` antes de builds reproducíveis.
- `lombok` está declarado como `annotationProcessor` — para compilar corretamente localmente, IDEs precisam do plugin Lombok ou a dependência em `provided`/`compile` conforme preferir.
- Comentários indicam intenção de usar JPA/H2/DevTools, mas essas dependências não estão efetivamente listadas no `pom.xml`. Se for necessário persistência, adicione `spring-boot-starter-data-jpa` e `com.h2database:h2`.

## Padrões de código observáveis

- Testes: existe um teste de contexto com `@SpringBootTest` em `src/test/java/.../DeliveryApiApplicationTests.java`. Siga JUnit5/Mockito conforme já presente por padrão em `spring-boot-starter-test`.
- Injeção de dependência: usar anotações Spring (`@RestController`, `@Service`, `@Repository`, `@Component`) e construtores para testes fáceis.

## Exemplos rápidos (onde olhar)

- Ignition/main: `src/main/java/com/deliverytechy/delivery_api/DeliveryApiApplication.java`
- Config: `src/main/resources/application.properties` (atualmente contém `spring.application.name=delivery-api`).
- Teste base: `src/test/java/com/deliverytechy/delivery_api/DeliveryApiApplicationTests.java`.

## Trabalhos comuns do desenvolvedor

- Para adicionar uma nova API REST: crie um pacote `controller` sob o pacote base `com.deliverytechy.delivery_api` e adicione uma classe anotada com `@RestController` (ex.: `com.deliverytechy.delivery_api.controller.OrderController`). Use construtor para injeção de dependências.
- Para persistência: adicione as dependências `spring-boot-starter-data-jpa` e `com.h2database:h2` no `pom.xml`, crie entidades em `model` e repositórios em `repository` estendendo `JpaRepository<T, ID>`.
- Para debugging local: execute a aplicação via IDE apontando para o método main da classe `DeliveryApiApplication` ou use `.\\mvnw.cmd spring-boot:run` e conecte o debugger; adicione argumentos JVM se precisar habilitar depuração remota.
## Erros comuns e como diagnosticar

- Build falhando por versão Java: confira `mvn -v` e ajuste `java.version` no `pom.xml`.
- Lombok não reconhecido na IDE: instale plugin Lombok e habilite annotation processing.
- Dependências faltando (JPA/H2/devtools): verifique comentários no `pom.xml` e adicione libs conforme necessidade.

## Onde editar estas instruções

- Arquivo atual: `.github/copilot-instructions.md` (este arquivo). Atualize quando houver mudanças de estrutura, novos módulos ou workflows de CI.

Se algo ficou ambíguo (por exemplo: qual versão Java preferida, se haverá persistência), me diga qual decisão preferem e eu atualizo o arquivo.
