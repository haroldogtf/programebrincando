package plp.programebrincando.arduino;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArduinoGenerator {

	private static String templatePath = null;
	private static String codePath = null;
	
	private static String getPath(String path) {
		String retorno = null;
		
		try {
			retorno =  new File(path).getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	private static String getTemplatePath() {
		
		if(templatePath != null) {
			return templatePath;
		} else {
			return getPath("../programebrincando/src/plp/programebrincando/arduino/template.ino");
		}

	}
	
	private static String getCodePath() {
		
		if(codePath != null) {
			return codePath;
		} else {
			return getPath("../programebrincando/src/plp/programebrincando/arduino/arduino.ino");
		}

	}
	
	private static void escreverAcao(String acao) {

		try {	
			StringBuilder string = new StringBuilder();
			
			BufferedReader in = new BufferedReader(new FileReader(getCodePath()));
			while (in.ready()) {
				String linha = in.readLine();
				
				if(linha.contains("@ACAO@")) {
					string.append("\t");
					string.append(acao);
					string.append("\n");
					string.append("\t//@ACAO@");
				} else {
					string.append(linha);
				}
				string.append("\n");
			}
			in.close();
			
			BufferedWriter out = new BufferedWriter(new FileWriter(getCodePath()));
			out.write(string.toString());
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void inicializarTemplate() {
		
		try {
	
			String templatePath = getTemplatePath();
			String codePath = getCodePath();
	
			File arquivoCodigo = new File(codePath);
			
			if(arquivoCodigo.exists()) {
				arquivoCodigo.delete();
			}
		
			arquivoCodigo.createNewFile();
				
			BufferedReader in = new BufferedReader(new FileReader(templatePath));
			BufferedWriter out = new BufferedWriter(new FileWriter(codePath));
			
			String linha;

			while (in.ready()) {
				linha = in.readLine();
	
				out.write(linha);
				out.write("\n");
			}

			in.close();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}
	
	public static void paraFrente(int valor) {
		escreverAcao("paraFrente(" + valor + ");");
	}
	
	public static void paraTras(int valor) {
		escreverAcao("paraTras(" + valor + ");");
	}
	
	public static void girarEsquerda(int valor) {
		escreverAcao("girarEsquerda(" + valor + ");");
	}
	
	public static void girarDireita(int valor) {
		escreverAcao("girarDireita(" + valor + ");");
	}
	
	public static void usarCaneta(boolean valor) {
		escreverAcao("usarCaneta(" + valor + ");");	
	}
	
	public static void corCaneta(int valor1, int valor2, int valor3) {
		escreverAcao("corCaneta(" + valor1 +"," +  valor2 + "," +valor3 +");");
	}
	
}
