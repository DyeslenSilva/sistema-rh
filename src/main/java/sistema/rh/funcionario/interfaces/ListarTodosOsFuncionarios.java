package sistema.rh.funcionario.interfaces;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sistema.rh.dao.FuncionarioDAO;
import sistema.rh.model.Funcionario;

public class ListarTodosOsFuncionarios extends Application{

	private GridPane listaTodosFuncionarios;
	private TableView<Funcionario> todosOsFuncionarios;
	private TableColumn<Funcionario, String> clCEPF, clCPF, clNomeFuncionario;
	private TableColumn<Funcionario, String> clTelCel, clEndereco,clCidade,clEstado;
	private TableColumn<Funcionario, Integer>clDDD, clNCasa;
	private TableColumn<Funcionario, String> clCargo,clNivel;
	private Button btListaTodosFuncionarios;
	
	
	public ListarTodosOsFuncionarios() {
		listaTodosFuncionarios = new GridPane();
		todosOsFuncionarios = new TableView<Funcionario>();
		
		btListaTodosFuncionarios = new Button("Lista de Todos os Funcionarios");
		
		clCEPF = new TableColumn<>("CEPF");
		clCPF = new TableColumn<>("CPF");
		clNomeFuncionario = new TableColumn<>("Nome do Funcionario");
		clCargo = new TableColumn<>("Cargo");
		clNivel = new TableColumn<>("Nivel");
		clDDD = new TableColumn<>("DDD");
		clTelCel = new TableColumn<>("Tel Cel");
		clEndereco = new TableColumn<>("Endereco");
		clNCasa = new TableColumn<>("N casa");
		clCidade = new TableColumn<>("Cidade");
		clEstado = new TableColumn<>("Estado");
	}
	
	private void gridPane() {
		listaTodosFuncionarios.setPadding(new Insets(10,10,10,10));
		listaTodosFuncionarios.setHgap(10);
		listaTodosFuncionarios.setVgap(10);
		listaTodosFuncionarios.add(todosOsFuncionarios, 0, 1,55,1);
	}
	
	@SuppressWarnings("unchecked")
	private void setTable() {
		clCEPF.setCellValueFactory(new PropertyValueFactory<>("cepf"));
		clCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		clNomeFuncionario.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
		clCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		clNivel.setCellValueFactory(new PropertyValueFactory<>("nivel"));
		clDDD.setCellValueFactory(new PropertyValueFactory<>("ddd"));
		clTelCel.setCellValueFactory(new PropertyValueFactory<>("telCel"));
		clEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		clNCasa.setCellValueFactory(new PropertyValueFactory<>("nCasa"));
		clCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		clEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		
		todosOsFuncionarios.getColumns().addAll(clCEPF,clCPF,clNomeFuncionario,
					clCargo,clNivel,clDDD,clTelCel,clEndereco,clNCasa,clCidade,clEstado);
		
		clNomeFuncionario.setPrefWidth(200); // Define o tamanho preferencial da coluna
	    clTelCel.setPrefWidth(150); // Define o tamanho preferencial da coluna
	    clCargo.setPrefWidth(200); // Define o tamanho preferencial da coluna
	   
	    clCidade.setPrefWidth(200);
	    clTelCel.setPrefWidth(150); // Define o tamanho preferencial da coluna
	    clEndereco.setPrefWidth(150); // Define o tamanho preferencial da coluna
	    
	}
	
	private void comps() {
		listaTodosFuncionarios.add(btListaTodosFuncionarios, 0, 0);
		
		btListaTodosFuncionarios.setOnAction(ltf->{
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			
			List<Funcionario> todosFuncionarios =
					funcDAO.getAllFuncionarios();
			
			todosOsFuncionarios.setItems(FXCollections
							.observableArrayList(todosFuncionarios));
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(listaTodosFuncionarios,1500,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		comps();
		setTable();
		gridPane();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
