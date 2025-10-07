# financial-scheduler

## Arquitetura

### Backend

Java 11 conforme requisito do teste.
Gradle foi utilizado pela sua simplicidade em comparação com o Maven.
ModelMapper simplificar mapeamento.
Lombok para redução de escrita de código.

### FrontEnd
Usando Angular com componentes ng-zorro-antd.

## Versões

### Backend
Spring Boot 2.7: a última versão compatível com Java 11.
ModelMapper e Lombok a última versão dispinível.

### Frontend
Angular 20.3
ng-zorro-antd 20.3

## Rodando a aplicação

### Backend

#### Windows
gradle buid
gradle run

#### Linux
./gradlew build
./gradlew bootRun ou ./gradlew run

### Frontend

#### Windows e Linux
npm run start
