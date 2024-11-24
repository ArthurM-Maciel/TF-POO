package aplicacao;

import dados.Drone;
import dados.DronePessoal;
import dados.DroneCargaInanimada;
import dados.DroneCargaViva;
import dados.Transporte;
import dados.TransportePessoas;
import dados.TransporteCargaInanimada;
import dados.TransporteCargaViva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ACMEAirDrones {

	public void executar() {
		String nomeArquivo = "SIMULA"; // Example file name without extension

		try {
			List<Drone> drones = lerDrones(nomeArquivo);
			List<Transporte> transportes = lerTransportes(nomeArquivo);

			// Process drones and transportes as needed
			System.out.println("Drones:");
			for (Drone drone : drones) {
				System.out.println(drone);
			}

			System.out.println("Transportes:");
			for (Transporte transporte : transportes) {
				System.out.println(transporte);
			}

		} catch (IOException e) {
			System.err.println("Error reading simulation files: " + e.getMessage());
		}
	}

	private List<Drone> lerDrones(String nomeArquivo) throws IOException {
		List<Drone> drones = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo + "-DRONES.CSV"))) {
			String linha;
			br.readLine(); // Skip header line
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(";");
				int tipo = Integer.parseInt(campos[0]);
				int codigo = Integer.parseInt(campos[1]);
				double custoFixo = Double.parseDouble(campos[2]);
				double autonomia = Double.parseDouble(campos[3]);
				if (tipo == 1) {
					int qtdMaxPessoas = Integer.parseInt(campos[4]);
					drones.add(new DronePessoal(codigo, custoFixo, autonomia, qtdMaxPessoas));
				} else if (tipo == 2) {
					double pesoMaximo = Double.parseDouble(campos[4]);
					boolean protecao = Boolean.parseBoolean(campos[5]);
					drones.add(new DroneCargaInanimada(codigo, custoFixo, autonomia, pesoMaximo, protecao));
				} else if (tipo == 3) {
					double pesoMaximo = Double.parseDouble(campos[4]);
					boolean climatizado = Boolean.parseBoolean(campos[5]);
					drones.add(new DroneCargaViva(codigo, custoFixo, autonomia, pesoMaximo, climatizado));
				}
			}
		}
		return drones;
	}

	private List<Transporte> lerTransportes(String nomeArquivo) throws IOException {
		List<Transporte> transportes = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo + "-TRANSPORTES.CSV"))) {
			String linha;
			br.readLine(); // Skip header line
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(";");
				int tipo = Integer.parseInt(campos[0]);
				int numero = Integer.parseInt(campos[1]);
				String nomeCliente = campos[2];
				String descricao = campos[3];
				double peso = Double.parseDouble(campos[4]);
				double latOrigem = Double.parseDouble(campos[5]);
				double longOrigem = Double.parseDouble(campos[6]);
				double latDestino = Double.parseDouble(campos[7]);
				double longDestino = Double.parseDouble(campos[8]);
				if (tipo == 1) {
					int qtdPessoas = Integer.parseInt(campos[9]);
					transportes.add(new TransportePessoas(numero, nomeCliente, descricao, peso, latOrigem, longOrigem, latDestino, longDestino, qtdPessoas));
				} else if (tipo == 2) {
					boolean perigosa = Boolean.parseBoolean(campos[9]);
					transportes.add(new TransporteCargaInanimada(numero, nomeCliente, descricao, peso, latOrigem, longOrigem, latDestino, longDestino, perigosa));
				} else if (tipo == 3) {
					double tempMin = Double.parseDouble(campos[9]);
					double tempMax = Double.parseDouble(campos[10]);
					transportes.add(new TransporteCargaViva(numero, nomeCliente, descricao, peso, latOrigem, longOrigem, latDestino, longDestino, tempMin, tempMax));
				}
			}
		}
		return transportes;
	}

	public static void main(String[] args) {
		ACMEAirDrones app = new ACMEAirDrones();
		app.executar();
	}
}