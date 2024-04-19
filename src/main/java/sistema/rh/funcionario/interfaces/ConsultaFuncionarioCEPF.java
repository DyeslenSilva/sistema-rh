package sistema.rh.funcionario.interfaces;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sistema.rh.dao.FuncionarioDAO;
import sistema.rh.model.Funcionario;

public class ConsultaFuncionarioCEPF extends Application{

	
	private GridPane consultaFuncCEPF;
	private Label lbCEPF;
	private TextField txCEPF;
	private Button btConsultaFuncionario;
	private TableView<Funcionario> tabelaFuncionarios;
	private TableColumn<Funcionario, String> clCEPF,clCPF,clNomeFuncionario;
	private TableColumn<Funcionario, Integer> clDDD, clNCasa;
	private TableColumn<Funcionario, String> clTelCel, clEndereco,clCidade,clEstado;
	private TableColumn<Funcionario, String> clCargo,clNivel;

	public ConsultaFuncionarioCEPF() {
		consultaFuncCEPF = new GridPane();
		
		lbCEPF = new Label("CEPF");
		
		txCEPF = new TextField();
		
		btConsultaFuncionario = new Button("Consultar Funcionario");
		
		tabelaFuncionarios = new TableView<>();
		
		clCEPF = new TableColumn<>("CEPF");
		clCPF = new TableColumn<>("CPF");
		clNomeFuncionario = new TableColumn<>("Nome do Funcionario");
		clDDD = new TableColumn<>("DDD");
		clTelCel= new TableColumn<>("Tel Cel");
		clCargo = new TableColumn<>("Cargo");
		clNivel = new TableColumn<>("Nivel");
		clEndereco = new TableColumn<>("Endereco");
		clNCasa = new TableColumn<>("N Casa");
		clCidade = new TableColumn<>("Cidade");
		clEstado = new TableColumn<>("Estado");
				
	}

	private void comps() {
		consultaFuncCEPF.add(lbCEPF, 0, 0);
		consultaFuncCEPF.add(txCEPF, 1, 0);
		consultaFuncCEPF.add(btConsultaFuncionario, 2, 0);
		
		btConsultaFuncionario.setOnAction(cf->{
			String cepf = txCEPF.getText();
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			Funcionario func= funcDAO.consultaFuncionarioPorCEPF(cepf);
			boolean funcNotNull = func!=null;
			if (funcNotNull) {
				ObservableList<Funcionario> funcs = FXCollections.observableArrayList();
				funcs.add(func);
				tabelaFuncionarios.setItems(funcs);
			}
			
		});
		
	}
	
	
	@SuppressWarnings("unchecked")
	private void setTable() {
		clCEPF.setCellValueFactory(new PropertyValueFactory<>("cepf"));
		clCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		clNomeFuncionario.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
		clDDD.setCellValueFactory(new PropertyValueFactory<>("ddd"));
		clTelCel.setCellValueFactory(new PropertyValueFactory<>("telCel"));
		clCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		clNivel.setCellValueFactory(new PropertyValueFactory<>("nivel"));
		clEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		clNCasa.setCellValueFactory(new PropertyValueFactory<>("nCasa"));
		clCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		clEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		
		clNomeFuncionario.setPrefWidth(200); // Define o tamanho preferencial da coluna
	    clTelCel.setPrefWidth(150); // Define o tamanho preferencial da coluna
	    clCargo.setPrefWidth(200); // Define o tamanho preferencial da coluna
	    clTelCel.setPrefWidth(150); // Define o tamanho preferencial da coluna
	    clEndereco.setPrefWidth(150); // Define o tamanho preferencial da coluna
	    
		
		
		tabelaFuncionarios.getColumns().addAll(clCEPF,clCPF,clNomeFuncionario,
				clDDD,clTelCel,clCargo,clNivel,clEndereco,clNCasa,clCidade,clEstado);
	}
	
	
	private void gPane() {
		consultaFuncCEPF.setPadding(new Insets(10,10,10,10));
		consultaFuncCEPF.setHgap(10);
		consultaFuncCEPF.setVgap(10);
		consultaFuncCEPF.add(tabelaFuncionarios, 0,1,55,1);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene cenario = new Scene(consultaFuncCEPF, 1400, 600);
		
		comps();
		setTable();
		gPane();
		primaryStage.setScene(cenario);
		primaryStage.setTitle("Consulta");
		primaryStage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
