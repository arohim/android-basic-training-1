package com.him.mobile.android_basic_sharing_1

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.him.mobile.android_basic_sharing_1.compose.SecondScreen
import com.him.mobile.android_basic_sharing_1.compose.SignInScreen
import com.him.mobile.android_basic_sharing_1.ui.theme.Androidbasicsharing1Theme
import kotlinx.serialization.Serializable

@Serializable
data object Home

@Serializable
data class SecondScreenEntry(val text: String)

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        setContent {
            val navController = rememberNavController()
            Androidbasicsharing1Theme {
                NavHost(
                    navController = navController,
                    startDestination = Home
                ) {
                    composable<Home> {
                        SignInScreen(submit = {
                            navController.navigate(SecondScreenEntry(it))
                        })
                    }
                    composable<SecondScreenEntry> { backstack ->
                        val args = backstack.toRoute<SecondScreenEntry>()
                        SecondScreen(
                            text = args.text,
                            onNavigateBack = {
                                navController.navigateUp()
                            }
                        )
                    }
                }
            }
        }
    }
}