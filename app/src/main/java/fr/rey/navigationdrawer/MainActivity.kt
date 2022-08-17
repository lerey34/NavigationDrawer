package fr.rey.navigationdrawer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.rey.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			NavigationDrawerTheme {
				val scaffoldState = rememberScaffoldState()
				val viewModel = navViewModel()
				Log.e(
					"state:",
					viewModel.state.collectAsState().value!!.isOpen.toString()
				)
				Scaffold(
					scaffoldState = scaffoldState,
					topBar = {
						TopAppBar1(
							text = "TITLE",
							viewModel = viewModel
						)
					},
					drawerGesturesEnabled = viewModel.state.collectAsState().value!!.isOpen,
					drawerContent = {
						DrawerHeader()
						DrawerBody(
							items = listOf(
								MenuItem(
									id = "home",
									title = "Home",
									contentDescription = "Go to home screen",
									icon = Icons.Default.Home
								),
								MenuItem(
									id = "settings",
									title = "Settings",
									contentDescription = "Go to settings screen",
									icon = Icons.Default.Settings
								),
								MenuItem(
									id = "help",
									title = "Help",
									contentDescription = "Get help",
									icon = Icons.Default.Info
								),
							),
							onItemClick = {
								println("Clicked on ${it.title}")
							}
						)
					}
				) {
				
				}
			}
		}
	}
}