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
import sistema.rh.model.utils.NivelCargo;
import sistema.rh.utils.dao.CargoDAO;

public class CadastroNivelCargo extends Application {

	
	private GridPane cadNivelCargo;
	private Label lbCodNivel, lbNivel;
	private TextField txCodNivel, txNivel;
	private Button btGerarCodNiv, btCadastroNivel;
	
	
	public CadastroNivelCargo() {
		cadNivelCargo = new GridPane();
		
		lbCodNivel = new Label("Codigo Nivel");
		lbNivel = new Label("Nivel");
		
		txCodNivel = new TextField();
		txNivel = new TextField();
		
		btGerarCodNiv = new Button("Gerar Codigo");
		btCadastroNivel= new Button("Cadastrar Nivel");
	}
	
	private void comps() {
		cadNivelCargo.add(lbCodNivel, 0, 0);
		cadNivelCargo.add(lbNivel, 0, 1);
		cadNivelCargo.add(btGerarCodNiv, 2, 0);
		
		
		cadNivelCargo.add(txCodNivel, 1, 0);
		cadNivelCargo.add(txNivel, 1, 1);
		cadNivelCargo.add(btCadastroNivel, 1, 2);
		
		
		btGerarCodNiv.setOnAction(gcn->{
			int cargoCod = CodigosCargo.gerarCodNivel();
			txCodNivel.setText(Integer.toString(cargoCod));
		});
		
		btCadastroNivel.setOnAction(cn->{
			NivelCargo nc = new NivelCargo();
			CargoDAO cargoDAO = new CargoDAO();
			
			String siglaNivel = txCodNivel.getText();
			String nivelCargo = txNivel.getText();
			
			nc.setCodNivelCargo(siglaNivel);
			nc.setNivelCargo(nivelCargo);
			
			
			cargoDAO.cadastroNivel(nc);
		});
	}
	
	
	private void gPane() {
		cadNivelCargo.setPadding(new Insets(10, 10, 10, 10));
		cadNivelCargo.setVgap(10);
		cadNivelCargo.setHgap(10);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(cadNivelCargo,400,150);
		
		comps();
		gPane();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
