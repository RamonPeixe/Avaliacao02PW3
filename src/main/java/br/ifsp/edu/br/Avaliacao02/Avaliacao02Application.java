package br.ifsp.edu.br.Avaliacao02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Dupla:
// Filippa Bittencourt - SC3029832
// Ramon César Peixe   - SC3034992

@SpringBootApplication
public class Avaliacao02Application {

	public static void main(String[] args) {
		SpringApplication.run(Avaliacao02Application.class, args);

		PasswordEncoder encoder = new BCryptPasswordEncoder();

		//Gera Hash para senha "senha123" para criar um usuário no h2 com a senha criptografada (caso queira outra senha é só trocar a variável)
		String minhaSenha = "senha123";

		String hash = encoder.encode(minhaSenha);
		System.out.println("Sua senha '" + minhaSenha + "' em hash bcrypt é:");
		System.out.println(hash);

		//Foi criado já um usuário especialmente pra você professor. Usuário: carlao Senha: meda10
	}

}
