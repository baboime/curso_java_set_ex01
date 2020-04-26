package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entidades.Log;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Log> set = new HashSet<>();
		
		System.out.println("Informe o diretório do arquivo: ");
		String strDiretorio = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(strDiretorio))){
			String linha = br.readLine();
			while (linha != null) {
				String[] campos = linha.split(" ");
				String usuario = campos[0];
				Date instante = Date.from(Instant.parse(campos[1]));
				
				set.add(new Log(usuario, instante));
				
				linha = br.readLine();
			}
			System.out.println("Total de usuários: " + set.size());
		}
		catch(IOException e) {
			System.out.println("Erro ao ler arquivo: " + e.getMessage());
		}
		sc.close();
	}

}
