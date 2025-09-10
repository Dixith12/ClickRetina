package com.example.clickretina.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clickretina.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState(isLoading = true))
    val uiState: StateFlow<ProfileUiState> = _uiState

    init {
        fetchProfile()
    }

    private fun fetchProfile() {
        viewModelScope.launch {
            _uiState.value = ProfileUiState(isLoading = true)
            try {
                val profile = repository.getProfile()
                _uiState.value = ProfileUiState(user = profile, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = ProfileUiState(
                    error = e.message ?: "Something went wrong",
                    isLoading = false
                )
            }
        }
    }
}

