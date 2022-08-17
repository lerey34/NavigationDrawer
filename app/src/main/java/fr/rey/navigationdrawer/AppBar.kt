package fr.rey.navigationdrawer

import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.*

@Composable
fun TopAppBar1(
	text: String,
	viewModel: navViewModel
) {
	val scope = rememberCoroutineScope()
	TopAppBar(
		title = { Text(text = text, fontSize = 18.sp) },
		navigationIcon = {
			IconButton(onClick = {
				scope.launch {
					withContext(Dispatchers.IO) { // should I keep this coroutine on background thread ?
						viewModel.openCloseDrawer()
					}
				}
			}) {
				Icon(Icons.Filled.Menu, "Menu")
			}
		},
		contentColor = MaterialTheme.colors.onPrimary,
	)
}