package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;

import entities.CCategoria;
import entities.CFaixaEtaria;
import entities.CFamilia;
import entities.CMarcacoes;
import entities.CProfissional;
import entities.CServicos;
import entities.CUtente;
import entities.ProfissionalExc;
import entities.ServicosExc;
import entities.UtenteExc;

public class Program {
	
	public static void main(String[] args) throws FileNotFoundException, UtenteExc, ProfissionalExc, ServicosExc{
	
	List<CMarcacoes> marcacao = new ArrayList<>();
	List<CServicos> servicos = new ArrayList<>();
	
	List<CFamilia> familias = new ArrayList<>();
	List<CFamilia> agregFamilia = new ArrayList<>();
	
	List<List<CProfissional>> profs = new ArrayList<>();
	List<CProfissional> profMed = new ArrayList<>();
	List<CProfissional> profEnf = new ArrayList<>();
	List<CProfissional> profAux = new ArrayList<>();
	
	List<CCategoria> categorias = new ArrayList<>();
	
	List<CUtente> utentes = new ArrayList<>();
	
	List<CFaixaEtaria> faixasEtaria = new ArrayList<>();
	
	
	CCategoria catMedicina = new CCategoria("Medicina", 1);
	CCategoria catEnfermagem = new CCategoria("Enfermagem", 2);
	CCategoria catAuxiliar = new CCategoria("Auxiliar", 3);
	categorias.add(catMedicina);
	categorias.add(catEnfermagem);
	categorias.add(catAuxiliar);

	CFaixaEtaria jovem = new CFaixaEtaria("Jovem", 1);
	CFaixaEtaria adulto = new CFaixaEtaria("Adulto", 2);
	CFaixaEtaria idoso = new CFaixaEtaria("Idoso", 3);
	faixasEtaria.add(jovem);
	faixasEtaria.add(adulto);
	faixasEtaria.add(idoso);
	
	CServicos consulta = new CServicos(1, "Consulta");
	CServicos pequenaCirurgia = new CServicos(2, "pequenaCirurgia");
	CServicos enfermagem = new CServicos(3, "Enfermagem");
	servicos.add(consulta);
	servicos.add(pequenaCirurgia);
	servicos.add(enfermagem);
	
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	
	while (true){
		System.out.println("************************************************************* \n");
		
		System.out.println("Registar Profissional (RP)");
		System.out.println("Registar Utente (RU)");
		System.out.println("Registar Familia (RF)");
		System.out.println("Associar Utente a Familia (AF)");
		System.out.println("Desassociar Utente a Familia (DF)");
		
		System.out.println("Listar Profissionais (LP)");
		System.out.println("Listar Utentes (LU)");
		System.out.println("Listar Familias (LF)");
		System.out.println("Mostrar Familia (MF) \n");
		
		System.out.println("Marcar Cuidados a utente (MC)");
		System.out.println("Cancelar Cuidados marcados a utente (CC) \n");
		
		System.out.println("Listar Cuidados marcados a Utente (LCU)");
		System.out.println("Listar Cuidados marcados a Familia (LCF)");
		System.out.println("Listar Servicos marcados a profissional (LSP)");
		System.out.println("Listar Marcacoes por tipo de servico (LMS) \n");
		
		System.out.println("Gravar (G)");
		System.out.println("Ler (L) \n");
		
		System.out.println("Encerrar o programa (X) \n");
		System.out.println("*************************************************************");
		
		String opcao = sc.next();
		
		if (opcao.equals("RP")) {
			
				String categoria = sc.next();
				String nome = sc.next();
			
				if(categoria.equals(catMedicina.getNomeCategoria())) {
					
					System.out.println();
					CProfissional profMedicina = new CProfissional(categoria, nome);
					profMed.add(profMedicina);
					profs.add(profMed);
					System.out.println("Profissional registado com sucesso");
					
				}
				
				else if(categoria.equals(catEnfermagem.getNomeCategoria())) {
				
					System.out.println();
					CProfissional profEnfermagem = new CProfissional(categoria, nome);
					profEnf.add(profEnfermagem);
					profs.add(profEnf);
					System.out.println("Profissional registado com sucesso.");
				}
				
				else if(categoria.equals(catAuxiliar.getNomeCategoria())) {
					System.out.println();
					CProfissional profAuxiliar = new CProfissional(categoria, nome);
					profAux.add(profAuxiliar);
					profs.add(profAux);
					System.out.println("Profissional registado com sucesso.");
				}
				else {
					System.out.println("Categoria Inexistente");
				}
		
		}
		
		else if (opcao.equals("RU")) {
		
					String nomeUtente = sc.next();
					String faixaEtaria = sc.next();
					System.out.println();
					CUtente utente = new CUtente(nomeUtente, faixaEtaria);
					if(faixaEtaria.equals(jovem.getNome()) || faixaEtaria.equals(adulto.getNome()) || faixaEtaria.equals(idoso.getNome())) {
						if(utentes.contains(utente)){
							System.out.println("Não deu");
						}
						else {
						System.out.println();
						utentes.add(utente);
						System.out.println("Utente registado com sucesso.");
						}
					}
					else {
						System.out.println("Faixa Etária Inexistente");
					}
		
				}
		
		else if (opcao.equals("RF")) {
					
					String nomeFamilia = sc.next();
					CFamilia familia = new CFamilia(nomeFamilia);
					
					
						familias.add(familia);
						System.out.println("Família registada com sucesso.");
					
				}
		
		else if (opcao.equals("AF")) {
			String nome = sc.next();
			String nomeFamilia = sc.next();
			Boolean utenteExiste = false;
			Boolean familiaExiste = false;
			
			for(CUtente utente :  utentes) {
				if(nome.equals(utente.nome)) {
					utenteExiste = true;
					for(CFamilia familia :  familias) {
						if(nomeFamilia.equals(familia.getNomeFamilia())) {
							familia.addUtente(utente);
							agregFamilia.add(familia);
							System.out.println("Utente associado a família");
						}
						familiaExiste = true;
					} 
					if(!familiaExiste){
						System.out.println("Familia Inexistente");
					}
				}
					
			}
			
			if(!utenteExiste) {
				System.out.println("Utente inexistente");
			}
		}
		
		else if (opcao.equals("DF")) {
				String nome = sc.next();
				String nomeFamilia = sc.next();
				Boolean utenteExiste = false;
				Boolean familiaExiste = false;
				
				for(CUtente utente :  utentes) {
					if(nome.equals(utente.nome)) {
						utenteExiste = true;
						for(CFamilia familia :  familias) {
							if(nomeFamilia.equals(familia.getNomeFamilia())) {
								familia.remUtente(utente);
								agregFamilia.add(familia);
								System.out.println("Utente desassociado de família");
							}
							familiaExiste = true;
						} 
						if(!familiaExiste){
							System.out.println("Familia Inexistente");
						}
					}
						
				}
				
				if(!utenteExiste) {
					System.out.println("Utente inexistente");
				}
			}
            
		else if (opcao.equals("LP")) {
			if(profs.isEmpty()){
             	System.out.println("Sem Profissionais Registados");
            	}
			 
			else{
            	 for (CProfissional profMed1 : profMed) {
            		System.out.print(profMed1.listarProfissional());
            	 }
			}
			for (CProfissional profEnf1 : profEnf) {
                System.out.print(profEnf1.listarProfissional());
				}
			
			for (CProfissional profAux1 : profAux) {
                System.out.print(profAux1.listarProfissional());
				}
			}
		
		else if(opcao.equals("LU")) {
			 if(utentes.isEmpty()){
            	System.out.println("Sem Utentes Registados");
            }
            else{
           	 for (CUtente utente1 : utentes) {
           		 System.out.print(utente1.listarUtente());
           }
		}
		}
		
		else if (opcao.equals("LF")) {
            if(familias.isEmpty()){
            	System.out.println("Sem Familias Registadas");
            }
            else{
            	for (CFamilia familia1 : familias) {
            	System.out.print(familia1.listarFamilia());
            	}
            }
		}
		
		else if (opcao.equals("MF")) {
            if(agregFamilia.isEmpty()){
            	System.out.println("Familia Inexistente");
            }
            else{
            	for (CFamilia familia1 : agregFamilia) {
            		System.out.print(familia1.listarAgregado());
            	}
            }
		}
		
		else if (opcao.equals("LCU")) {
			for(int i =0; i<marcacao.size(); i++) {
				
			}
		}
		
		else if (opcao.equals("MC")) {
			
			String nome = sc.next();
			
			Boolean utenteExiste = false;
			Boolean servicoExiste = false;
			Boolean categoriaExiste = false;
			
			for(CUtente utente :  utentes) {
				if(nome.equals(utente.nome)) {
					utenteExiste = true;
					String servico1 = sc.next();
					for(CServicos servico :  servicos) {
						if(servico1.equals(servico.getNome())) {
							servicoExiste = true;
							String categoria = sc.next();
							for(CCategoria cat1 : categorias) {
								if(categoria.equals(cat1.getNomeCategoria()))  {
									categoriaExiste = true;	
								}
								for(CMarcacoes mar : marcacao) {
									mar.addServico(servico);
								
									}
								}
							if(!categoriaExiste) {
								System.out.println("Categoria inexistente");
					
							}
						}
					}
			
					if(!servicoExiste) {
						System.out.println("Servico inexistente");
					}
					}
			}
				if(!utenteExiste) {
					System.out.println("Utente inexistente");
				}
			
			}
		
		else if (opcao.equals("G")) {
			try (PrintWriter out = new PrintWriter("filename.txt")) {
				
				for (CProfissional profMed1 : profMed) {
					out.print(profMed1.getNome());
	                out.print(" ");
	                out.print(profMed1.getCategoria());
	            }
				System.out.println("Unidade de saúde gravada.");
		    }
		}
		
		else if (opcao.equals("X")) {
			System.out.println("A encerrar o programa...");
			System.out.println("Obrigado pela visita");
			break;
		}
		
		
		}
	sc.close();
	}
}


	






