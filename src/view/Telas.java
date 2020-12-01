package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {

	private static Stage primaryStage;

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}

	public static void main(String[] args) {

		launch();
	}

	public void start(Stage primaryStage) throws Exception {

		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Loja_de_Roupas 1.0");
		primaryStage.setMaximized(true);
		primaryStage.setFullScreen(true);
		primaryStage.setResizable(false);
		primaryStage.show();

		// telaInicial();
		telaProprietarioInicial();
	}

	public static void telaInicial() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("TelaInicial.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}

	public static void telaLoginProprietario() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("TelaLoginProprietario.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}

	public static void telaLoginGerente() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("TelaLoginGerente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}

	public static void telaLoginFuncionario() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("TelaLoginFuncionario.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}

	public static void telaProprietarioInicial() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("TelaProprietarioInicial.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}

	public static void telaGerenteInicial() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("TelaGerenteInicial.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}

	public static void telaFuncionarioInicial() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("TelaFuncionarioInicial.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
}
