package com.example.intentsolicitar3permison

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.Nullable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.intentsolicitar3permison.ui.theme.IntentSolicitar3permisonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntentSolicitar3permisonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SolicitarPermison(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SolicitarPermison(modifier: Modifier = Modifier) {

    val context = LocalContext.current


    val multiplePermissionsLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->

        var allGranted = true
        permissionsMap.forEach { (permission, isGranted) ->
            if (!isGranted) {
                allGranted = false
                return@forEach
            }
        }

        if (allGranted) {
            Toast.makeText(context, "Todos los permisos han sido aprobados.！", Toast.LENGTH_SHORT).show()
        } else {
            if (permissionsMap[Manifest.permission.CAMERA] == false) {
                Toast.makeText(context, "Permiso de cámara denegado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Se denegaron algunos permisos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {

            multiplePermissionsLauncher.launch(
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_CONTACTS,
                    Manifest.permission.CALL_PHONE
                )
            )
        }) {
            Text("Solicitar tres permisos")
        }
    }
}
