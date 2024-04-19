package sistema.rh.utils.interfaces;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sistema.rh.funcionario.utils.SorteioEstado;
import sistema.rh.model.utils.Estado;
import sistema.rh.utils.dao.EstadoDAO;

public class CadastroEstado extends Application {

	private GridPane gPane;
	private Label lbSigla, lbEstado;
	private TextField txSigla, txEstado;
	private Button btSortearSigla, btCadastrarEstado;
	
	public CadastroEstado() {
		gPane = new GridPane();
		
		lbSigla = new Label("Sigla");
		lbEstado = new Label("Estado");
		
		txSigla = new  TextField();
		txEstado = new TextField();
		
		btSortearSigla = new Button("Sortear Sigla");
		btCadastrarEstado = new Button("Cadastrar Estados");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(gPane, 400,110);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Cadastrar Estado");
		primaryStage.show();
		
		gPane();
		labels();
		textField();
		button();
	}
	
	
	private void gPane() {
		gPane.setPadding(new Insets(10,10,10,10));
		gPane.setHgap(10);
		gPane.setVgap(10);
	}
	
	private void labels() {
		gPane.add(lbSigla, 0, 0);
		gPane.add(lbEstado, 0, 1);
	}
	
	private void textField() {
		gPane.add(txSigla, 1, 0);
		gPane.add(txEstado, 1, 1);
	}
	
	private void button() {
		gPane.add(btCadastrarEstado, 0, 2);
		gPane.add(btSortearSigla, 2, 0);
		
		btSortearSigla.setOnAction(ac ->{
			String sortEstado = SorteioEstado.sorteioEstado();
			txSigla.setText(sortEstado);
		});
		
		
		btCadastrarEstado.setOnAction(ac ->{
			String sigla = txSigla.getText();
			String estado = txEstado.getText();
			
			Estado cadEstado = new Estado();
			EstadoDAO estadoDAO = new EstadoDAO();
			
			cadEstado.setSigla(sigla);
			cadEstado.setNomeEstado(estado);
			
			estadoDAO.cadastroEstado(cadEstado);
			System.out.println("Cadastrado com sucesso");
			((Stage) btCadastrarEstado.getScene().getWindow()).close();

		});
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
