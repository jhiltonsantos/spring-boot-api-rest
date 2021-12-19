import 'package:to_beauty_app/presentation/resources/assets_manager.dart';

class AppConstants {
  static const API_URL = 'https://beauty-2.herokuapp.com';
  static const USER_CREATE = '$API_URL/user/';
  static const USER_GET = '$API_URL/';
  static const PROFILE_GET = '$API_URL/user/get/';
  static const LOGIN_USER = '$API_URL/api/token/';
  static const STORE_URL = '$API_URL/estabelecimento';
  static const STORE_GET_POST = '$API_URL/estabelecimento/';
  static const SERVICE_ALL_URL = '$API_URL/servico';
  static const USER_GET_NAME = '$API_URL/user/get/';
  static const AGENDA_URL = '$API_URL/horario/';
  static const OWNER_POST_URL = '$API_URL/user/proprietario/create/';
  static const String API_LOCATION_KEY =
      "AIzaSyD0qBxYechVt9ibozWktY8tfsdEQaIkgX4";

  // USANDO API REST SPRING BOOT
  static const SPRING_API = "http://10.0.2.2:8080";
  static const SPRING_API_LOGIN_USER = "$SPRING_API/auth";

  static String urlForReferenceImage(String photoReferenceId) {
    if (photoReferenceId == ImageAssets.logoImage) {
      return ImageAssets.logoImage;
    }
    return "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=$photoReferenceId&key=$API_LOCATION_KEY";
  }

  static String urlPlaceKeywordLocation(
      String keyword, double latitude, double longitude) {
    return "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=$latitude,$longitude&radius=1500&keyword=$keyword&key=$API_LOCATION_KEY";
  }
}

class AppStrings {
  static const String noRouteFound = "Rota não encontrada";
  static const String notImplemented = "Ainda não implementado";
  static const String nearToYou = "Perto de você";
  static const String failRequestMap = "Não foi possível realizar a pesquisa.";

  static const String listMap = "Lista de Salões";

  static const String appBarAgenda = "Agendamento";
  static const String titleService = "Qual serviço\nvocê deseja?";
}

class InitialStrings {
  static const String nameAppUpper = "2BEAUTY";
  static const String subtitleMainScreen =
      "Agende seu horário de\nqualquer lugar";
  static const String signupText = "Fazer\nCadastro";
  static const String loginText = "Fazer\nLogin";
}

class SingUpStrings {
  static const String titleSingUp = "Cadastre-se";
  static const String chooseOptionSignUp =
      "Faça seu cadastro com as seguintes opções:";
  static const String userNameTextField = "Nome de Usuário";
  static const String emailTextField = "Email";
  static const String passwordTextField = "Senha";
  static const String createAccount = "Criar conta";
  static const String haveAnAccountSingUp = "Já possui uma conta?";
  static const String doLoginPage = "Faça login";
  static const String failCreateDataUser =
      "Não foi possível realizar o cadastro. Verifique seus dados.";
}

class LoginStrings {
  static const String titleLogin = "Log In";
  static const String chooseOptionLogin =
      "Faça seu login com as seguintes opções:";
  static const String userTextField = "Usuário";
  static const String passwordTextField = "Senha";
  static const String entryAccount = "Log In";
  static const String dontHaveAccount = "Não possui uma conta?";
  static const String doCreatePage = "Inscrever-se";
  static const String failLoginDataUser = "Usuário ou senha incorretos";
}

class HomeStrings {
  static const String mapButton = "Perto de você";
  static const String perfilSideMenu = "Perfil";
  static const String createStoreSideMenu = "Criar negócio";
  static const String logOffStoreSideMenu = "Sair";
}

class CreateStoreStrings {
  static const String appBarCreateStore = "Cadastre seu negócio";
  static const String initForm = "Começar";
  static const String nameStoreField = "Nome do estabelecimento";
  static const String cnpjStoreField = "CNPJ do estabelecimento";
  static const String addressForm = "Endereço";
  static const String streetStoreField = "Rua";
  static const String districtStoreField = "Bairro";
  static const String cityStoreField = "Cidade";
  static const String numberStoreField = "Número";
  static const String cepStoreField = "CEP";
  static const String openStoreField = "Abre";
  static const String closeStoreField = "Fecha";
  static const String phoneStoreField = "Telefone";
  static const String currentLocationButton = "Pegar localização";
  static const String saveButton = "Criar";
}
