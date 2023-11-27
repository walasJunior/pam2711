import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.icons.IconsOutlined
import androidx.compose.material3.icons.filled.Person
import androidx.compose.material3.icons.filled.School
import androidx.compose.material3.icons.outlined.ArrowBack
import androidx.compose.material3.icons.outlined.Person
import androidx.compose.material3.icons.outlined.School
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var currentScreen by remember { mutableStateOf(Screen.Main) }

    MaterialTheme {
        when (currentScreen) {
            Screen.Main -> MainScreen(onAlunoClick = { currentScreen = Screen.Aluno })
            Screen.Aluno -> AlunoScreen(onBackClick = { currentScreen = Screen.Main })
            Screen.Curso -> CursoScreen(onBackClick = { currentScreen = Screen.Main })
        }
    }
}

@Composable
fun MainScreen(onAlunoClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Aluno",
            tint = Color.Black,
            modifier = Modifier
                .size(100.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.primary)
                .clickable { onAlunoClick() }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Icon(
            imageVector = Icons.Default.School,
            contentDescription = "Curso",
            tint = Color.Black,
            modifier = Modifier
                .size(100.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.primary)
                .clickable { /* Navigate to Curso Screen */ }
        )
    }
}

@Composable
fun AlunoScreen(onBackClick: () -> Unit) {
    FormScreen("Aluno", onBackClick)
}

@Composable
fun CursoScreen(onBackClick: () -> Unit) {
    FormScreen("Curso", onBackClick)
}

@Composable
fun FormScreen(formName: String, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cadastro de $formName", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        // Add your form fields here
        Spacer(modifier = Modifier.height(16.dp))
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .size(50.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.primary)
                .clickable { onBackClick() }
        )
    }
}

enum class Screen {
    Main, Aluno, Curso
}
