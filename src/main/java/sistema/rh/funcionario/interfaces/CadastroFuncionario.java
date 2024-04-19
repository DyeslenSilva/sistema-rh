package sistema.rh.funcionario.interfaces;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sistema.rh.dao.FuncionarioDAO;
import sistema.rh.funcionario.utils.CEPFGenerator;
import sistema.rh.funcionario.utils.CPFGenerator;
import sistema.rh.model.Funcionario;
import sistema.rh.utils.dao.CargoDAO;
import sistema.rh.utils.dao.EstadoDAO;

public class CadastroFuncionario extends Application{

	private GridPane gPane;
	private Label lbCepf, lbCPF, lbNomeDoFuncionario,lbDDD;
	private Label lbTelCel,lbEndereco,lbNCasa, lbCidade, lbEstado;
	private Label lbCargo, lbNivel;
	private TextField txCepf, txCPF, txNomeDoFuncionario, txDDD;
	private TextField txTelCel,txEndereco,txNCasa, txCidade;
	private Button btGerarCepf, btGerarCPF, btCadastrarFuncionario;
	private ComboBox<String> cbEstados;
	private ComboBox<String> cbCargos;
	private ComboBox<String> cbNivel;
	
	
	public CadastroFuncionario() {
		gPane =new GridPane();
		
		lbCepf = new Label("CEPF");
		lbCPF = new Label("CPF");
		lbNomeDoFuncionario = new Label("Nome do Funcionario");
		lbDDD = new Label("DDD");
		lbTelCel = new Label("Telefone Celular");
		lbEndereco = new Label("Endereco");
		lbCargo = new Label("Cargo");
		lbNivel = new Label("Nivel");
		lbNCasa= new Label("N Casa");
		lbCidade = new Label("Cidade");
		lbEstado = new  Label("Estado");
		
		txCepf = new TextField();
		txCPF = new TextField();
		txNomeDoFuncionario = new TextField();
		txDDD = new TextField();
		txTelCel = new TextField();
		txEndereco = new TextField();
		txNCasa = new TextField();
		txCidade = new TextField();
		
		cbCargos = new ComboBox<String>();
		cbNivel = new ComboBox<String>();
		cbEstados = new ComboBox<String>();
		
		btGerarCepf = new Button("Gerar CEPF");
		btGerarCPF = new Button("Gerar CPF");
		btCadastrarFuncionario = new Button("Cadastrar Funcionario");
	}
	
	private void gridPane() {
		gPane.setPadding(new Insets(10,10,10,10));
		gPane.setHgap(10);
		gPane.setVgap(10);
	}
	
	private void labels() {
		gPane.add(lbCepf, 0, 0);
		gPane.add(lbCPF, 0, 1);
		gPane.add(lbNomeDoFuncionario, 0, 2);
		gPane.add(lbCargo, 0, 3);
		gPane.add(lbNivel, 0, 4);
		gPane.add(lbDDD, 0, 5);
		gPane.add(lbTelCel, 0,6);
		gPane.add(lbEndereco, 0,7);
		gPane.add(lbNCasa, 0, 8);
		gPane.add(lbCidade, 0, 9);
		gPane.add(lbEstado, 0, 10);
	}
		
	private void textField() {
		gPane.add(txCepf, 1, 0);
		gPane.add(txCPF, 1, 1);
		gPane.add(txNomeDoFuncionario, 1, 2);
		gPane.add(txDDD, 1, 5);
		gPane.add(txTelCel, 1, 6);
		gPane.add(txEndereco, 1, 7);
		gPane.add(txNCasa, 1, 8);
		gPane.add(txCidade, 1, 9);
	}
	
	private void button() {
		gPane.add(btGerarCepf, 2, 0);
		gPane.add(btGerarCPF, 2, 1);
		gPane.add(btCadastrarFuncionario, 1, 11);
	
		
		btGerarCepf.setOnAction(e->{
			int cepf = CEPFGenerator.gerarCEPF();
			txCepf.setText(Integer.toString(cepf));
		});
		
		btGerarCPF.setOnAction(e->{
			String cpf = CPFGenerator.generateCPF();
			txCPF.setText(cpf);
		});
		

		btCadastrarFuncionario.setOnAction(e -> {
		    String cepf = txCepf.getText().trim();
		    String cpf = txCPF.getText().trim();
		    String nomeFuncionario = txNomeDoFuncionario.getText().trim();
		    String cargo = cbCargos.getValue();
		    String nivel = cbNivel.getValue();
		    String dddStr = txDDD.getText().trim();
		    String telefone = txTelCel.getText().trim();
		    String endereco = txEndereco.getText().trim();
		    String nCasaStr = txNCasa.getText().trim();
		    String cidade = txCidade.getText().trim();
		    String estado = cbEstados.getValue();

		    try {
		        if (dddStr.isEmpty() || telefone.isEmpty()) {
		            throw new IllegalArgumentException("Os campos DDD e celular não podem ser vazios.");
		        }

		        if (!dddStr.matches("\\d+") || !telefone.matches("\\d+")) {
		            throw new IllegalArgumentException("Os campos DDD e celular devem conter apenas dígitos numéricos.");
		        }

		        int ddd = Integer.parseInt(dddStr);
		        if (ddd < 11 || ddd > 99) {
		            throw new IllegalArgumentException("O DDD deve estar entre 11 e 99.");
		        }

		        if (telefone.length() != 9) {
		            throw new IllegalArgumentException("O número de celular deve conter 9 dígitos (sem incluir o DDD).");
		        }

		        // Converter nCasa para inteiro
		        int nCasa = Integer.parseInt(nCasaStr);

		        // Crie um objeto Funcionario e defina seus atributos
		        Funcionario func = new Funcionario();
		        func.setCepf(cepf);
		        func.setCpf(cpf);
		        func.setNomeFuncionario(nomeFuncionario);
		        func.setCargo(cargo);
		        func.setNivel(nivel);
		        func.setDdd(ddd);
		        func.setTelCel(telefone);
		        func.setEndereco(endereco);
		        func.setNCasa(nCasa);
		        func.setCidade(cidade);
		        func.setEstado(estado);

		        FuncionarioDAO funcDAO = new FuncionarioDAO();
		        funcDAO.cadastroFuncionario(func);

		        System.out.println("Cadastro realizado com sucesso.");
		        ((Stage) btCadastrarFuncionario.getScene().getWindow()).close();
		    } catch (IllegalArgumentException ex) {
		        System.out.println("Erro ao cadastrar funcionário: " + ex.getMessage());
		    }
		});
	}
	
	
	private void combobox() {
		gPane.add(cbEstados, 1, 10);
		gPane.add(cbCargos, 1, 3);
		gPane.add(cbNivel, 1, 4);
		
		EstadoDAO estadoDAO = new EstadoDAO();
		List<String> estados = estadoDAO.getEstados();
		
		CargoDAO cargoDAO = new CargoDAO();
		List<String> cargos = cargoDAO.getCargos();
		List<String> nivelCargos = cargoDAO.getNivelCargo();
		
		cbEstados.getItems().addAll(estados);
		cbCargos.getItems().addAll(cargos);
		cbNivel.getItems().addAll(nivelCargos);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		gridPane();
		labels();
		textField();
		button();
		combobox();
		
		
		Scene scene = new Scene(gPane, 500,500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Cadastro de Funcionario");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
