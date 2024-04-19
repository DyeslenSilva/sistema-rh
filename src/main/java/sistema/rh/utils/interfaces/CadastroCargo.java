package sistema.rh.utils.interfaces;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sistema.rh.funcionario.utils.CodigosCargo;
import sistema.rh.model.utils.Cargo;
import sistema.rh.utils.dao.CargoDAO;

public class CadastroCargo extends Application{

	private GridPane cadastroCargo;
	private Label lbCodCargo, lbNomeCargo;
	private TextField txCodCargo, txNomeCargo;
	private Button btCadastarCargo,btGerarCodigoCargo;
	
	public CadastroCargo() {
		cadastroCargo = new GridPane();
		
		lbCodCargo = new Label("Codigo do Cargo");
		lbNomeCargo = new Label("Nome do Cargo");
		
		txCodCargo = new  TextField();
		txNomeCargo = new TextField();
		
		btCadastarCargo = new Button("Cadastrar Cargo");
		btGerarCodigoCargo = new Button("Gerar Codigo do Cargo");
	}
	
	
	private void gPane() {
		cadastroCargo.setPadding(new Insets(10,10,10,10));
		cadastroCargo.setHgap(10);
		cadastroCargo.setVgap(10);
	}
	
	private void comps() {
		cadastroCargo.add(lbCodCargo, 0, 0);
		cadastroCargo.add(lbNomeCargo, 0,1);
		
		cadastroCargo.add(txCodCargo, 1, 0);
		cadastroCargo.add(txNomeCargo, 1, 1);
		
		cadastroCargo.add(btGerarCodigoCargo, 2, 0);
		
		btGerarCodigoCargo.setOnAction(gcc->{
			int codCargo = CodigosCargo.gerarCodCargo();
			txCodCargo.setText(Integer.toString(codCargo));
		});
		cadastroCargo.add(btCadastarCargo, 1, 2);
		
		btCadastarCargo.setOnAction(cc->{
			int codCargo = Integer.parseInt(txCodCargo.getText());
			String nomeCargo = txNomeCargo.getText();
			
			Cargo cargo = new Cargo();
			CargoDAO cargoDAO = new CargoDAO();
			
			cargo.setCodCargo(codCargo);
			cargo.setNomeCargo(nomeCargo);
			
			cargoDAO.cadastroCargo(cargo);
			
		});
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(cadastroCargo,450,150);
		primaryStage.setScene(scene);
		primaryStage.show();
		comps();
		gPane();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
