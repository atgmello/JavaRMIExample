package main;

import javax.rmi.PortableRemoteObject;
import java.rmi.*;
import javax.swing.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PartRepositoryReal extends UnicastRemoteObject implements PartRepository {

	private static AtomicInteger GERADOR_COD = new AtomicInteger(1000);
	ArrayList<Part> partsArmazenadas;
	String nomeArmazem;
	
	public PartRepositoryReal(String nomeArmazem) throws RemoteException{
		this.partsArmazenadas = new ArrayList<>();
		this.nomeArmazem = nomeArmazem;
		System.out.println("Repositorio criado com nome de armazem: " + this.nomeArmazem);
	}

	@Override
	public ArrayList<Part> getListaPart() throws RemoteException{
		System.out.println("\nEnviando lista de pecas armazenadas.");
		return this.partsArmazenadas;
	}

	@Override
	public Part getPart(int cod) throws RemoteException{
		Part p = null;

		System.out.println("\nSolicitacao de busca por pecas.");
		try{
			for (Part part : partsArmazenadas) {
				if(part.getCod()==cod){
					p = part;
					System.out.println("\nPeca encontrada. Cod: " + p.getCod());
				}
			}
		}
		catch(Exception e){
			System.out.println("\nNao foi possivel encontrar o item desejado."
					+"\nErro: "+e.toString());
		}
		
		return p;
	}

	@Override
	public void addPart(Part p) throws RemoteException{
		partsArmazenadas.add(p);
		System.out.println("\nAdicionada peca de codigo: " + p.getCod() 
				+ " a lista de pecas.");
	}

	@Override
	public String getNomeArmazem() throws RemoteException{
		System.out.println("Nome do armazem acessado. Retornando: " 
				+ this.nomeArmazem);
		return this.nomeArmazem;
	}

	@Override
	public int getCodNovaPeca() throws RemoteException{
		return GERADOR_COD.getAndIncrement();
	}

}
