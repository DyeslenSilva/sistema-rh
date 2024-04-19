package sistema.rh.funcionario.interfaces;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

public class ConsulltarFuncionarioPorCPF extends Application{

	
	private GridPane gPane;
	private Label lbCPF;
	private TextField txCPF;
	private Button btConsultar;
	
	private TableView<Funcionario> tabelaFuncionario;
	private TableColumn<Funcionario, String> clCEPF,clCPF,clNomeFuncionario;
	private TableColumn<Funcionario, String> clTelCel,clEndereco,clCidade,clEstado;
	private TableColumn<Funcionario, Integer> clDDD, clNcasa;
	private TableColumn<Funcionario, String> clCargo, clNivel;
	
	public ConsulltarFuncionarioPorCPF() {
		gPane = new GridPane();
		
		lbCPF = new Label("CPF");
		txCPF = new TextField();
		
		btConsultar = new Button("Consultar Funcionario");
	
		tabelaFuncionario = new TableView<>();
		
		clCEPF = new TableColumn<>("CEPF");
		clCPF = new TableColumn<>("CPF");
		clNomeFuncionario = new TableColumn<>("Nome do Funcionario");
		clDDD = new TableColumn<>("DDD");
		clTelCel = new TableColumn<>("Telefone Celular");
		clEndereco = new TableColumn<>("Endereco");
		clNcasa = new TableColumn<>("N Casa");
		clCidade = new TableColumn<>("Cidade");
		clEstado = new TableColumn<>("Estado");
		
		
		clCargo = new TableColumn<>("Cargo");
		clNivel = new TableColumn<>("Nivel");
	}
	
	
	@SuppressWarnings("unchecked")
	private void setTable() {
		clCEPF.setCellValueFactory(new PropertyValueFactory<>("cepf"));
		clCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		clNomeFuncionario.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
		clDDD.setCellValueFactory(new PropertyValueFactory<>("ddd"));
		clTelCel.setCellValueFactory(new PropertyValueFactory<>("telCel"));
		clEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		clNcasa.setCellValueFactory(new  PropertyValueFactory<>("nCasa"));
		clCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		clEstado.setCellValueFactory(new  PropertyValueFactory<>("estado"));
		
		
		clCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		clNivel.setCellValueFactory(new PropertyValueFactory<>("nivel"));
		
		
		tabelaFuncionario.getColumns().addAll(
		        clCEPF, clCPF, clNomeFuncionario, clDDD, clTelCel,
		        clCargo, clNivel, clEndereco, clNcasa, clCidade, clEstado
		    );
		
		clNomeFuncionario.setPrefWidth(200); // Define o tamanho preferencial da coluna
	    clTelCel.setPrefWidth(150); // Define o tamanho preferencial da coluna
	    clCargo.setPrefWidth(200); // Define o tamanho preferencial da coluna
	    clTelCel.setPrefWidth(150); // Define o tamanho preferencial da coluna
	    clEndereco.setPrefWidth(150); // Define o tamanho preferencial da coluna
	    
		
	}
	
	private void comps() {
		gPane.add(lbCPF, 0, 0);
		gPane.add(txCPF, 1, 0);
		gPane.add(btConsultar, 2, 0);
		
		
		btConsultar.setOnAction(soa->{
			String cpf = txCPF.getText();
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			Funcionario funcionario = funcDAO.consultaFuncionarioPorCPF(cpf);
			
			if(funcionario!=null) {
				ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();
				funcionarios.add(funcionario);
				
				tabelaFuncionario.setItems(funcionarios);
				
				
			}else {
				Alert telaAlerta = new Alert(AlertType.ERROR);
				telaAlerta.setTitle("Funcionario nao encontrado");
				telaAlerta.setHeaderText(null);
				telaAlerta.setContentText("Nenhum funcionário encontrado com o CPF fornecido.");
				telaAlerta.showAndWait();
			}
		});
		
	}
	
	


	
	public void start(Stage primaryStage) throws Exception {
		comps();
		gPane();
		setTable();
		Scene scene = new Scene(gPane,1400,600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Consulta por CPF");
		primaryStage.show();
	}
	
	
	
	private void gPane()	{
		gPane.setPadding(new Insets(10,10,10,10));
		gPane.setHgap(10);
		gPane.setVgap(10);
		
		gPane.add(tabelaFuncionario, 0, 1,55,1);
	}
	public static void main(String[] args) {
		launch(args);
	}

	
	
}
