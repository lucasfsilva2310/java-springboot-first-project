Maven/Gradle
-> São JDT ( Java Develpment Tools ) que servem para o build do projeto
https://stackify.com/gradle-vs-maven/#:~:text=Gradle%20and%20Maven%20fundamentally%20differ,%2C%20are%20the%20%E2%80%9Cworkhorses.%E2%80%9D
-> Maven é mais utilizado para build automáticos de projetos Java

Spring Initializer
-> Ao criar o projeto, os arquivos mvnw e mwnw.cmd são os arquivos de script de build. Nesse caso não precisamos instalar o maven localmente, como por exemplo instalamos o node para rodar os scripts de um package.json . o arquivo de comando do mvnw funciona como um wrapper, talvez como um Docker, um container, que tem essa dependência do mvnw dentro dele.

@PostContruct
->Utilizando o PostConstruct pra o cenário da nossa aplicação, eu pude criar uma lista de Runs dentro da memoria da minha aplicação toda vez que ela fosse iniciada.

Jdbc e h2database
-> Depois de adicionar as duas dependências jdbc e h2database, foi possível criar os arquivos schema.sql e data.sql para criar as tabelas e populá-las, também substituindo os métodos contidos no RunRepository e RunController, para que agora nós tenhamos um banco na memória da nossa aplicação, mas agora sendo instanciado como um banco de dados de fato.
