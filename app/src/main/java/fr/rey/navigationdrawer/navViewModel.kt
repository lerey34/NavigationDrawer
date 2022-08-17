package fr.rey.navigationdrawer

import android.util.Log
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class navViewModel : ViewModel() {
	private var _state =
		MutableStateFlow<DrawerState?>(DrawerState(DrawerValue.Open))
	var state = _state.asStateFlow()
	
	fun openCloseDrawer() {
		if (_state.value!!.isOpen) {
			Log.e("state1:", _state.value!!.isOpen.toString())
			_state.value = DrawerState(DrawerValue.Closed)
		} else {
			Log.e("state2:", _state.value!!.isOpen.toString())
			_state.value = DrawerState(DrawerValue.Open)
		}
	}
}